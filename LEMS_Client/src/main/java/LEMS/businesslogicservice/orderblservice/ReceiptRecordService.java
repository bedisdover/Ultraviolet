package LEMS.businesslogicservice.orderblservice;

/**
 * @author 宋益明
 * 
 * 记录收款单任务接口
 */
public interface ReceiptRecordService extends AddOrderService {
	/**
	 * 生成收款单
	 * 
	 * @param income 收款信息
	 */
	public void createIncomeBill();
}
