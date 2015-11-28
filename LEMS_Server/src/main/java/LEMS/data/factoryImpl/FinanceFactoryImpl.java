package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.financedata.IncomeBillData;
import LEMS.data.financedata.PayBillData;
import LEMS.data.financedata.PriceData;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.financedataservice.IncomeBillDataService;
import LEMS.dataservice.financedataservice.PayBillDataService;
import LEMS.dataservice.financedataservice.PriceDataService;

@SuppressWarnings("serial")
public class FinanceFactoryImpl extends UnicastRemoteObject implements FinanceFactory {

	public FinanceFactoryImpl() throws RemoteException {
		super();
	}

	public PriceDataService getPriceDataService() throws RemoteException {
		PriceDataService pd=new PriceData();
		return pd;
	}

	public IncomeBillDataService getIncomeBillData() throws RemoteException {
		IncomeBillDataService in=new IncomeBillData();
		return in;
	}

	public PayBillDataService getPayBillData() throws RemoteException {
		PayBillDataService pa=new PayBillData();
		return pa;
	}

}
