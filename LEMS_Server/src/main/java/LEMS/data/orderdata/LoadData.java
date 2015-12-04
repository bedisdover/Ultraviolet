package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.orderdataservice.LoadDataService;

public class LoadData extends UnicastRemoteObject implements LoadDataService {
	private static final long serialVersionUID = 1L;

	public LoadData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
