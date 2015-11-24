package LEMS.businesslogic.orderbl;

import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;
import LEMS.vo.ordervo.CustomerVO;
import LEMS.vo.ordervo.GoodsVO;

/**
 * @author 宋益明
 * 
 * 生成订单控制器，负责生成订单
 */
public class OrderController {
	
	/**
	 * 订单对象
	 */
	private Order order;
	
	public OrderController() {
		order = new Order();
	}

	public void addSender(String name, String phone, String address) {
		CustomerVO sender = new CustomerVO();
		sender.setName(name);
		sender.setPhone(phone);
		sender.setAddress(address);
		
		order.addSender(sender);
	}

	public void addReceiver(String name, String phone, String address) {
		CustomerVO receiver = new CustomerVO();
		receiver.setName(name);
		receiver.setPhone(phone);
		receiver.setAddress(address);	
		
		order.addReceiver(receiver);
	}

	public void addGoodsInfo(String name, String size, String quantity, String weight, String volumn) {
		GoodsVO goods = new GoodsVO();
		goods.setName(name);
		goods.setSize(size);		
		goods.setQuantity(Integer.parseInt(quantity));
		goods.setWeight(Double.parseDouble(weight));
		goods.setVolumn(Double.parseDouble(volumn));
		
		order.addGoodsInfo(goods);
	}

	public void chooseType(Object express) {
		order.chooseType((Express) express);
	}

	public void choosePack(Object packing) {
		order.choosePack((Packing) packing);
	}

	public String createID() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getMoney() {
		return order.getMoney();
	}

	public double getTotal() {
		return order.getTotal();
	}

	public String getTime() {
		return order.getTime();
	}
}
