package LEMS.vo.ordervo;

import java.util.ArrayList;

import LEMS.po.informationpo.VehiclePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.userpo.UserPO;

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
	private VehiclePO vehicle;
	/**
	 * 监装员
	 */
	private UserPO superVision;
	/**
	 * 押运员
	 */
	private UserPO superCargo;
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

	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setVehicle(VehiclePO vehicle) {
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

	public VehiclePO getVehicle() {
		return vehicle;
	}

	public UserPO getSupervision() {
		return superVision;
	}

	public UserPO getSuperCargo() {
		return superCargo;
	}

	public void setSuperVision(UserPO superVision) {
		this.superVision = superVision;
	}

	public void setSuperCargo(UserPO superCargo) {
		this.superCargo = superCargo;
	}
}
