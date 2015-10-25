package LEMS.vo.inquirevo;

import java.util.ArrayList;

import LEMS.vo.financevo.PayBillVO;
import LEMS.vo.ordervo.IncomeBillVO;

/**
 * @author 章承尧
 * BusinessList的值对象
 */
public class BusinessListVO {	
	/**
	 * 开始日期
	 */
	String startTime;
	/**
	 * 结束日期
	 */
	String endTime;
	/**
	 * 付款单信息
	 */
	ArrayList<PayBillVO> pay;
	/**
	 * 收款单信息
	 */
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
