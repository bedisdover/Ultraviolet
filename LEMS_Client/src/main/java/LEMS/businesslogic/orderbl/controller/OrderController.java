package LEMS.businesslogic.orderbl.controller;

import LEMS.businesslogic.orderbl.Order;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;
import LEMS.vo.ordervo.CustomerVO;
import LEMS.vo.ordervo.GoodsVO;
import LEMS.vo.uservo.UserVO;

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
	
	public OrderController(UserVO user) {
		order = new Order(user);
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

	public void addGoodsInfo(String name, String quantity, String weight, String length, String width, String height) {
		GoodsVO goods = new GoodsVO();
		//体积
		double volumn = Double.parseDouble(length) * Double.parseDouble(width) * Double.parseDouble(height);
		//重量
		double w = Double.parseDouble(weight);
		w = ((volumn / 5000) > w) ? (volumn / 5000) : w;
		
		goods.setName(name);
		goods.setQuantity(Integer.parseInt(quantity));
		goods.setVolumn(volumn);
		goods.setWeight(w);
		
		order.addGoodsInfo(goods);
	}

	public void chooseType(Express express) {
		order.chooseExpress(express);
	}

	public void choosePack(Packing packing) {
		order.choosePack(packing);
	}

	public String createID() {
		// TODO 根据已有单据创建ID
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
	
	public void endOrder() {
		order.endOrder();
	}
}
