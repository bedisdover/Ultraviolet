package LEMS.businesslogic.orderbl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.orderbl.mock.MockOrder;
import LEMS.po.orderpo.Express;
import LEMS.vo.ordervo.GoodsVO;
import LEMS.vo.ordervo.OrderVO;
import LEMS.vo.ordervo.ReceiverVO;
import LEMS.vo.ordervo.SenderVO;

public class OrderTest {
	
	private MockOrder order;
	private OrderVO orderVO;
	
	public OrderTest() {
		order = new MockOrder();
		orderVO = new OrderVO();
	}
	
	@Test
	public void testAddSender(SenderVO sender) {
		order.addSender(sender);
		assertEquals(sender, orderVO.getSender());
	}
	
	@Test
	public void testAddReceiver(ReceiverVO receiver) {
		order.addReceiver(receiver);
		assertEquals(receiver, orderVO.getReceiver());
	}
	
	@Test
	public void testAddGoodsInfo(GoodsVO goods) {
		order.addGoodsInfo(goods);
		assertEquals(goods, orderVO.getGoodsInfo());
	}
	
	@Test
	public void testChooseType(Express type) {
		order.chooseType(type);
		assertEquals(type, orderVO.getExpressType());
	}
	
	@Test
	public void testCreateID() {
		String id = order.createID();
		assertEquals(id, orderVO.getId());
	}
	
	@Test
	public void testGetMoney() {
		double money = order.getMoney();
		assertEquals(money, orderVO.getAmount(), 0.0);
	}
	
	@Test
	public void testGetTotal() {
		double money = order.getTotal();
		assertEquals(money, orderVO.getAmount(), 0.0);
	}
	
	@Test
	public void testGetTime() {
		String time = order.getTime();
		assertEquals(time, orderVO.getTime());
	}
}
