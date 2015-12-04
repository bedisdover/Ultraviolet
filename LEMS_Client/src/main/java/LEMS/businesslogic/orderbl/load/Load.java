package LEMS.businesslogic.orderbl.load;

import java.util.ArrayList;

import LEMS.businesslogic.orderbl.AddOrder;
import LEMS.businesslogicservice.orderblservice.LoadService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.LoadVO;

/**
 * @author 宋益明
 * 
 * 装运管理任务
 */
public abstract class Load extends AddOrder implements LoadService {
	/**
	 * 订单列表
	 */
	protected ArrayList<OrderPO> orders;
	
	public Load() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		orders.add(findOrder(id));
	}

	public void createLoadNote(LoadVO loadInfo) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	/**
	 * 计算运费
	 * 
	 * @param 距离
	 */
	public abstract double calculateMessage(double distance);
}
