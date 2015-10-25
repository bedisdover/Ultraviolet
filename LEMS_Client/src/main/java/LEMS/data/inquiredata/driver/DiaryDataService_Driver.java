package LEMS.data.inquiredata.driver;

import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.po.inquirepo.DiaryPO;

public class DiaryDataService_Driver {
	public void drive(DiaryDataService diaryDataService){
		DiaryPO dpo=diaryDataService.findDiary("2015/10/25");
		System.out.println("find diary!");
		System.out.println(dpo.getDate());
	}
}
