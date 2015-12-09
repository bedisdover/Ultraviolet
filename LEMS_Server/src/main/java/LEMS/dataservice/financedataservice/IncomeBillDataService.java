package LEMS.dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.financepo.IncomeBillPO;

public interface IncomeBillDataService extends Remote{
	public ArrayList<IncomeBillPO> getIncomeBill() throws RemoteException;
}
