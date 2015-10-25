package LEMS.businesslogicservice.storeblservice;

import java.util.ArrayList;

import LEMS.po.storepo.GoodsPO;

public interface StoreManagementService {
	public ArrayList<GoodsPO> inquire(String startTime,String endTime);
	
	public ArrayList<GoodsPO> check();
	
	public void warning();

}
