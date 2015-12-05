package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.financepo.DocumentState;

/**
 * @author 宋益明
 *
 * 派件单持久化对象（派件任务生成）
 * 包括派件单ID、派件单状态、派件日期、托运订单条形码号、派送员
 */
public class DeliveryNotePO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 派件单ID
	 */
	private String id;
	
	/**
	 * 派件时间
	 */
	private String date;
	
	/**
	 * 托运订单条形码号
	 */
	private ArrayList<OrderPO> orders;
	
	/**
	 * 派件单状态
	 */
	private DocumentState state;
	
//	/**
//	 * 派送员
//	 */
//	private UserPO deliver;
	
	public String getId() {
		return id;
	}
	
	public String getDate() {
		return date;
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	public DocumentState getState() {
		return state;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}
	
	public void setState(DocumentState state) {
		this.state = state;
	}
}
