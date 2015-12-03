package LEMS.businesslogicservice.inquireblservice;

import LEMS.vo.inquirevo.LogisticsInfoVO;

/**
 * @author 章承尧
 * 查询物流信息接口
 */
public interface InquireLogisticsInfoService {
	/**
	 * @param id
	 * @return
	 */
	public LogisticsInfoVO getLogisticsInfo(String id);
	//章承尧写注释啊！
	/**
	 * @param lvo
	 */
	public void updateLogisticsInfo(LogisticsInfoVO lvo);
}
