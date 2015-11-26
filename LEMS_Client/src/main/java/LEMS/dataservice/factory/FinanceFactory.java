package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.financedataservice.PriceDataService;

public interface FinanceFactory extends Remote {
	/**
	 * 获得价格数据服务的引用
	 * 
	 * @return 
	 * @throws RemoteException
	 */
	public PriceDataService getPriceDataService() throws RemoteException;
}
