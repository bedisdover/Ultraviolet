package LEMS.businesslogic.inquirebl.driver;

import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.vo.inquirevo.DiaryVO;

/**
 * @author 章承尧
 * inquireDiaryService的驱动程序
 */
public class InquireDiaryService_Driver {
	public void drive(InquireDiaryService inquireDiaryService){
		DiaryVO dv=inquireDiaryService.getDiary("2015/10/25");
		System.out.println(dv.getDate());
		System.out.println(dv.getPayBillOperation());
		System.out.println(dv.getIncomeBillOperation());
		System.out.println(dv.getDocumentApproval());
		System.out.println(dv.getAccountManagement());
		System.out.println("gg");
	}
}

