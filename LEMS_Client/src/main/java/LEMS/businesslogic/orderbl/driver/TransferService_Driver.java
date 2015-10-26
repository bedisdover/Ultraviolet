package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.TransferService_Stub;
import LEMS.vo.ordervo.TransferVO;

/**
 * @author 宋益明
 * 
 * 中转接收任务驱动程序
 */
public class TransferService_Driver {
	
	public void drive(TransferService_Stub transferService_Stub) {
		transferService_Stub.addOrder(123456);
		transferService_Stub.createTransferNote(new TransferVO("2015/10/23", 567812, null));
	}
}
