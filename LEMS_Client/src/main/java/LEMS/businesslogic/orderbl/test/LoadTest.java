package LEMS.businesslogic.orderbl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.orderbl.mock.MockLoad;
import LEMS.po.orderpo.LoadNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.LoadVO;

public class LoadTest {
	
	MockLoad load = new MockLoad();
	
	@Test
	public void testAddOrder(String id) {
		load.addOrder(id);
		assertEquals(new OrderPO(id), load.getOrders().get(0));
	}
	
	@Test
	public void testCreateLoadNote(LoadVO loadInfo) {
		LoadNotePO loadNote = load.createLoadNote(loadInfo);
		assertEquals(new LoadNotePO(loadInfo), loadNote);
	} 
}
