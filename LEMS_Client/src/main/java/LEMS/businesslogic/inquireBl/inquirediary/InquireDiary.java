package LEMS.businesslogic.inquirebl.inquirediary;

import java.rmi.Naming;
import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.dataservice.DatabaseFactory;
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
		Diary diary=new MockDiary(date);
		DiaryVO dvo=new DiaryVO(date,diary.getOperation());
		return dvo;
	}
	
	public static void main(String[] args){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			DiaryDataService diary=database.getDiaryData();
			DiaryPO d=diary.findDiary("2015/10/25");
			System.out.println(d.getOperation());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}
}
