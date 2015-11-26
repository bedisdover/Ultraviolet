package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogicservice.orderblservice.AddOrderService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 *
 * 增加订单
 */
public class AddOrder implements AddOrderService {

	/**
	 * 根据ID获得订单持久化对象
	 * 
	 * @param id 
	 * @return 订单持久化对象
	 */
	public OrderPO findOrder(String id) {
		
		OrderPO order = new OrderPO();
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup("rmi://localhost:1099/data");
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			OrderDataService orderDataService = orderFactory.getOrderData();
			order = orderDataService.find(id);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	public void addOrder(String id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
