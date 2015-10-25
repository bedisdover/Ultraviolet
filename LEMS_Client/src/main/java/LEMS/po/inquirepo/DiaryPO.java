package LEMS.po.inquirepo;

import java.io.Serializable;

/**
 * @author 章承尧
 * 日志持久化对象
 */
@SuppressWarnings("serial")
public class DiaryPO implements Serializable{
	/**
	 * 日期
	 */
	String date;
	/**
	 * 付款单操作
	 */
	String payBillOperation;
	/**
	 * 收款单操作
	 */
	String incomeBillOperation;
	/**
	 * 审批单据操作
	 */
	String documentApproval;
	/**
	 * 账户管理操作
	 */
	String accountManagement;
	
	public DiaryPO(String d,String p,String i,String dc,String a){
		date=d;
		payBillOperation=p;
		incomeBillOperation=i;
		documentApproval=dc;
		accountManagement=a;
	}
	
	public String getDate(){
		return date;
	}
	public String getPayBillOperation(){
		return payBillOperation;
	}
	public String getIncomeBillOperation(){
		return incomeBillOperation;
	}
	public String  getDocumentApproval(){
		return documentApproval;
	}
	public String getAccountManagement(){
		return accountManagement;
	}
}
