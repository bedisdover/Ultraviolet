package LEMS.vo.ordervo;

import java.util.ArrayList;

/**
 * @author 宋益明
 * 
 * 中转单值对象
 */
public class TransferVO {
	/**
	 * 货物到达日期
	 */
	private String date;
	/**
	 * 中转单编号
	 */
	private String id;
	/**
	 * 订单列表
	 */
	private ArrayList<Long> orders;
	
	public TransferVO(String date, String id, ArrayList<Long> orders) {
		this.date = date;
		this.id = id;
		this.orders = orders;
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
}
