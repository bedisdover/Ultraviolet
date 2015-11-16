package LEMS.businesslogic.orderbl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.orderbl.mock.MockReceipt;
import LEMS.po.orderpo.ArrivalNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.ArrivalVO;

public class ReceiptTest {
	
	MockReceipt receipt = new MockReceipt();
	
	@Test
	public void testAddOrder(String id) {
		receipt.addOrder(id);
		assertEquals(new OrderPO(id), receipt.getOrders().get(0));
	}
	
	@Test
	public void testCreateArrivalNote(ArrivalVO arrivalInfo) {
		ArrivalNotePO arrivalNote = receipt.createArrivalNote(arrivalInfo);
		assertEquals(new ArrivalNotePO(arrivalInfo), arrivalNote);
	}
}
