package LEMS.po.financepo;

import java.io.Serializable;

/**
 * @author 宋益明
 *
 * 收款单持久化对象
 */
@SuppressWarnings("serial")
public class IncomeBillPO implements Serializable{
	/**
	 * 收款日期
	 */
	private String date;
	/**
	 * 收款单位
	 */
	private String institution;
	/**
	 * 收款金额
	 */
	private double amount;
	/**
	 * 收款账户
	 */
	private String account;
	public IncomeBillPO(String date, String institution, double amount,String account) {
		this.date = date;
		this.institution = institution;
		this.amount = amount;
		this.account=account;
	}

	public String getDate() {
		return date;
	}

	public String getInstitution() {
		return institution;
	}

	public double getAmount() {
		return amount;
	}
	
	public String getAccount(){
		return account;
	}
}
