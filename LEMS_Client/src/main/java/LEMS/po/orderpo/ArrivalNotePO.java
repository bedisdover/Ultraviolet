package LEMS.po.orderpo;

import java.util.ArrayList;

/**
 * @author 宋益明
 *
 * 到达单持久化对象
 * 包括中转单编号、到达日期、出发地、托运订单条形码号
 */
public class ArrivalNotePO {
	
	/**
	 * 中转单编号
	 */
	private String id;
	
	/**
	 * 到达日期
	 */
	private String date;
	
	/**
	 * 出发地
	 */
	private String departure;
	
	/**
	 * 托运订单条形码号
	 */
	private ArrayList<OrderPO> orders;
	
	public String getId() {
		return id;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDeparture() {
		return departure;
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}
}
