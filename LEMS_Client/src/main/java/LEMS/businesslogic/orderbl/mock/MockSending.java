package LEMS.businesslogic.orderbl.mock;

import java.util.ArrayList;

import LEMS.po.orderpo.DeliveryNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.DeliveryVO;

public class MockSending {
	ArrayList<OrderPO> orders = new ArrayList<OrderPO>();

	public void addOrder(String id) {
		orders.add(new OrderPO(id));
	}
	
	public DeliveryNotePO createCreateDeliveryNote(DeliveryVO deliveryInfo) {
		DeliveryNotePO deliveryNote = new DeliveryNotePO(deliveryInfo);
		return deliveryNote;
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
