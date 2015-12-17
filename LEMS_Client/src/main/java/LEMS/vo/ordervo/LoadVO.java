package LEMS.vo.ordervo;

import java.util.ArrayList;

/**
 * @author 宋益明
 * 
 * 装运管理值对象
 */
public class LoadVO {
	/**
	 * 装运日期
	 */
	private String date;
	/**
	 * 订单列表
	 */
	private ArrayList<String> orders;
	/**
	 * 目的地
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

	public ArrayList<String> getOrders() {
		return orders;
	}

	public String getSuperVision() {
		return superVision;
	}

	public String getSuperCargo() {
		return superCargo;
	}
	
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
	public String getVehicle() {
		return vehicle;
	}

	public void setSuperVision(String superVision) {
		this.superVision = superVision;
	}

	public void setSuperCargo(String superCargo) {
		this.superCargo = superCargo;
	}

	public String getDestination() {
		return destination;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
