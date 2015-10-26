package LEMS.businesslogic.orderbl.stub;

import LEMS.businesslogicservice.orderblservice.SendingService;
import LEMS.vo.ordervo.DeliveryVO;

/**
 * @author 宋益明
 * 
 * 派件任务桩程序
 */
public class SendingService_Stub implements SendingService {

	public void addOrder(long id) {
		System.out.println("添加订单成功！");
	}

	public void createDeliveryNote(DeliveryVO deliveryInfo) {
		System.out.println("创建派件单成功！");		
	}

}
