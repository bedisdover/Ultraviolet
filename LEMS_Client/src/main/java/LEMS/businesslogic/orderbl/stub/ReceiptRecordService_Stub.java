package LEMS.businesslogic.orderbl.stub;

import LEMS.businesslogicservice.orderblservice.ReceiptRecordService;
import LEMS.vo.ordervo.IncomeBillVO;

/**
 * @author 宋益明
 *
 * 记录收款单任务桩程序
 */
public class ReceiptRecordService_Stub implements ReceiptRecordService{

	public void addOrder(long id) {
		System.out.println("添加订单成功！");
	}

	public void createIncomeBill(IncomeBillVO income) {
		System.out.println("创建收款单成功！");
	}

}
