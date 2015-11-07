package LEMS.businesslogic.inquirebl;

import java.rmi.Naming;
import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.po.inquirepo.DiaryPO;
import LEMS.vo.inquirevo.DiaryVO;

/**
 * @author 章承尧
 * inquireDiaryService接口的实现
 */
public class InquireDiary implements InquireDiaryService {
	public DiaryVO getDiary(String date) {
		// TODO Auto-generated method stub
		
		try {
			DiaryDataService diary=(DiaryDataService)Naming.lookup("rmi://localhost:1099/diary");
			DiaryPO d=diary.findDiary("2015/10/25");
			System.out.println(d.getPayBillOperation());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DiaryVO dvo=new DiaryVO("2015/10/25", "add a payBill", "add an incomeBill","approve an order", "delete an account");
		if(date.equals(dvo.getDate())){
			return dvo;
		}
		return dvo;
	}
	public static void main(String[] args){
		InquireDiary id=new InquireDiary();
		id.getDiary("2015/10/25");
	}
}
