package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.orderdata.DistanceData;
import LEMS.data.orderdata.OrderData;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.DistanceDataService;
import LEMS.dataservice.orderdataservice.LoadDataService;
import LEMS.dataservice.orderdataservice.OrderDataService;

public class OrderFactoryImpl extends UnicastRemoteObject implements OrderFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected OrderFactoryImpl() throws RemoteException {
		super();
	}

	public OrderDataService getOrderData() throws RemoteException {
		OrderDataService dataService = new OrderData();
		return dataService;
	}

	public LoadDataService getLoadData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public DistanceDataService getDistanceData() throws RemoteException {
		DistanceDataService distanceDataService = new DistanceData();
		return distanceDataService;
	}

}
