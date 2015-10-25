package LEMS.businesslogic.inquirebl.driver;

import LEMS.businesslogic.inquirebl.stub.InquireBusinessListService_Stub;
import LEMS.businesslogic.inquirebl.stub.InquireCostBenefitListService_Stub;
import LEMS.businesslogic.inquirebl.stub.InquireDiaryService_Stub;
import LEMS.businesslogic.inquirebl.stub.InquireLogisticsInfoService_Stub;
import LEMS.businesslogicservice.inquireblservice.InquireBusinessListService;
import LEMS.businesslogicservice.inquireblservice.InquireCostBenefitListService;
import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.businesslogicservice.inquireblservice.InquireLogisticsInfoService;

/**
 * @author 章承尧
 * 测试inquireblservice
 */
public class Client {
	public static void main(String[] args){
		InquireDiaryService inquireDiaryService=new InquireDiaryService_Stub();
		InquireDiaryService_Driver diaryDriver=new InquireDiaryService_Driver();
		diaryDriver.drive(inquireDiaryService);
		
		System.out.println();
		
		InquireCostBenefitListService inquireCostBenefitListService=new InquireCostBenefitListService_Stub();
		InquireCostBenefitListService_Driver costBenefitDriver=new InquireCostBenefitListService_Driver();
		costBenefitDriver.drive(inquireCostBenefitListService);
		
		System.out.println();
		
		InquireLogisticsInfoService inquireLogisticsInfoService=new InquireLogisticsInfoService_Stub();
		InquireLogisticsInfoService_Driver logisticsInfoDriver=new InquireLogisticsInfoService_Driver();
		logisticsInfoDriver.drive(inquireLogisticsInfoService);
		
		System.out.println();
		
		InquireBusinessListService inquireBusinessListService=new InquireBusinessListService_Stub();
		InquireBusinessListService_Driver businessDriver=new InquireBusinessListService_Driver();
		businessDriver.drive(inquireBusinessListService);
	}
}
