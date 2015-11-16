package LEMS.businesslogic.orderbl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.orderbl.mock.MockVehicleLoad;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.VehicleLoadNotePO;
import LEMS.vo.ordervo.VehicleLoadVO;

public class VehicleLoadTest {
	
	MockVehicleLoad vehicleLoad = new MockVehicleLoad();
	
	@Test
	public void testAddOrder(String id) {
		vehicleLoad.addOrder(id);
		assertEquals(new OrderPO(id), vehicleLoad.getOrders().get(0));
	}
	
	@Test
	public void testCreateVehicleLoadNote(VehicleLoadVO vehicleLoadVO) {
		VehicleLoadNotePO vehicleLoadNote = vehicleLoad.createVehicleLoadNote(vehicleLoadVO);
		assertEquals(new VehicleLoadNotePO(vehicleLoadVO), vehicleLoadNote);
	}
}
