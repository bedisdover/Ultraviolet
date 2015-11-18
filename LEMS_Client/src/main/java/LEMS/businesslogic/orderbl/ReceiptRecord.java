package LEMS.businesslogic.orderbl;

import java.util.ArrayList;

import LEMS.businesslogicservice.orderblservice.ReceiptRecordService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.IncomeBillVO;

/**
 * @author 宋益明
 * 
 * 记录收款单任务
 */
public class ReceiptRecord implements ReceiptRecordService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	public ReceiptRecord() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		// TODO Auto-generated method stub
		
	}

	public void createIncomeBill(IncomeBillVO income) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}

}
