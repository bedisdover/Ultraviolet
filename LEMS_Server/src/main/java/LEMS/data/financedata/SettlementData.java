package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import LEMS.dataservice.financedataservice.SettlementDataService;
import LEMS.po.orderpo.IncomePO;

public class SettlementData extends UnicastRemoteObject implements SettlementDataService {
	private static final long serialVersionUID = 1L;

	public SettlementData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<IncomePO> getIncomePO(String date, String institution) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
