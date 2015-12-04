package LEMS.vo.ordervo;

import java.util.ArrayList;

import LEMS.po.orderpo.TransportType;

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
	private double passage;
	
	public LoadVO(String date, String id, ArrayList<Long> orders, String destination, TransportType type,
			double passage) {
		this.date = date;
		this.id = id;
		this.orders = orders;
		this.destination = destination;
		this.type = type;
		this.passage = passage;
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

	public double getPassage() {
		return passage;
	}
}
