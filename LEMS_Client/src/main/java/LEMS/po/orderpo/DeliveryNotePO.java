package LEMS.po.orderpo;

import java.util.ArrayList;

import LEMS.po.userpo.UserPO;

/**
 * @author 宋益明
 *
 * 派件单持久化对象（派件任务生成）
 * 包括派件日期、托运订单条形码号、派送员
 */
public class DeliveryNotePO {
	
	/**
	 * 派件时间
	 */
	private String date;
	
	/**
	 * 托运订单条形码号
	 */
	private ArrayList<OrderPO> orders;
	
	/**
	 * 派送员
	 */
	private UserPO deliver;
	
	public String getDate() {
		return date;
	}
	
	public UserPO getDeliver() {
		return deliver;
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setDeliver(UserPO deliver) {
		this.deliver = deliver;
	}
	
	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}
}
