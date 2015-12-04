package LEMS.businesslogicservice.orderblservice;

import LEMS.vo.ordervo.TransferVO;

/**
 * @author 宋益明
 * 
 * 中转接收任务接口
 */
public interface TransferService extends AddOrderService {
	/**
	 * 生成中转接收单
	 * 
	 * @param transferInfo 中转接收信息
	 */
	public void createTransferNote();
}
