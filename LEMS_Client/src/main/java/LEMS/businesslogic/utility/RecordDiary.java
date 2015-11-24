package LEMS.businesslogic.utility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.po.inquirepo.DiaryPO;
import LEMS.vo.inquirevo.DiaryVO;
import LEMS.dataservice.factory.InquireFactory;

public class RecordDiary {
	public void record(DiaryVO dvo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			InquireFactory inquire = database.getInquireFactory();
			DiaryDataService diaryData=inquire.getDiaryData();
			DiaryPO dpo=new DiaryPO(dvo.getDate(),dvo.getOperation().get(0));
			diaryData.recordDiary(dpo);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		RecordDiary f=new RecordDiary();
		java.util.ArrayList<String> s=new java.util.ArrayList<String>();
		s.add("新建账户");
		f.record(new DiaryVO("2015-11-24",s));
	}
}
