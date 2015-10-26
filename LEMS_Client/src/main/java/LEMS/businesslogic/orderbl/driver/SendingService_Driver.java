package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.SendingService_Stub;
import LEMS.vo.ordervo.DeliveryVO;

/**
 * @author 宋益明
 * 
 * 派件任务驱动程序
 */
public class SendingService_Driver {
	
	public void drive(SendingService_Stub sendingService_Stub) {
		sendingService_Stub.addOrder(123456);
		sendingService_Stub.createDeliveryNote(new DeliveryVO());
	}
}
