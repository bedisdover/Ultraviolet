package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DatabaseFactory extends Remote {



	/**
	 * 获得FinanceFactory的引用
	 */
	public FinanceFactory getFinanceFactory() throws RemoteException;

	/**
	 * 获得InformationFactory的引用
	 */
	public InformationFactory getInformationFactory() throws RemoteException;

	/**
	 * 获得InquireFactory的引用
	 */
	public InquireFactory getInquireFactory() throws RemoteException;

	/**
	 * 获得OrderFactory的引用
	 */
	public OrderFactory getOrderFactory() throws RemoteException;

	/**
	 * 获得StoreFactory的引用
	 */
	public StoreFactory getStoreFactory() throws RemoteException;

	/**
	 * 获得UserFactory的引用
	 */
	public UserFactory getUserFactory() throws RemoteException;

}
