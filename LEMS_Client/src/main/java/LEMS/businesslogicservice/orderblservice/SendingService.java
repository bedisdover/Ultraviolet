package LEMS.businesslogicservice.orderblservice;

import LEMS.vo.ordervo.DeliveryVO;

/**
 * @author 宋益明
 * 
 * 派件任务接口
 */
public interface SendingService extends AddOrderService{

	/**
	 * 生成派件单
	 * 
	 * @param deliveryInfo 派件信息
	 */
	public void createDeliveryNote(DeliveryVO deliveryInfo);
}
