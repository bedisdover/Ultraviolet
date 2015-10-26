package LEMS.businesslogic.orderbl.stub;

import LEMS.businesslogicservice.orderblservice.LoadService;
import LEMS.vo.ordervo.LoadVO;

/**
 * @author 宋益明
 * 
 * 装运管理任务桩程序
 */
public class LoadService_Stub implements LoadService {

	public void addOrder(long id) {
		System.out.println("添加成功！");
	}

	public void createLoadNote(LoadVO loadInfo) {
		System.out.println("创建装运单成功！");
	}

}
