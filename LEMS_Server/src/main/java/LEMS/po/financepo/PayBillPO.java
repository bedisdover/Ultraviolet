package LEMS.po.financepo;

import java.io.Serializable;

import LEMS.po.informationpo.AccountPO;

/**
 * @author 宋益明
 * 
 * 付款单持久化对象
 */
@SuppressWarnings("serial")
public class PayBillPO implements Serializable {
	/**
	 * 付款日期
	 */
	private String date;
	/**
	 * 付款单位
	 */
	private String institution;
	/**
	 * 付款金额
	 */
	private double amount;
	//TODO 付款人
	private String fukuanren;
	/**
	 * 付款账号
	 */
	private AccountPO account;
	/**
	 * 付款条目
	 */
	private String item;
	/**
	 * 备注
	 */
	private String remark;
}
