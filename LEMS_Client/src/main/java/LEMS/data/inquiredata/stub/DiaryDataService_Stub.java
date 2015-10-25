package LEMS.data.inquiredata.stub;

import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.po.inquirepo.DiaryPO;

public class DiaryDataService_Stub implements DiaryDataService {

	public DiaryPO findDiary(String date) {
		// TODO Auto-generated method stub
		DiaryPO dpo=new DiaryPO("2015/10/25","add a payBill","add an incomeBill","approve an order","delete an account");
		return dpo;
	}

}
