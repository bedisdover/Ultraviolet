package LEMS.data.inquiredata.driver;

import LEMS.data.inquiredata.stub.BusinessListDataService_Stub;
import LEMS.data.inquiredata.stub.CostBenefitListDataService_Stub;
import LEMS.data.inquiredata.stub.DiaryDataService_Stub;
import LEMS.data.inquiredata.stub.LogisticsInfoDataService_Stub;
import LEMS.dataservice.inquiredataservice.BusinessListDataService;
import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;

public class Client {
	public static  void main(String[] args){
		BusinessListDataService bld=new BusinessListDataService_Stub();
		BusinessListDataService_Driver businessDriver=new BusinessListDataService_Driver();
		businessDriver.drive(bld);
		
		System.out.println();
		
		CostBenefitListDataService cds=new CostBenefitListDataService_Stub();
		CostBenefitListDataService_Driver costBenefitDriver=new CostBenefitListDataService_Driver();
		costBenefitDriver.drive(cds);
		
		System.out.println();
		
		DiaryDataService ds=new DiaryDataService_Stub();
		DiaryDataService_Driver diaryDriver=new DiaryDataService_Driver();
		diaryDriver.drive(ds);
		
		System.out.println();
		
		LogisticsInfoDataService ls=new LogisticsInfoDataService_Stub();
		LogisticsInfoDataService_Driver logisticsDriver=new LogisticsInfoDataService_Driver();
		logisticsDriver.drive(ls);
	}
}
