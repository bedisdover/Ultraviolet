package LEMS.businesslogic.orderbl;

import java.util.ArrayList;

import LEMS.businesslogicservice.orderblservice.SendingService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.DeliveryVO;

/**
 * @author 宋益明
 * 
 * 派件任务
 */
public class Sending extends AddOrder implements SendingService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	public Sending() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		OrderPO orderPO = findOrder(id);
		
		//记录收件时间
		this.setTime(orderPO);
		//记录收件人
		this.setReceiver(orderPO);
		
		orders.add(orderPO);
	}

	public void createDeliveryNote(DeliveryVO deliveryInfo) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	/**
	 * 存储收件时间
	 */
	private void setTime(OrderPO orderPO) {
		
	}
	
	/**
	 * 存储收件人
	 */
	private void setReceiver(OrderPO orderPO) {
		
	}
}
