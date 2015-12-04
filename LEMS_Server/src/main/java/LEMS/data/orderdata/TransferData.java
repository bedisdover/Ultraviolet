package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.orderdataservice.TransferDataService;
import LEMS.po.orderpo.TransferNotePO;

public class TransferData extends UnicastRemoteObject implements TransferDataService {
	private static final long serialVersionUID = 1L;

	public TransferData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public TransferNotePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TransferNotePO transferNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TransferNotePO transferNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
