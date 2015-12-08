package LEMS.businesslogic.inquirebl.inquirediary;

import java.rmi.Naming;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InquireFactory;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.po.inquirepo.DiaryPO;

public class Diary {
	String date;
	ArrayList<String> operation;
	public Diary(String d){
		date=d;
	}
	public ArrayList<String> getOperation(){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InquireFactory inquire=database.getInquireFactory();
			DiaryDataService dds=inquire.getDiaryData();
			ArrayList<DiaryPO> diaries=dds.findDiary(date);
			operation=new ArrayList<String>();
			for(DiaryPO dpo:diaries){
				operation.add(dpo.getOperation());
			}						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operation;
	}
}
