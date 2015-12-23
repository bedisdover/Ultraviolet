package LEMS.vo.ordervo;

/**
 * @author 宋益明
 *
 * 收款单值对象（记录收款单）
 */
public class IncomeBillVO {
	/**
	 * 收款日期
	 */
	private String date;
	/**
	 * 总金额
	 */
	private double amount;
	/**
	 * 揽件员
	 */
	private String collector;
	
	
	public String getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public String getCollector() {
		return collector;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCollector(String collector) {
		this.collector = collector;
	}
}
