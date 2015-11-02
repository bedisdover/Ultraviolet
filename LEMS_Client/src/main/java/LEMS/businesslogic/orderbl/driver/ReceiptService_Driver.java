package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.ReceiptService_Stub;
import LEMS.vo.ordervo.ArrivalVO;

/**
 * @author 宋益明
 * 
 * 接收任务驱动程序
 */
public class ReceiptService_Driver {
	public void drive(ReceiptService_Stub receiptService_Stub) {
		receiptService_Stub.addOrder(123456);
		receiptService_Stub.createArrivalNote(new ArrivalVO("2015/10/23", "567812", null));
	}
}
