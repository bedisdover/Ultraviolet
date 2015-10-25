package LEMS.data.inquiredata.driver;

import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;
import LEMS.po.inquirepo.LogisticsInfoPO;

public class LogisticsInfoDataService_Driver {
	public void drive(LogisticsInfoDataService logisticsInfoDataService){
		LogisticsInfoPO lpo=logisticsInfoDataService.findLogisticsInfo(123456);
		System.out.println("find logisticsInfo!");
		System.out.println(lpo.getId());
	}
}
