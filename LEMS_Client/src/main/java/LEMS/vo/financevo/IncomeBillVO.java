package LEMS.vo.financevo;

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

	public IncomeBillVO(String date, String institution, double amount) {
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
