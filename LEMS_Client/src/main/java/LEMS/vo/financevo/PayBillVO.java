package LEMS.vo.financevo;

import LEMS.po.userpo.UserPO;
import LEMS.vo.informationvo.AccountVO;

/**
 * @author 宋益明
 * 
 * 付款单值对象
 */
public class PayBillVO {
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
	private UserPO payer;
	/**
	 * 付款账号
	 */
	private AccountVO account;
	/**
	 * 付款条目
	 */
	private String item;
	/**
	 * 备注
	 */
	private String remark;
	
	public PayBillVO() {
		// TODO 默认构造函数
	}
	
	public PayBillVO(String date, String id, String institution, double amount, AccountVO account, String item,
			String remark) {
		this.date = date;
		this.id = id;
		this.institution = institution;
		this.amount = amount;
		this.account = account;
		this.item = item;
		this.remark = remark;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public String getInstitution() {
		return institution;
	}

	public double getAmount() {
		return amount;
	}

	public AccountVO getAccount() {
		return account;
	}

	public String getItem() {
		return item;
	}

	public String getRemark() {
		return remark;
	}

	public UserPO getPayer() {
		return payer;
	}
}
