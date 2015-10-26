package LEMS.businesslogic.inquirebl;

import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.vo.inquirevo.DiaryVO;

/**
 * @author 章承尧
 * inquireDiaryService接口的实现
 */
public class InquireDiary implements InquireDiaryService {
	public DiaryVO getDiary(String date) {
		// TODO Auto-generated method stub
		DiaryVO dvo=new DiaryVO("2015/10/25", "add a payBill", "add an incomeBill","approve an order", "delete an account");
		if(date.equals(dvo.getDate())){
			return dvo;
		}
		return null;
	}
}
