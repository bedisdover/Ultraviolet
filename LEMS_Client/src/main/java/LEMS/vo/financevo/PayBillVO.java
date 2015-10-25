package LEMS.vo.financevo;

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
	private AccountVO account;
	/**
	 * 付款条目
	 */
	private String item;
	/**
	 * 备注
	 */
	private String remark;
}
