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
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InquireFactory inquire = database.getInquireFactory();
			DiaryDataService diaryData=inquire.getDiaryData();
			DiaryPO dpo=new DiaryPO(dvo.getDate(),dvo.getOperation().get(0));
			diaryData.recordDiary(dpo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}	
}
