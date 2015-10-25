package LEMS.vo.inquirevo;

/**
 * @author 章承尧
 * Diary的值对象
 */
public class DiaryVO {
	/**
	 * 日期
	 */
	String date;
	/**
	 * 对付款单的操作
	 */
	String payBillOperation;
	/**
	 * 对收款单的操作
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
	
	public DiaryVO(String d,String p,String i,String dc,String a){
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
