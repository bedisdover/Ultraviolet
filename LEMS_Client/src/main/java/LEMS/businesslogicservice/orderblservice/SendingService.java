package LEMS.businesslogicservice.orderblservice;

/**
 * @author 宋益明
 * 
 * 派件任务接口
 */
public interface SendingService extends AddOrderService{

	/**
	 * 生成派件单
	 */
	public void createDeliveryNote();
}
