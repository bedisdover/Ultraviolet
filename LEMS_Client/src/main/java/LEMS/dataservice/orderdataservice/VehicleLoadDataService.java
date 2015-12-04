package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.VehicleLoadPO;

public interface VehicleLoadDataService extends Remote {
	
	public VehicleLoadPO find(String id) throws RemoteException;
	
	public void insert(VehicleLoadPO vehicleLoadNotePO) throws RemoteException;
	
	public void update(VehicleLoadPO vehicleLoadNotePO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
}
