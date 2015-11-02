package LEMS.data.inquiredata.stub;

import java.util.ArrayList;

import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;
import LEMS.po.inquirepo.LogisticsInfoPO;

public class LogisticsInfoDataService_Stub implements LogisticsInfoDataService {

	public LogisticsInfoPO findLogisticsInfo(long id) {
		// TODO Auto-generated method stub
		ArrayList<String> trace=new ArrayList<String>();
		trace.add("待发货");
		LogisticsInfoPO lpo=new LogisticsInfoPO("123456", trace);
		return lpo;
	}
	
}
