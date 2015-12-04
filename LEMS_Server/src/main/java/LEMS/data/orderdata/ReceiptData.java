package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.orderdataservice.ReceiptDataService;
import LEMS.po.orderpo.ArrivalNotePO;

public class ReceiptData extends UnicastRemoteObject implements ReceiptDataService {
	private static final long serialVersionUID = 1L;

	public ReceiptData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrivalNotePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ArrivalNotePO arrivalNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrivalNotePO arrivalNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
