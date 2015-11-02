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
	private ArrayList<Long> orders;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 货运车辆
	 */
	private VehicleVO vehicle;
	
	public VehicleLoadVO(String date, String id, ArrayList<Long> orders, String destination, VehicleVO vehicle) {
		this.date = date;
		this.id = id;
		this.orders = orders;
		this.destination = destination;
		this.vehicle = vehicle;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public ArrayList<Long> getOrders() {
		return orders;
	}

	public String getDestination() {
		return destination;
	}

	public VehicleVO getVehicle() {
		return vehicle;
	}
}
