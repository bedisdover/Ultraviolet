package LEMS.vo.ordervo;

import java.util.ArrayList;

import LEMS.po.orderpo.OrderPO;
import LEMS.po.userpo.UserPO;

/**
 * @author 宋益明
 * 派件单值对象
 */
public class DeliveryVO {

	
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
