package LEMS.businesslogic.inquirebl.driver;

import LEMS.businesslogic.inquirebl.stub.InquireDiaryService_Stub;
import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;

/**
 * @author 章承尧
 * 测试inquireblservice
 */
public class Client {
	public static void main(String[] args){
		InquireDiaryService inquireDiaryService=new InquireDiaryService_Stub();
		InquireDiaryService_Driver driver=new InquireDiaryService_Driver();
		driver.drive(inquireDiaryService);
	}
}
