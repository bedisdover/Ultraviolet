package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.ArrivalNotePO;

public interface ReceiptDataService extends Remote {

	public ArrivalNotePO find(String id) throws RemoteException;
	
	public void insert(ArrivalNotePO arrivalNotePO) throws RemoteException;
	
	public void update(ArrivalNotePO arrivalNotePO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
}
