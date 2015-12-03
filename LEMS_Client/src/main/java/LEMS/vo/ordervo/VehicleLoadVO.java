package LEMS.vo.ordervo;

import java.util.ArrayList;

import LEMS.vo.informationvo.VehicleVO;

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
	/**
	 * 装车单编号
	 */
	private String id;
	/**
	 * 订单列表
	 */
	private ArrayList<String> orders;
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
	private VehicleVO vehicle;
	/**
	 * 运费
	 */
	private double passage;
	
	public String getDeparture() {
		return departure;
	}

	public double getPassage() {
		return passage;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setVehicle(VehicleVO vehicle) {
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

	public ArrayList<String> getOrders() {
		return orders;
	}

	public String getDestination() {
		return destination;
	}

	public VehicleVO getVehicle() {
		return vehicle;
	}
}
