package LEMS.businesslogic.orderbl.mock;

import java.util.ArrayList;

import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.VehicleLoadNotePO;
import LEMS.vo.ordervo.VehicleLoadVO;

public class MockVehicleLoad {
	
	ArrayList<OrderPO> orders = new ArrayList<OrderPO>();

	public void addOrder(String id) {
		orders.add(new OrderPO(id));
	}

	public VehicleLoadNotePO createVehicleLoadNote(VehicleLoadVO vehicleLoadVO) {
		VehicleLoadNotePO vehicleLoadNote = new VehicleLoadNotePO(vehicleLoadVO);
		return vehicleLoadNote;
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
