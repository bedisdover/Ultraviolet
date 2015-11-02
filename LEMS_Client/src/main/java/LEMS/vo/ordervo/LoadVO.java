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
	 * 装运编号
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
	 * 运输方式
	 */
	private TransportType type;
	/**
	 * 运费
	 */
	private double carriage;
	
	public LoadVO(String date, String id, ArrayList<Long> orders, String destination, TransportType type,
			double carriage) {
		this.date = date;
		this.id = id;
		this.orders = orders;
		this.destination = destination;
		this.type = type;
		this.carriage = carriage;
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

	public TransportType getType() {
		return type;
	}

	public double getCarriage() {
		return carriage;
	}
}
