package LEMS.businesslogic.orderbl.mock;

import java.util.ArrayList;

import LEMS.po.orderpo.IncomeBillPO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.IncomeBillVO;

public class MockReceiptRecord {

	ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
	
	public void addOrder(String id) {
		orders.add(new OrderPO(id));
	}
	
	public IncomeBillPO createIncomeBill(IncomeBillVO income) {
		return new IncomeBillPO(income);
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
