package LEMS.data.inquiredata.driver;

import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.po.inquirepo.CostBenefitListPO;

public class CostBenefitListDataService_Driver {
	public void drive(CostBenefitListDataService costBenefitListDataService){
		CostBenefitListPO cpo=costBenefitListDataService.findCostBenefitList("2015/10/24", "2015/10/25");
		System.out.println("find costBenefitList!");
		System.out.println(cpo.getStartTime()+"-"+cpo.getEndTime());
	}
}
