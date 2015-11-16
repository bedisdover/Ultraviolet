package LEMS.businesslogic.orderbl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.orderbl.mock.MockTransfer;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.TransferNotePO;
import LEMS.vo.ordervo.TransferVO;

public class TransferTest {
	
	MockTransfer transfer = new MockTransfer();
	
	@Test
	public void testAddOrder(String id) {
		transfer.addOrder(id);
		assertEquals(new OrderPO(id), transfer.getOrders().get(0));
	}
	
	@Test
	public void testCreateTransferNote(TransferVO transferInfo) {
		TransferNotePO transferNote = transfer.createTransferNote(transferInfo);
		assertEquals(new TransferNotePO(transferInfo), transferNote);
	}
}
