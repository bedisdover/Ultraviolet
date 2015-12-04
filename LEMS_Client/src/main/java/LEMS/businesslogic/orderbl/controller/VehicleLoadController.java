package LEMS.businesslogic.orderbl.controller;

import java.util.Date;

import LEMS.businesslogic.orderbl.VehicleLoad;
import LEMS.businesslogic.utility.DateFormate;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.orderpo.VehicleLoadPO;
import LEMS.po.userpo.UserPO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 负责车辆装车管理功能的实现
 */
public class VehicleLoadController {

	private VehicleLoad vehicleLoad;
	
	private VehicleLoadPO vehicleLoadPO;
	
	private UserVO user;
	
	public VehicleLoadController(UserVO user) {
		
		this.user = user;
		
		vehicleLoad = new VehicleLoad();
		vehicleLoadPO = new VehicleLoadPO();
	}
	
	public void addOrder(String id) {
		vehicleLoad.addOrder(id);
	}
	
	public void createVehicleLoadNote() {
		//设置装车日期
		vehicleLoadPO.setDate(DateFormate.DATE_FORMAT.format(new Date()));
		//设置出发地
		vehicleLoadPO.setDeparture(user.getInstitution().getLocation());
		//设置运费
		vehicleLoadPO.setPassage(vehicleLoad.calculatePassage());
		//设置订单列表
		vehicleLoadPO.setOrders(vehicleLoad.getOrders());
		//生成车辆装车单
		vehicleLoad.createVehicleLoadNote(vehicleLoadPO);
	}
	
	/**
	 * 设置目的地
	 * 
	 * @param destination 目的地
	 */
	public void setDestination(String destination) {
		vehicleLoadPO.setDestination(destination);
	}
	
	/**
	 * 设置运输车辆
	 * 
	 * @param vehicleId 汽运编号
	 */
	public void setVehicle(String vehicleId) {
		//TODO 根据ID获得车辆对象
		VehiclePO vehicle = new VehiclePO();
		vehicleLoadPO.setVehicle(vehicle);
	}
	
	//TODO 应该改为更加人性化的设计，比如根据姓名直接获得UserPO
	/**
	 * 设置监装员
	 */
	public void setSuperVision(UserPO superVision) {
		vehicleLoadPO.setSuperVision(superVision);
	}
	
	/**
	 * 设置押运员
	 */
	public void setSuperCargo(UserPO superCargo) {
		vehicleLoadPO.setSuperCargo(superCargo);
	}
}
