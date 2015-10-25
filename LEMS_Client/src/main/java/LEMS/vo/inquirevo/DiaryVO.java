package LEMS.vo.inquirevo;

/**
 * @author 章承尧
 * 日志的值对象
 */
public class DiaryVO {
	String date;
	String payBillOperation;
	String incomeBillOperation;
	String documentApproval;
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
