package LEMS.businesslogic.orderbl.stub;

import LEMS.businesslogicservice.orderblservice.TransferService;
import LEMS.vo.ordervo.TransferVO;

/**
 * @author 宋益明
 * 
 * 中转接收任务桩程序
 */
public class TransferService_Stub implements TransferService{

	public void createTransferNote(TransferVO transferInfo) {
		System.out.println("创建中转接收单成功！");
	}

	public void addOrder(long id) {
		System.out.println("添加订单成功");
	}

}
