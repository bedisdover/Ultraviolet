package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.po.orderpo.DeliveryNotePO;

public class SendingData extends UnicastRemoteObject implements SendingDataService {
	private static final long serialVersionUID = 1L;

	public SendingData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public DeliveryNotePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(DeliveryNotePO deliveryNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DeliveryNotePO deliveryNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
