package LEMS.businesslogic.orderbl;

import java.util.ArrayList;

import LEMS.businesslogicservice.orderblservice.TransferService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.TransferVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 中转接收任务
 */
public class Transfer extends AddOrder implements TransferService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	private UserVO user;
	
	private TransferVO transferVO;
	
	public Transfer(UserVO user, TransferVO transferVO) {
		
		this.user = user;
		this.transferVO = transferVO;
		
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		// TODO Auto-generated method stub
		
	}

	public void createTransferNote() {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
