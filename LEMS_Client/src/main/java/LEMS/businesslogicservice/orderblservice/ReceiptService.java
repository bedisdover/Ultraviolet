package LEMS.businesslogicservice.orderblservice;

import LEMS.vo.ordervo.ArrivalVO;

/**
 * @author 宋益明
 * 
 * 接收任务接口
 */
public interface ReceiptService extends AddOrderService{
	/**
	 * 生成接收单
	 * 
	 * @param arrivalInfo 接收信息
	 */
	public void createArrivalNote(ArrivalVO arrivalInfo);
}
