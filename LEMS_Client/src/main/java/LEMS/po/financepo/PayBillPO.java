package LEMS.po.financepo;

import java.io.Serializable;

import LEMS.vo.financevo.PayBillVO;
import LEMS.vo.informationvo.AccountVO;

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
	private AccountVO account;
	/**
	 * 付款条目
	 */
	private String item;
	/**
	 * 备注
	 */
	private String remark;
	
	public PayBillPO(PayBillVO payBillVO) {
		//TODO 根据付款单值对象生成持久化对象
	}
	public PayBillPO(String date) {
		//TODO 根据日期生成付款单持久化对象
	}
	
	public double getAmount() {
		return amount;
	}
}
