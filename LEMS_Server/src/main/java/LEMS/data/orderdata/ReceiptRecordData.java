package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.orderdataservice.ReceiptRecordDataService;
import LEMS.po.orderpo.IncomeBillPO;

public class ReceiptRecordData extends UnicastRemoteObject implements ReceiptRecordDataService {
	private static final long serialVersionUID = 1L;

	public ReceiptRecordData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public IncomeBillPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(IncomeBillPO incomeBillPO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(IncomeBillPO incomeBillPO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
