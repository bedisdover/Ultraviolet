package LEMS.businesslogic.inquirebl.driver;

import LEMS.businesslogicservice.inquireblservice.InquireCostBenefitListService;
import LEMS.vo.inquirevo.CostBenefitListVO;

/**
 * @author 章承尧
 * InquireCostBenefitListService的驱动程序
 */
public class InquireCostBenefitListService_Driver {
	public void drive(InquireCostBenefitListService inquireCostBenefitListService){
		CostBenefitListVO cbv=inquireCostBenefitListService.getCostBenefitList("2015/10/24", "2015/10/25");
		System.out.println(cbv.getStartTime()+"-"+cbv.getEndTime());
		System.out.println("total income: "+cbv.getTotalIncome());
		System.out.println("total expense: "+cbv.getTotalExpense());
		System.out.println("total benefit: "+cbv.getTotalBenefit());
	}
}
