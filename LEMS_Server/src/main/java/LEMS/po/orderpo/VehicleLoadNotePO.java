package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.financepo.DocumentState;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;

/**
 * @author 宋益明
 * 
 * 车辆装车单持久化对象
 * 包括装车单编号、装车单状态、装车日期、托运订单条形码号、
 * 出发地、目的地、货运车辆、监装员、押运员、路费
 */
public class VehicleLoadPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 装车日期
	 */
	private String date;
	/**
	 * 装车单编号
	 */
	private String id;
	/**
	 * 车辆装车单状态
	 */
	private DocumentState state;
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
	
	public VehicleLoadPO() {
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
