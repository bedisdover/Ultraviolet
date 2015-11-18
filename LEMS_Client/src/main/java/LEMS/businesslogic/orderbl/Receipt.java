package LEMS.businesslogic.orderbl;

import java.util.ArrayList;

import LEMS.businesslogicservice.orderblservice.ReceiptService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.ArrivalVO;

/**
 * @author 宋益明
 * 
 * 接收任务
 */
public class Receipt implements ReceiptService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	public Receipt() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		
	}

	public void createArrivalNote(ArrivalVO arrivalInfo) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
