package LEMS.businesslogicservice.orderblservice;

/**
 * @author 宋益明
 * 
 * 装运管理任务接口
 */
public interface LoadService extends AddOrderService {
	/**
	 * 生成装车单
	 */
	public void createLoadNote();
}
