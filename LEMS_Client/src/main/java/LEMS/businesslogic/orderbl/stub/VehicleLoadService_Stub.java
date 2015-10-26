package LEMS.businesslogic.orderbl.stub;

import LEMS.businesslogicservice.orderblservice.VehicleLoadService;
import LEMS.vo.ordervo.VehicleLoadVO;

/**
 * @author 宋益明
 * 
 * 车辆装车管理任务桩程序
 */
public class VehicleLoadService_Stub implements VehicleLoadService {

	public void addOrder(long id) {
		System.out.println("添加订单成功！");
	}

	public void createVehicleLoadNote(VehicleLoadVO vehicleLoadVO) {
		System.out.println("创建车辆装车单成功！");
	}

}
