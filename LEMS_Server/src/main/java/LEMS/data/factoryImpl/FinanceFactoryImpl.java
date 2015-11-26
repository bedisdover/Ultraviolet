package LEMS.data.factoryImpl;

import java.rmi.RemoteException;

import LEMS.data.financedata.IncomeBillData;
import LEMS.data.financedata.PayBillData;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.financedataservice.IncomeBillDataService;
import LEMS.dataservice.financedataservice.PayBillDataService;
import LEMS.dataservice.financedataservice.PriceDataService;

public class FinanceFactoryImpl implements FinanceFactory {

	public PriceDataService getPriceDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
