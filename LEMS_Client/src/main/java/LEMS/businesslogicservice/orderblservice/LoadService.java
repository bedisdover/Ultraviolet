package LEMS.businesslogicservice.orderblservice;

import LEMS.vo.ordervo.LoadVO;

/**
 * @author 宋益明
 * 
 * 装运管理任务接口
 */
public interface LoadService extends AddOrderService {
	/**
	 * 生成装车单
	 * 
	 * @param loadInfo
	 */
	public void createLoadNote(LoadVO loadInfo);
}
