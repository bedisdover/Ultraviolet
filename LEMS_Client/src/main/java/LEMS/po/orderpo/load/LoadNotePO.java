package LEMS.po.orderpo.load;

import java.util.ArrayList;

import LEMS.po.orderpo.OrderPO;
import LEMS.po.userpo.UserPO;

/**
 * @author 宋益明
 * 
 * 装运单持久化对象
 */
public class LoadNotePO {
	
	/**
	 * 装运单ID
	 */
	private String id;
	/**
	 * （航运、货运、汽运）编号
	 */
	private String number;
	/**
	 * 装运日期
	 */
	private String date;
	/**
	 * 出发地
	 */
	private String departure;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 监装员
	 */
	private UserPO superVision;
	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	/**
	 * 运费
	 */
	private double passage;

	public String getDate() {
		return date;
	}

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}

	public UserPO getSuperVision() {
		return superVision;
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}

	public double getPassage() {
		return passage;
	}

	public String getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
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

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setSuperVision(UserPO superVision) {
		this.superVision = superVision;
	}

	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}

	public void setPassage(double passage) {
		this.passage = passage;
	}
}
