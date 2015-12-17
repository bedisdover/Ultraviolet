package LEMS.vo.ordervo;

import java.util.ArrayList;

import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * 中转单值对象
 * 包括：	中转日期、到达地、
 * 		航班号（飞机）或车次号（火车、汽车）、
 * 		货柜号（飞机）或车厢号（火车）或押运员（汽车）、
 * 		监装员、所有托运单号
 */
public class TransferVO {
	
	/**
	 * 中转日期
	 */
	private String date;
	
	/**
	 * 到达地
	 */
	private String destination;
	
	/**
	 * 航班号（或车次号）
	 */
	private String flight;
	
	/**
	 * 货柜号（或车厢号、或押运员）
	 */
	private String container;
	
	/**
	 * 监装员
	 */
	private String superVision;
	
	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String getFlight() {
		return flight;
	}

	public String getContainer() {
		return container;
	}

	public String getSuperVision() {
		return superVision;
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public void setSuperVision(String superVision) {
		this.superVision = superVision;
	}

	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}
}
