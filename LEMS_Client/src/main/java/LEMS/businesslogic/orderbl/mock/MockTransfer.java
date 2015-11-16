package LEMS.businesslogic.orderbl.mock;

import java.util.ArrayList;

import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.TransferNotePO;
import LEMS.vo.ordervo.TransferVO;

public class MockTransfer {
	ArrayList<OrderPO> orders = new ArrayList<OrderPO>();

	public void addOrder(String id) {
		orders.add(new OrderPO(id));
	}

	public TransferNotePO createTransferNote(TransferVO transferInfo) {
		TransferNotePO transferNote = new TransferNotePO(transferInfo);
		return transferNote;
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
