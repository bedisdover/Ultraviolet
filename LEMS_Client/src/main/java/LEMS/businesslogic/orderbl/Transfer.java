package LEMS.businesslogic.orderbl;

import java.util.ArrayList;

import LEMS.businesslogicservice.orderblservice.TransferService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.TransferVO;

/**
 * @author 宋益明
 * 
 * 中转接收任务
 */
public class Transfer implements TransferService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	public Transfer() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		// TODO Auto-generated method stub
		
	}

	public void createTransferNote(TransferVO transferInfo) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
