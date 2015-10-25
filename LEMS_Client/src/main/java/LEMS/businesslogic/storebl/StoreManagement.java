package LEMS.businesslogic.storebl;

import java.util.ArrayList;

import LEMS.po.storepo.GoodsPO;

public class StoreManagement {
	public ArrayList<GoodsPO> inquire(String startTime,String endTime){
		return new  ArrayList<GoodsPO>();
	}
	
	public ArrayList<GoodsPO> check(){
		return new ArrayList<GoodsPO>();
	}
	
	public void warning(){
		int standardNum=0;
		ArrayList al=new ArrayList();
		al=check();
		int presentNum=(Integer) al.get(5);
		if(presentNum>=standardNum)
			System.out.println("Warning!");
	}

}
