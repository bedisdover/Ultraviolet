package LEMS.dataservice;

import java.rmi.Remote;

import LEMS.data.inquiredata.CostBenefitListData;
import LEMS.data.inquiredata.DiaryData;

public interface DatabaseFactory extends Remote{
	public DiaryData getDiaryData();
	public CostBenefitListData getCostBenefitList();
}
