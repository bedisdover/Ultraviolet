package LEMS.businesslogic.inquirebl.inquirediary;

import LEMS.vo.inquirevo.DiaryVO;
import junit.framework.TestCase;

public class InquireDiaryTest extends TestCase {
	
	public void testInquireDiary(){
		MockDiary diary=new MockDiary("2015/10/25");
		InquireDiary inquire=new InquireDiary();
		DiaryVO dvo=inquire.getDiary(diary.operation.get(0));
		assertEquals("add an account.",dvo.getOperation().get(1));
	}	
}
