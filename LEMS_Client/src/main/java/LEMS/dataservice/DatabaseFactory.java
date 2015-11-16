package LEMS.dataservice;

import java.rmi.Remote;


import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;

public interface DatabaseFactory extends Remote{
	public DiaryDataService getDiaryData();
	public CostBenefitListDataService getCostBenefitList();
}
