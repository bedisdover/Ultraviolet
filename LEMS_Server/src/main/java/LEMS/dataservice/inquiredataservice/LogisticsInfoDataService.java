package LEMS.dataservice.inquiredataservice;

import LEMS.po.inquirepo.LogisticsInfoPO;

/**
 * @author 章承尧
 * 物流信息数据层接口
 */
public interface LogisticsInfoDataService {
	public LogisticsInfoPO findLogisticsInfo(long id);
}
