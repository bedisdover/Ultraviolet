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
	 * 订单列表
	 */
	private ArrayList<Long> orders;
	
	/**
	 * 航班号
	 */
	private String flight;
	
	/**
	 * 到达地
	 */
	private String destination;
	
	/**
	 * 货柜号
	 */
	private String container;
	
	/**
	 * 监装员
	 */
	private String superVision;

	public String getDate() {
		return date;
	}

	public ArrayList<Long> getOrders() {
		return orders;
	}

	public String getFlight() {
		return flight;
	}

	public String getDestination() {
		return destination;
	}

	public String getContainer() {
		return container;
	}

	public String getSuperVision() {
		return superVision;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setOrders(ArrayList<Long> orders) {
		this.orders = orders;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public void setSuperVision(String superVision) {
		this.superVision = superVision;
	}
}
