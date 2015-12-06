package LEMS.vo.ordervo;

import java.util.ArrayList;

import LEMS.po.orderpo.TransportType;

/**
 * @author 宋益明
 * 
 * 装运管理值对象
 */
public class LoadVO {
//	/**
//	 * 装运日期
//	 */
//	private String date;
//	/**
//	 * 装运编号
//	 */
//	private String id;
	/**
	 * 订单列表
	 */
	private ArrayList<String> orders;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 运输方式
	 */
	private TransportType type;
	
	
//	/**
//	 * 运费
//	 */
//	private double passage;

	public ArrayList<String> getOrders() {
		return orders;
	}

	public String getDestination() {
		return destination;
	}

	public TransportType getType() {
		return type;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}
	
	public void setType(TransportType type) {
		this.type = type;
	}
}
