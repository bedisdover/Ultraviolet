package LEMS.vo.ordervo;

import java.util.ArrayList;

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
	 * 订单列表
	 */
	private ArrayList<Long> orders;
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

	public ArrayList<Long> getOrders() {
		return orders;
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

	public void setOrders(ArrayList<Long> orders) {
		this.orders = orders;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCollector(String collector) {
		this.collector = collector;
	}
}
