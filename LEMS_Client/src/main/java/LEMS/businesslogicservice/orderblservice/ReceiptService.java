package LEMS.businesslogicservice.orderblservice;

/**
 * @author 宋益明
 * 
 * 接收任务接口
 */
public interface ReceiptService extends AddOrderService{
	/**
	 * 生成接收单
	 * 
	 */
	public void createArrivalNote();
}
