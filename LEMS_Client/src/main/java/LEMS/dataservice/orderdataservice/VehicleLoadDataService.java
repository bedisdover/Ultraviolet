package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.VehicleLoadNotePO;

public interface VehicleLoadDataService extends Remote {
	
	public VehicleLoadNotePO find(String id) throws RemoteException;
	
	public void insert(VehicleLoadNotePO vehicleLoadNotePO) throws RemoteException;
	
	public void update(VehicleLoadNotePO vehicleLoadNotePO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
}
