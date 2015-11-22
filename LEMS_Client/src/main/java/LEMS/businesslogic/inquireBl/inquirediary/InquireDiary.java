package LEMS.businesslogic.inquirebl.inquirediary;

import java.rmi.Naming;
import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.dataservice.factory.DatabaseFactory;
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
	

	
		

	
}
