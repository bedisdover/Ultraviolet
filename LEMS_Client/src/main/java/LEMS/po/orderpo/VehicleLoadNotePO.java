package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.financepo.DocumentState;

/**
 * @author 宋益明
 * 
 * 车辆装车单持久化对象（营业厅业务员）
 * 车辆装车单包括：
 * 		装车单ID（营业厅编号+日期+00000 、五位数字）、
 * 		装车单状态、装车日期、车辆编号 、
 * 		出发地、到达地（本地中转中心或者其它营业厅）、
 * 		监装员、押运员、所有订单条形码号、运费
 */
public class VehicleLoadNotePO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 装车单编号
	 */
	private String id;
	/**
	 * 车辆装车单状态
	 */
	private DocumentState state;
	/**
	 * 装车日期
	 */
	private String date;
	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	/**
	 * 出发地
	 */
	private String departure;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 货运车辆
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
	 * 运费
	 */
	private double passage;
	
	public VehicleLoadNotePO() {
		state = DocumentState.waiting;
	}
	
	public String getDeparture() {
		return departure;
	}

	public double getPassage() {
		return passage;
	}

	public DocumentState getState() {
		return state;
	}
	
	public void setState(DocumentState state) {
		this.state = state;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
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

	public void setPassage(double passage) {
		this.passage = passage;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}

	public String getDestination() {
		return destination;
	}

	public String getVehicle() {
		return vehicle;
	}

	public String getSupervision() {
		return superVision;
	}

	public String getSuperCargo() {
		return superCargo;
	}

	public void setSuperVision(String superVision) {
		this.superVision = superVision;
	}

	public void setSuperCargo(String superCargo) {
		this.superCargo = superCargo;
	}
}
