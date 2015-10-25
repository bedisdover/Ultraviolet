package LEMS.data.inquiredata.driver;

import LEMS.dataservice.inquiredataservice.BusinessListDataService;
import LEMS.po.inquirepo.BusinessListPO;

public class BusinessListDataService_Driver {
	public void drive(BusinessListDataService businessListDataService){
		BusinessListPO bpo=businessListDataService.findBusinessList("2015/10/24","2015/10/25");
		System.out.println("find businessList!");
		System.out.println(bpo.getStartTime()+"-"+bpo.getEndTime());
	}
}
