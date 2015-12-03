package LEMS.vo.ordervo;

import java.util.ArrayList;


/**
 * @author 宋益明
 * 
 * 货物到达单值对象
 */
public class ArrivalVO {
	/**
	 * 货物到达日期
	 */
	private String date;
	/**
	 * 到达单编号
	 */
	private String id;
	/**
	 * 订单列表
	 */
	private ArrayList<String> orders;
	
	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public ArrayList<String> getGoods() {
		return orders;
	}

	public ArrayList<String> getOrders() {
		return orders;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}
}
