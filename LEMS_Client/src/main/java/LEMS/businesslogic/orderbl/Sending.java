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
public class Sending implements SendingService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	public Sending() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		// TODO Auto-generated method stub
		
	}

	public void createDeliveryNote(DeliveryVO deliveryInfo) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
