package LEMS.vo.ordervo;

import java.util.ArrayList;

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
	private long id;
	/**
	 * 订单列表
	 */
	private ArrayList<Long> orders;
	/**
	 * 目的地
	 */
	private String destination;
	//TODO 添加车辆代号
	
	public VehicleLoadVO(String date, long id, ArrayList<Long> orders, String destination) {
		this.date = date;
		this.id = id;
		this.orders = orders;
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public long getId() {
		return id;
	}

	public ArrayList<Long> getOrders() {
		return orders;
	}

	public String getDestination() {
		return destination;
	}
}
