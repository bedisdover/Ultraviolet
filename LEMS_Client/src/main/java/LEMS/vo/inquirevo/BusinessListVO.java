package LEMS.vo.inquirevo;

import java.util.ArrayList;

import LEMS.vo.financevo.IncomeBillVO;
import LEMS.vo.financevo.PayBillVO;

public class BusinessListVO {
	String startTime;
	String endTime;
	ArrayList<PayBillVO> pay;
	ArrayList<IncomeBillVO> income;
	
	public BusinessListVO(String s,String e,ArrayList<PayBillVO> ap,ArrayList<IncomeBillVO> ai){
		startTime=s;
		endTime=e;
		pay=ap;
		income=ai;
	}
	public String getStartTime(){
		return startTime;
	}
	public String getEndTime(){
		return endTime;
	}
	public ArrayList<PayBillVO> getPayBill(){
		return pay;
	}
	public ArrayList<IncomeBillVO> getIncomeBill(){
		return income;
	}
}
