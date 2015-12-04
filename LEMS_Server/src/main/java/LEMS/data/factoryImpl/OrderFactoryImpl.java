package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.orderdata.DistanceData;
import LEMS.data.orderdata.LoadData;
import LEMS.data.orderdata.OrderData;
import LEMS.data.orderdata.SendingData;
import LEMS.data.orderdata.VehicleLoadData;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.DistanceDataService;
import LEMS.dataservice.orderdataservice.LoadDataService;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.dataservice.orderdataservice.VehicleLoadDataService;

public class OrderFactoryImpl extends UnicastRemoteObject implements OrderFactory {
	private static final long serialVersionUID = 1L;

	public OrderFactoryImpl() throws RemoteException {
		super();
	}

	public OrderDataService getOrderData() throws RemoteException {
		OrderDataService dataService = new OrderData();
		return dataService;
	}

	public LoadDataService getLoadData() throws RemoteException {
		LoadDataService loadDataService = new LoadData();
		return loadDataService;
	}
	
	@Override
	public DistanceDataService getDistanceData() throws RemoteException {
		DistanceDataService distanceDataService = new DistanceData();
		return distanceDataService;
	}

	@Override
	public VehicleLoadDataService getVehicleLoadDate() throws RemoteException {
		VehicleLoadDataService vehicleLoadDataService = new VehicleLoadData();
		return vehicleLoadDataService;
	}

	@Override
	public SendingDataService getSendingData() throws RemoteException {
		SendingDataService sendingDataService = new SendingData();
		return sendingDataService;
	}

}
