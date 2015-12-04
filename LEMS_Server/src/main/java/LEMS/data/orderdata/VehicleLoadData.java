package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.orderdataservice.VehicleLoadDataService;
import LEMS.po.orderpo.VehicleLoadNotePO;

public class VehicleLoadData extends UnicastRemoteObject implements VehicleLoadDataService {
	private static final long serialVersionUID = 1L;

	public VehicleLoadData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public VehicleLoadNotePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(VehicleLoadNotePO vehicleLoadNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(VehicleLoadNotePO vehicleLoadNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
