package LEMS.businesslogic.orderbl.controller;

import java.util.Date;

import LEMS.businesslogic.orderbl.VehicleLoad;
import LEMS.businesslogic.utility.DateFormate;
import LEMS.businesslogicservice.orderblservice.VehicleLoadService;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;
import LEMS.vo.ordervo.VehicleLoadVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 负责车辆装车管理功能的实现
 */
public class VehicleLoadController implements VehicleLoadService {

	private VehicleLoad vehicleLoad;
	
	private VehicleLoadVO vehicleLoadVO;
	
	private UserVO user;
	
	public VehicleLoadController(UserVO user) {
		
		this.user = user;
		
		vehicleLoad = new VehicleLoad();
		vehicleLoadVO = new VehicleLoadVO();
	}
	
	public void addOrder(String id) {
		vehicleLoad.addOrder(id);
	}
	
	public void createVehicleLoadNote() {
		//设置装车日期
		vehicleLoadVO.setDate(DateFormate.DATE_FORMAT.format(new Date()));
		//设置出发地
		vehicleLoadVO.setDeparture(user.getInstitution().getLocation());
		//设置运费
		vehicleLoadVO.setPassage(vehicleLoad.calculatePassage());
		//设置订单列表
		vehicleLoadVO.setOrders(vehicleLoad.getOrders());
		//TODO 如何生成车辆装车单我还没想好
	}
	
	/**
	 * 设置目的地
	 * 
	 * @param destination 目的地
	 */
	public void setDestination(String destination) {
		vehicleLoadVO.setDestination(destination);
	}
	
	/**
	 * 设置运输车辆
	 * 
	 * @param vehicleId 汽运编号
	 */
	public void setVehicle(String vehicleId) {
		//TODO 根据ID获得车辆对象
		VehiclePO vehicle = new VehiclePO();
		vehicleLoadVO.setVehicle(vehicle);
	}
	
	//TODO 应该改为更加人性化的设计，比如根据姓名直接获得UserPO
	/**
	 * 设置监装员
	 */
	public void setSuperVision(UserPO superVision) {
		vehicleLoadVO.setSuperVision(superVision);
	}
	
	/**
	 * 设置押运员
	 */
	public void setSuperCargo(UserPO superCargo) {
		vehicleLoadVO.setSuperCargo(superCargo);
	}
}
