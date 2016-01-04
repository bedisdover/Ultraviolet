package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.financedata.FinanceDeleteData;
import LEMS.data.financedata.FinanceInsertData;
import LEMS.data.financedata.IncomeBillData;
import LEMS.data.financedata.PayBillData;
import LEMS.data.financedata.PriceData;
import LEMS.data.financedata.SettlementData;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.financedataservice.FinanceDeleteDataService;
import LEMS.dataservice.financedataservice.FinanceInsertDataService;
import LEMS.dataservice.financedataservice.IncomeBillDataService;
import LEMS.dataservice.financedataservice.PayBillDataService;
import LEMS.dataservice.financedataservice.PriceDataService;
import LEMS.dataservice.financedataservice.SettlementDataService;

@SuppressWarnings("serial")
public class FinanceFactoryImpl extends UnicastRemoteObject implements FinanceFactory {

	public FinanceFactoryImpl() throws RemoteException {
		super();
	}

	//获得PriceDataService的引用
	public PriceDataService getPriceDataService() throws RemoteException {
		PriceDataService pd=new PriceData();
		return pd;
	}
	
	//获得IncomeBillDataService的引用
	public IncomeBillDataService getIncomeBillData() throws RemoteException {
		IncomeBillDataService in=new IncomeBillData();
		return in;
	}

	//获得PayBilleDataService的引用
	public PayBillDataService getPayBillData() throws RemoteException {
		PayBillDataService pa=new PayBillData();
		return pa;
	}

	public SettlementDataService getSettlementData() throws RemoteException {
		return new SettlementData();
	}
	

	public FinanceInsertDataService getInsertData() throws RemoteException {
		FinanceInsertDataService fid=new FinanceInsertData();
		return fid;
	}

	public FinanceDeleteDataService getDeleteData() throws RemoteException{
		System.out.println("啊啊啊啊啊");
		FinanceDeleteDataService fdd = new FinanceDeleteData();
		return fdd;
	}
}
