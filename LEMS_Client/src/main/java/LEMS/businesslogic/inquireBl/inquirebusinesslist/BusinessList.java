package LEMS.businesslogic.inquirebl.inquirebusinesslist;

import java.util.ArrayList;

import LEMS.businesslogic.inquirebl.inquirecostbenefitlist.CostBenefitList;
import LEMS.po.financepo.IncomeBillPO;
import LEMS.po.financepo.PayBillPO;

public class BusinessList {
	
	String startTime;
	String endTime;
	ArrayList<PayBillPO> pay;
	ArrayList<IncomeBillPO> income;
	
	public BusinessList(String startTime,String endTime){
		this.startTime=startTime;
		this.endTime=endTime;
	}
	
	public ArrayList<PayBillPO> getPayBill(){
		CostBenefitList cfl=new CostBenefitList(startTime,endTime);
		pay=cfl.getPayBill(startTime, endTime);
		return pay;
	}
	public ArrayList<IncomeBillPO> getIncomeBill(){
		CostBenefitList cfl=new CostBenefitList(startTime,endTime);
		income=cfl.getIncomeBill(startTime, endTime);
		return income;
	}
}
