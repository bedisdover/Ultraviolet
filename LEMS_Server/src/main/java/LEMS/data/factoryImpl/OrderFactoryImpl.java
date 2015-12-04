package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.orderdata.DistanceData;
import LEMS.data.orderdata.LoadData;
import LEMS.data.orderdata.OrderData;
import LEMS.data.orderdata.ReceiptData;
import LEMS.data.orderdata.ReceiptRecordData;
import LEMS.data.orderdata.SendingData;
import LEMS.data.orderdata.TransferData;
import LEMS.data.orderdata.VehicleLoadData;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.DistanceDataService;
import LEMS.dataservice.orderdataservice.LoadDataService;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.dataservice.orderdataservice.ReceiptDataService;
import LEMS.dataservice.orderdataservice.ReceiptRecordDataService;
import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.dataservice.orderdataservice.TransferDataService;
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
	public SendingDataService getSendingData() throws RemoteException {
		SendingDataService sendingDataService = new SendingData();
		return sendingDataService;
	}

	@Override
	public VehicleLoadDataService getVehicleLoadData() throws RemoteException {
		VehicleLoadDataService vehicleLoadDataService = new VehicleLoadData();
		return vehicleLoadDataService;
	}

	@Override
	public ReceiptDataService getReceiptData() throws RemoteException {
		ReceiptDataService receiptDataService = new ReceiptData();
		return receiptDataService;
	}

	@Override
	public ReceiptRecordDataService getReceiptRecordData() throws RemoteException {
		ReceiptRecordDataService recordDataService = new ReceiptRecordData();
		return recordDataService;
	}

	@Override
	public TransferDataService getTransferData() throws RemoteException {
		TransferDataService transferDataService = new TransferData();
		return transferDataService;
	}
}
