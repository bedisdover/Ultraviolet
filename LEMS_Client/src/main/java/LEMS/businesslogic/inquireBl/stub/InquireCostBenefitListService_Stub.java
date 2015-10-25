package LEMS.businesslogic.inquirebl.stub;

import LEMS.businesslogicservice.inquireblservice.InquireCostBenefitListService;
import LEMS.vo.inquirevo.CostBenefitListVO;

/**
 * @author 章承尧
 * InquireCostBenefitListService的桩程序
 */
public class InquireCostBenefitListService_Stub implements InquireCostBenefitListService {

	public CostBenefitListVO getCostBenefitList(String startTime, String endTime) {
		// TODO Auto-generated method stub
		CostBenefitListVO cbv=new CostBenefitListVO("2015/10/24","2015/10/25",520000,310000,210000);
		return cbv;
	}

}
