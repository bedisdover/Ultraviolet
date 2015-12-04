package LEMS.businesslogicservice.orderblservice;

import LEMS.po.orderpo.VehicleLoadPO;

/**
 * @author 宋益明
 * 
 * 车辆装车管理任务接口
 */
public interface VehicleLoadService extends AddOrderService {
	/**
	 * 生成装车单
	 * 
	 * @param vehicleLoadPO 车辆装车信息
	 */
	public void createVehicleLoadNote(VehicleLoadPO vehicleLoadPO);

//	/**
//	 * 生成装车单
//	 */
//	public void createVehicleLoadNote();
}