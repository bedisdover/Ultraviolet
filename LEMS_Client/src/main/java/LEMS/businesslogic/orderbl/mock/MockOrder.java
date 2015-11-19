package LEMS.businesslogic.orderbl.mock;

import LEMS.po.orderpo.Express;
import LEMS.vo.ordervo.GoodsVO;
import LEMS.vo.ordervo.OrderVO;
import LEMS.vo.ordervo.ReceiverVO;
import LEMS.vo.ordervo.SenderVO;

/**
 * @author 宋益明
 *
 * 订单的Mock对象
 */
public class MockOrder {
	private OrderVO order = new OrderVO();
	
	public void addSender(SenderVO sender) {
		order.setSender(sender);
	}

	public void addReceiver(ReceiverVO receiver) {
		order.setReceiver(receiver);	
	}

	public void addGoodsInfo(GoodsVO goods) {
		order.setGoodsInfo(goods);
	}

	public void chooseType(Express type) {
		order.setExpressType(type);
	}

	public String createID() {
		return "12345678";
	}

	public double getMoney() {
		return 25;
	}

	public double getTotal() {
		return 25;
	}

	public String getTime() {
		return "三天";
	}
	
	public OrderVO getOrderVO() { 
		return order;
	}
}
