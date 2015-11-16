package LEMS.businesslogic.orderbl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.orderbl.mock.MockSending;
import LEMS.po.orderpo.DeliveryNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.DeliveryVO;

public class SendingTest {
	
	MockSending sending = new MockSending();
	
	@Test
	public void testAddOrder(String id) {
		sending.addOrder(id);
		assertEquals(new OrderPO(id), sending.getOrders().get(0));
	}
	
	@Test
	public void testCreateDeliveryNote(DeliveryVO deliveryInfo) {
		DeliveryNotePO deliveryNote = sending.createCreateDeliveryNote(deliveryInfo);
		assertEquals(new DeliveryNotePO(deliveryInfo), deliveryNote);
	}
}
