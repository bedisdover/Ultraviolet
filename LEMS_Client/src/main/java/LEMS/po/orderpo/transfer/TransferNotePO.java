package LEMS.po.orderpo.transfer;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * 中转单持久化对象
 * 中转单包含：
 * 		中转单编号（中转中心编号+日期+0000000七位数字）、
 * 		中转单状态、日期、航班号、出发地、到达地、
 * 		货柜号、监装员、本次装箱所有托运单号、运费
 */
public class TransferNotePO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 中转单编号
	 */
	private String id;
	
	/**
	 * 中转单状态
	 */
	private DocumentState state;
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 航班号
	 */
	private String flight;
	
	/**
	 * 出发地
	 */
	private String departure;
	
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
	
	/**
	 * 托运订单
	 */
	private ArrayList<OrderPO> orders;
	
	/**
	 * 运费
	 */
	private double passage;
	
	public TransferNotePO() {
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

	public String getFlight() {
		return flight;
	}

	public String getDeparture() {
		return departure;
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

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}

	public double getPassage() {
		return passage;
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

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
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

	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}

	public void setPassage(double passage) {
		this.passage = passage;
	}
}
