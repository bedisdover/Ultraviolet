package LEMS.po.financepo;

import java.io.Serializable;

/**
 * @author 宋益明
 *
 * 收款单持久化对象（结算管理、成本管理）
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

	public IncomeBillPO(String date) {
		//TODO 根据日期获得收款单持久化对象
	}
	
	public IncomeBillPO(String date, String institution, double amount) {
		this.date = date;
		this.institution = institution;
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
}
