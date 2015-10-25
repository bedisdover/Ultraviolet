package LEMS.data.inquiredata.stub;

import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.po.inquirepo.CostBenefitListPO;

public class CostBenefitListDataService_Stub implements	CostBenefitListDataService {

	public CostBenefitListPO findCostBenefitList(String startTime,String endTime) {
		// TODO Auto-generated method stub
		CostBenefitListPO cpo=new CostBenefitListPO("2015/10/24","2015/10/25",500000,100000,400000);
		return cpo;
	}
	
}
