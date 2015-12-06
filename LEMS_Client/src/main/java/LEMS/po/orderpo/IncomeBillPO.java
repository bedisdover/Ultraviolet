package LEMS.po.orderpo;

import java.util.ArrayList;

import LEMS.po.financepo.DocumentState;

/**
 * @author 宋益明
 * 
 * 收款单持久化对象（记录收款单）
 * 收款单包括：
 * 		收款单ID、收款单状态、收款日期、收款金额、
 * 		收款快递员、对应的所有快递订单条形码号
 */
public class IncomeBillPO {
	private String id;
	
	private DocumentState state;
	
	private String date;
	
	private double amount;
	
	private String collector;
	
	private ArrayList<OrderPO> orders;
	
	public IncomeBillPO() {
		state = DocumentState.waiting;
	}

	public String getId() {
		return id;
	}

	public DocumentState getState() {
		return state;
	}

	public String getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public String getCollector() {
		return collector;
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setState(DocumentState state) {
		this.state = state;
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

	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}
}
