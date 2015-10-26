package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.ReceiptRecordService_Stub;
import LEMS.vo.ordervo.IncomeBillVO;

/**
 * @author 宋益明
 * 
 * 记录收款单任务驱动程序
 */
public class ReceiptRecordService_Driver {
	public void drive(ReceiptRecordService_Stub receiptRecordService_Stub) {
		receiptRecordService_Stub.addOrder(123456);
		receiptRecordService_Stub.createIncomeBill(new IncomeBillVO("2015/10/23", 563421, null, 0));
	}
}
