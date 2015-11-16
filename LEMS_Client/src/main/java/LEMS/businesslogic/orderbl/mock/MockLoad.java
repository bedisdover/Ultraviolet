package LEMS.businesslogic.orderbl.mock;

import java.util.ArrayList;

import LEMS.po.orderpo.LoadNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.LoadVO;

public class MockLoad {
	
	ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
	
	public void addOrder(String id) {
		orders.add(new OrderPO(id));
	}

	public LoadNotePO createLoadNote(LoadVO loadInfo) {
		LoadNotePO note = new LoadNotePO(loadInfo);
		return note;
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
