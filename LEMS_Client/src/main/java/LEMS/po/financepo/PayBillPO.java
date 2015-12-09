package LEMS.po.financepo;

import java.io.Serializable;

/**
 * @author 宋益明
 * 
 *         付款单持久化对象
 */
@SuppressWarnings("serial")
public class PayBillPO implements Serializable {
	/**
	 * 付款日期
	 */
	private String date;
	/**
	 * 付款单编号
	 */
	private String id;
	/**
	 * 付款单位
	 */
	private String institution;
	/**
	 * 付款金额
	 */
	private double amount;
	/**
	 * 付款人
	 */
	private String payer;
	/**
	 * 付款账号
	 */
	private String account;
	/**
	 * 付款条目
	 */
	private String item;
	/**
	 * 备注
	 */
	private String remark;

	public PayBillPO(String date, String id,String institution, double amount,
			String payer, String account, String item, String remark) {
		// TODO 根据付款单值对象生成持久化对象
		this.date = date;
		this.id=id;
		this.institution = institution;
		this.amount = amount;
		this.payer = payer;
		this.account = account;
		this.item = item;
		this.remark = remark;
	}

	public double getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public String getInstitution() {
		return institution;
	}

	public String getPayer() {
		return payer;
	}

	public String getAccount() {
		return account;
	}

	public String getItem() {
		return item;
	}

	public String getRemark() {
		return remark;
	}
	public String getId(){
		return id;
	}
}