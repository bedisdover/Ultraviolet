package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.VehicleLoadService_Stub;
import LEMS.vo.informationvo.VehicleVO;
import LEMS.vo.ordervo.VehicleLoadVO;

/**
 * @author 宋益明
 * 
 * 车辆装车管理驱动程序
 */
public class VehicleLoadService_Driver {
	
	public void drive(VehicleLoadService_Stub vehicleLoadService_Stub) {
		vehicleLoadService_Stub.addOrder(123456);
		vehicleLoadService_Stub.createVehicleLoadNote(new VehicleLoadVO("2015/10/23", "567812", null, "北京", new VehicleVO("12345", "11341351", "2", null)));
	}
}
