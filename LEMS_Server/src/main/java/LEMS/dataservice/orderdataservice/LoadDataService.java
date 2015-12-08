package LEMS.dataservice.orderdataservice;

import java.rmi.RemoteException;

import LEMS.po.orderpo.LoadNotePO;

public interface LoadDataService {
	public LoadNotePO find(String id) throws RemoteException;
	
	public void insert(LoadNotePO LoadNotePO) throws RemoteException;
	
	public void update(LoadNotePO LoadNotePO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	public String createID(String institution, String date) throws RemoteException;
}
