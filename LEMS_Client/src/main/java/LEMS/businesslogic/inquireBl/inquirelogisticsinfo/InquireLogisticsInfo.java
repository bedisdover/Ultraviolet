package LEMS.businesslogic.inquirebl.inquirelogisticsinfo;

import LEMS.businesslogicservice.inquireblservice.InquireLogisticsInfoService;
import LEMS.vo.inquirevo.LogisticsInfoVO;

/**
 * @author 章承尧
 * inquireLogisticsInfoService接口的实现
 */
public class InquireLogisticsInfo implements InquireLogisticsInfoService{

	public LogisticsInfoVO getInquireLogisticsInfo(String id) {
		LogisticsInfo logisInfo=new LogisticsInfo(id);
		if(logisInfo.getLogisticsInfo()!=null){
			LogisticsInfoVO lovo=new LogisticsInfoVO(id,logisInfo.getLogisticsInfo());
			return lovo;
		}
		else{
			return null;
		}		
	}
	
}
