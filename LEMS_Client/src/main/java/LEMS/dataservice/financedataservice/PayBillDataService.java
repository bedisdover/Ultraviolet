package LEMS.dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.financepo.PayBillPO;

public interface PayBillDataService extends Remote{
	public ArrayList<PayBillPO> getPayBill() throws RemoteException;
}
