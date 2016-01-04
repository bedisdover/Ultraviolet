package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.financedataservice.FinanceDeleteDataService;
import LEMS.dataservice.financedataservice.FinanceInsertDataService;
import LEMS.dataservice.financedataservice.IncomeBillDataService;
import LEMS.dataservice.financedataservice.PayBillDataService;
import LEMS.dataservice.financedataservice.PriceDataService;
import LEMS.dataservice.financedataservice.SettlementDataService;

public interface FinanceFactory extends Remote {
	/**
	 * 获得价格数据服务的引用
	 * 
	 * @return 
	 * @throws RemoteException
	 */
	public PriceDataService getPriceDataService() throws RemoteException;
	
	/**
	 * 
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public IncomeBillDataService getIncomeBillData() throws RemoteException;
	
	/**
	 * @return
	 * @throws RemoteException
	 */
	public PayBillDataService getPayBillData() throws RemoteException;
	
	/**
	 * @return
	 * @throws RemoteException
	 */
	public SettlementDataService getSettlementData() throws RemoteException;
	
	public FinanceInsertDataService getInsertData() throws RemoteException;
	
	public FinanceDeleteDataService getDeleteData() throws RemoteException;
	
}
