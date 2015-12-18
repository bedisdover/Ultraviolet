package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import LEMS.businesslogic.inquirebl.inquirelogisticsinfo.InquireLogisticsInfo;
import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.AddOrderService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.inquirevo.LogisticsInfoVO;

/**
 * @author 宋益明
 *
 * 增加订单
 */
public class AddOrder implements AddOrderService {
	
	private InquireLogisticsInfo inquireLogisticsInfo = new InquireLogisticsInfo();

	/**
	 * 根据ID获得订单持久化对象
	 * 
	 * @param id 
	 * @return 订单持久化对象
	 * @throws RemoteException 
	 */
	public OrderPO findOrder(String id) throws RemoteException {
		OrderPO order = null;
		
//		try {
//			//获得订单信息
//			order = this.getDataService().find(id);
//			System.out.println(id);
//			System.out.println(order.getId());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
		order = this.getDataService().find(id);
		
		return order;
	}
	
//	public void addOrder(String id) {
//		// TODO 似乎不需要的方法，但是考虑到需求变更，就暂且放在这里了
//	}
	
	/**
	 * 根据ID查找物流信息
	 * 
	 * @param id
	 * @return
	 */
	protected LogisticsInfoVO getLogistics(String id) {
		LogisticsInfoVO logisticsInfoVO = inquireLogisticsInfo.getLogisticsInfo(id);
		
		return logisticsInfoVO;
	}
	
	/**
	 * 更新订单信息
	 * 
	 * @param orderPO 目标单据持久化对象
	 */
	protected void updateOrder(OrderPO orderPO) {
		try {
			//更新信息
			this.getDataService().update(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新物流信息
	 * 
	 * @param logisticsInfoVO 物流信息值对象
	 */
	protected void updateLogistics(LogisticsInfoVO logisticsInfoVO) {
		inquireLogisticsInfo.updateLogisticsInfo(logisticsInfoVO);
	}
	
	/**
	 * 获得一个订单列表中所有订单的总质量
	 * @return 总质量
	 */
	protected double sumWeight(List<OrderPO> orders) {
		double sum = 0.0;
		
		for (OrderPO orderPO : orders) {
			sum += orderPO.getWeight();
		}
		
		return sum;
	}
	
	/**
	 * 获得数据库的引用
	 * 
	 * @return Order数据服务
	 * @throws RemoteException 
	 */
	private OrderDataService getDataService() throws RemoteException {
		
		OrderDataService orderDataService = null;
		
		try {
			//获得数据库的引用			
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			orderDataService = orderFactory.getOrderData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			throw e;
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return orderDataService;
	}
}