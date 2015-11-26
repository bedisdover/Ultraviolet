package LEMS.businesslogicservice.orderblservice;

import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * 增加订单接口，用于在订单列表中增加订单
 */
public interface AddOrderService {
	/**
	 * 在订单列表中增加订单
	 * 
	 * @param id 订单ID
	 */
	public void addOrder(String id);
}
