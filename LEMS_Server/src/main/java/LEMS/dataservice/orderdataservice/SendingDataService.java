package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.DeliveryNotePO;

public interface SendingDataService extends Remote {

	
	public DeliveryNotePO find(String id) throws RemoteException;
	
	public void insert(DeliveryNotePO deliveryNotePO) throws RemoteException;
	
	public void update(DeliveryNotePO deliveryNotePO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	public String createID(String institution, String date) throws RemoteException;

}
