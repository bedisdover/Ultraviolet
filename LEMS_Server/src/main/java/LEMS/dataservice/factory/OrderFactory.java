package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.orderdataservice.DistanceDataService;
import LEMS.dataservice.orderdataservice.LoadDataService;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.dataservice.orderdataservice.ReceiptDataService;
import LEMS.dataservice.orderdataservice.ReceiptRecordDataService;
import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.dataservice.orderdataservice.TransferDataService;
import LEMS.dataservice.orderdataservice.VehicleLoadDataService;

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
	
	/**
	 * 获得距离数据服务
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public DistanceDataService getDistanceData() throws RemoteException;
	
	public VehicleLoadDataService getVehicleLoadData() throws RemoteException;
	
	public SendingDataService getSendingData() throws RemoteException;
	
	public ReceiptDataService getReceiptData() throws RemoteException;
	
	public ReceiptRecordDataService getReceiptRecordData() throws RemoteException;
	
	public TransferDataService getTransferData() throws RemoteException;
}
