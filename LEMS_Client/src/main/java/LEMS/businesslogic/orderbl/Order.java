package LEMS.businesslogic.orderbl;

import LEMS.businesslogicservice.orderblservice.OrderService;
import LEMS.po.financepo.PricePO;
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
	/**
	 * 寄件人
	 */
	private CustomerVO sender;
	/**
	 * 收件人
	 */
	private CustomerVO receiver;
	/**
	 * 快递类型
	 */
	private Express type;
	/**
	 * 货物信息
	 */
	private GoodsVO goods;
	
	public Order() {
		//新建订单
		order = new OrderVO();
	}
	
	public void addSender(CustomerVO sender) {
		this.sender = sender;
		
		order.setSender(sender);
	}

	public void addReceiver(CustomerVO receiver) {
		this.receiver = receiver;
		
		order.setReceiver(receiver);
	}

	public void addGoodsInfo(GoodsVO goods) {
		this.goods = goods;
		
		order.setGoodsInfo(goods);
	}

	public void chooseType(Express type) {
		this.type = type;
		
		order.setExpressType(type);
	}

	public String createID() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getMoney() {
		//获得距离
		double distance = Distance.getDistance(sender.getAddress().substring(0, 2), receiver.getAddress().substring(0, 2));
		//获得单价
		double price = PricePO.getPrice(type);
		
		return distance / 1000 * price * goods.getWeight();
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
