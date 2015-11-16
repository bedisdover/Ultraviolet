package LEMS.businesslogic.orderbl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.orderbl.mock.MockReceiptRecord;
import LEMS.po.orderpo.IncomeBillPO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.IncomeBillVO;

public class ReceiptRecordTest {
	
	MockReceiptRecord receiptRecord = new MockReceiptRecord();
	
	@Test
	public void testAddOrder(String id) {
		receiptRecord.addOrder(id);
		assertEquals(new OrderPO(id), receiptRecord.getOrders().get(0));
	}
	
	@Test
	public void testCreateIncomeBill(IncomeBillVO income) {
		IncomeBillPO incomeBill = receiptRecord.createIncomeBill(income);
		assertEquals(new IncomeBillPO(income), incomeBill);
	}
}
