package LEMS.dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.financepo.PayBillPO;

public interface FinanceInsertDataService extends Remote{
	
	public void insertCost(PayBillPO payPO) throws RemoteException;
}
