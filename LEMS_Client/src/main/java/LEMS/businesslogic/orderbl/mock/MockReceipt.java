package LEMS.businesslogic.orderbl.mock;

import java.util.ArrayList;

import LEMS.po.orderpo.ArrivalNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.ArrivalVO;

public class MockReceipt {

	ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
	
	public void addOrder(String id) {
		orders.add(new OrderPO(id));
	}

	public ArrivalNotePO createArrivalNote(ArrivalVO arrivalInfo) {
		return new ArrivalNotePO(arrivalInfo);
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
