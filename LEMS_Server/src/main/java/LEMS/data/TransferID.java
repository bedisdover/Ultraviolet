package LEMS.data;

import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.data.orderdata.OrderData;
import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * 负责ID转字符串及字符串转ID的实现
 * 存储订单列表时，为方便存储，将所有托运订单的ID连接起来
 * 读取时，将读取到的字符串转换为订单列表
 */
public class TransferID {

	/**
	 * 将订单ID提取出并合并为一项，方便存储与读取
	 * 
	 * @param orders 所有托运订单
	 * @return 所有订单ID
	 */
	public String transferOrder(ArrayList<OrderPO> orders) {
		
		String result = "";
		
		for (OrderPO orderPO : orders) {
			result += orderPO.getId() + " ";
		}
		
		return result;
	}
	
	/**
	 * 将所有订单的ID转换为OrderPO集合
	 * 
	 * @param id 从数据库中读取出的所有订单ID
	 * @return 所有订单持久化对象
	 */
	public ArrayList<OrderPO> transferOrder(String id) {
		ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
		
		String temp[] = id.split(" ");
		
		try {
			OrderData orderData = new OrderData();
			
			for (String string : temp) {
				orders.add(orderData.find(string));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return orders;
	}
}
