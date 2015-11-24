package LEMS.businesslogic.orderbl;

import LEMS.businesslogicservice.orderblservice.OrderService;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;
import LEMS.vo.ordervo.CustomerVO;
import LEMS.vo.ordervo.GoodsVO;
import LEMS.vo.ordervo.OrderVO;

/**
 * @author 宋益明
 * 
 * 新建订单任务
 */
public class Order implements OrderService {

	/**
	 * 订单值对象
	 */
	private OrderVO order;
	
	public Order() {
		//新建订单
		order = new OrderVO();
	}
	
	public void addSender(CustomerVO sender) {
		order.setSender(sender);
	}

	public void addReceiver(CustomerVO receiver) {
		order.setReceiver(receiver);
	}

	public void addGoodsInfo(GoodsVO goods) {
		order.setGoodsInfo(goods);
	}

	public void chooseType(Express type) {
		order.setExpressType(type);
	}

	public String createID() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getMoney() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public void endOrder() {
		// TODO Auto-generated method stub
		
	}

	public void choosePack(Packing type) {
		// TODO Auto-generated method stub
		
	}

}
