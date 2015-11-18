package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.orderdataservice.LoadDataService;
import LEMS.dataservice.orderdataservice.OrderDataService;

/**
 * @author 宋益明
 * 
 * Order模块的数据工厂
 */
public interface OrderFactory extends Remote {

	/**
	 * 获得订单数据服务（OrderDataService）
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public OrderDataService getOrderData() throws RemoteException;
	
	/**
	 * 获得装运数据服务
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public LoadDataService getLoadData() throws RemoteException; 
	
}
