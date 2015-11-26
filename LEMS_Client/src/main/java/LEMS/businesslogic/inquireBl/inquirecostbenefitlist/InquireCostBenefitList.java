package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

import LEMS.businesslogicservice.inquireblservice.InquireCostBenefitListService;
import LEMS.vo.inquirevo.CostBenefitListVO;

/**
 * @author 章承尧
 * inquireCostBenefitListService接口的实现
 */
public class InquireCostBenefitList implements InquireCostBenefitListService {

	public CostBenefitListVO getCostBenefitList(String startTime, String endTime) {
		CostBenefitList cbl=new CostBenefitList(startTime,endTime);
		CostBenefitListVO cvo=new CostBenefitListVO(startTime,endTime,cbl.totalIncome,cbl.totalExpense,cbl.totalProfit);
		return cvo;
	}

}
