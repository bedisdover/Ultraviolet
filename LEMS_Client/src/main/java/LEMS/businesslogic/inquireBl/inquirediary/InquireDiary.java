package LEMS.businesslogic.inquirebl.inquirediary;

import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.vo.inquirevo.DiaryVO;

/**
 * @author 章承尧 inquireDiaryService接口的实现
 */
public class InquireDiary implements InquireDiaryService {

	public DiaryVO getDiary(String date) {
		Diary diary = new Diary(date);
		DiaryVO dvo = new DiaryVO(date, diary.getOperation());
		return dvo;
	}
}
