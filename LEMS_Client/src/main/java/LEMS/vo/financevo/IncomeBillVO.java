package LEMS.vo.financevo;

import LEMS.po.informationpo.AccountPO;

/**
 * @author 宋益明
 * 
 * 收款单值对象（结算管理、成本管理）
 */
public class IncomeBillVO {
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
	private AccountPO account;

	public IncomeBillVO(String date, String institution, AccountPO account, double amount) {
		this.date = date;
		this.institution = institution;
		this.account = account;
		this.amount = amount;
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
	
	public AccountPO getAccount() {
		return account;
	}
}
