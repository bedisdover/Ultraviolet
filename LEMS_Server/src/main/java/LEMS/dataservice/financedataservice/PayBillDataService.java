package LEMS.dataservice.financedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.financepo.PayBillPO;

public interface PayBillDataService {
	public ArrayList<PayBillPO> getPayBill(String start,String end) throws RemoteException;
}
