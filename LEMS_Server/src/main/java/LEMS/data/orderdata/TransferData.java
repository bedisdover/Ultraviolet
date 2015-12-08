package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.Connect;
import LEMS.data.TransferID;
import LEMS.dataservice.orderdataservice.TransferDataService;
import LEMS.po.orderpo.TransferNotePO;

public class TransferData extends UnicastRemoteObject implements TransferDataService {
	private static final long serialVersionUID = 1L;

	private final int MAX_LENGTH = 20;
	
	private Connect connect;
	
	private TransferID transferID;
	
	public TransferData() throws RemoteException {
		super();
		
		connect = new Connect();
		transferID = new TransferID();
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

	@Override
	public String createID(String institution, String date) throws RemoteException {
		String id = new CreateID().createID("transfernote", MAX_LENGTH, institution + date);
		
		return id;
	}

}
