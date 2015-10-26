package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.LoadService_Stub;
import LEMS.vo.ordervo.LoadVO;
import LEMS.vo.ordervo.TransportType;

/**
 * @author 宋益明
 * 
 * 装运管理驱动程序
 */
public class LoadService_Driver {
	
	public void drive(LoadService_Stub loadService_Stub) {
		loadService_Stub.addOrder(123456);
		LoadVO loadVO = new LoadVO("2015/10/23", 352431, null, "南京市中转中心", TransportType.railway, 1412);
		loadService_Stub.createLoadNote(loadVO);
	}
}
