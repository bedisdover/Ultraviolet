package LEMS.businesslogicservice.inquireblservice;

import LEMS.vo.inquirevo.LogisticsInfoVO;

/**
 * @author 章承尧
 * 查询物流信息接口
 */
public interface InquireLogisticsInfoService {
	/**
	 * @param id
	 * @return LogisticsInfoVO
	 * 根据订单号获得物流信息
	 */
	public LogisticsInfoVO getLogisticsInfo(String id);
	/**
	 * @param lvo
	 * 更新物流信息
	 */
	public void updateLogisticsInfo(LogisticsInfoVO lvo);
}
