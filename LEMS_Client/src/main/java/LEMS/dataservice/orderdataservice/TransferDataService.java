package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.TransferNotePO;

public interface TransferDataService extends Remote {
	public TransferNotePO find(String id) throws RemoteException;
	
	public void insert(TransferNotePO transferNotePO) throws RemoteException;
	
	public void update(TransferNotePO transferNotePO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
}
