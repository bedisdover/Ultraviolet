package LEMS.dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FinanceDeleteDataService extends Remote{
	public void deleteCost(String id) throws RemoteException;
}
