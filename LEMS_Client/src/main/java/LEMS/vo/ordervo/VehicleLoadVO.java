package LEMS.vo.ordervo;

import java.util.ArrayList;

import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * 车辆装车值对象
 */
public class VehicleLoadVO {
	/**
	 * 装车日期
	 */
	private String date;
//	/**
//	 * 装车单编号
//	 */
//	private String id;
	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;


	//	/**
//	 * 出发地
//	 */
//	private String departure;
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
//	/**
//	 * 运费
//	 */
//	private double passage;

	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
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

	public String getDate() {
		return date;
	}

	public String getSuperVision() {
		return superVision;
	}

	public void setDate(String date) {
		this.date = date;
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