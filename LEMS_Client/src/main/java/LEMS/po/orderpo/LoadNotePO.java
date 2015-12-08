package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.financepo.DocumentState;

/**
 * @author 宋益明
 * 
 * 装车单持久化对象（中转中心业务员）
 * 装车单包括：
 * 		装车单ID（中转中心编号+日期+0000000七位数字）、
 * 		装车单状态、装车日期、出发地、到达地（营业厅）、
 * 		车辆代号、监装员、押运员、本次装箱所有订单条形码号）、
 * 		运费（运费根据出发地和目的地自动生成）
 */
public class LoadNotePO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 装车单ID
	 */
	private String id;
	
	/**
	 * 装车单状态
	 */
	private DocumentState state;
	
	/**
	 * 装车日期
	 */
	private String date;
	
	/**
	 * 出发地
	 */
	private String departure;
	
	/**
	 * 到达地
	 */
	private String destination;
	
	/**
	 * 车辆代号
	 */
	private String vehicle;
	
	/**
	 * 监装员
	 */
	private String superVision;
	
	/**
	 * 押运员
	 */
	private String superCargo;
	
	/**
	 * 托运订单
	 */
	private ArrayList<OrderPO> orders;
	
	/**
	 * 运费
	 */
	private double passage;
	
	public LoadNotePO() {
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

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}

	public String getVehicle() {
		return vehicle;
	}

	public String getSuperVision() {
		return superVision;
	}

	public String getSuperCargo() {
		return superCargo;
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

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public void setSuperVision(String superVision) {
		this.superVision = superVision;
	}

	public void setSuperCargo(String superCargo) {
		this.superCargo = superCargo;
	}

	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}

	public void setPassage(double passage) {
		this.passage = passage;
	}
}
