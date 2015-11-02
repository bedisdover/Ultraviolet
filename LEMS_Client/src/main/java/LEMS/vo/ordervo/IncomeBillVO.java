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
	 * 收款单编号
	 */
	private String id;
	/**
	 * 订单列表
	 */
	private ArrayList<Long> orders;
	/**
	 * 总金额
	 */
	private double sum;
	
	public IncomeBillVO(String date, String id, ArrayList<Long> orders, double sum) {
		this.date = date;
		this.id = id;
		this.orders = orders;
		this.sum = sum;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public ArrayList<Long> getOrders() {
		return orders;
	}

	public double getSum() {
		return sum;
	}
}
