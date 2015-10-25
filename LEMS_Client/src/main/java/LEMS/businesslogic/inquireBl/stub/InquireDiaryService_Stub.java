package LEMS.businesslogic.inquirebl.stub;

import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.vo.inquirevo.DiaryVO;

/**
 * @author 章承尧
 * InquireDiaryService的桩程序
 */
public class InquireDiaryService_Stub implements InquireDiaryService {

	public DiaryVO getDiary(String date) {
		// TODO Auto-generated method stub
		DiaryVO dv=new DiaryVO("2015/10/25","add a PayBill","add an IncomeBill","approve a payBill","delete an account");
		return dv;
	}
}
