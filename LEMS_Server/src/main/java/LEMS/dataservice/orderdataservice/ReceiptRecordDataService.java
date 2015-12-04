package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.IncomeBillPO;

public interface ReceiptRecordDataService extends Remote {
	public IncomeBillPO find(String id) throws RemoteException;
	
	public void insert(IncomeBillPO incomeBillPO) throws RemoteException;
	
	public void update(IncomeBillPO incomeBillPO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
}
