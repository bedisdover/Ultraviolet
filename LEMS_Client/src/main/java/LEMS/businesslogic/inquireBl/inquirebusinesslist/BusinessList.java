package LEMS.businesslogic.inquirebl.inquirebusinesslist;

import java.util.ArrayList;

import LEMS.businesslogic.inquirebl.inquirecostbenefitlist.MockIncomeBill;
import LEMS.businesslogic.inquirebl.inquirecostbenefitlist.MockPayBill;

public class BusinessList {
	String startTime;
	String endTime;
	ArrayList<MockPayBill> pay;
	ArrayList<MockIncomeBill> income;
	
	public BusinessList(String startTime,String endTime){
		this.startTime=startTime;
		this.endTime=endTime;
	}
	
	public ArrayList<MockPayBill> getPayBill(){
		pay=new ArrayList<MockPayBill>();
		MockPayBill b1=new MockPayBill("2015/10/25",21.3);
		MockPayBill b2=new MockPayBill("2015/10/26",22.1);
		pay.add(b1);
		pay.add(b2);
		return pay;
	}
	public ArrayList<MockIncomeBill> getIncomeBill(){
		income=new ArrayList<MockIncomeBill>();
		return income;
	}
}
