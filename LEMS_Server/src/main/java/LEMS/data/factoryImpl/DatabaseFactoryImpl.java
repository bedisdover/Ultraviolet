package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.inquiredata.CostBenefitListData;
import LEMS.data.inquiredata.DiaryData;
import LEMS.data.userdata.UserData;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.factory.InquireFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.factory.StoreFactory;
import LEMS.dataservice.factory.UserFactory;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.dataservice.userdataservice.UserDataService;

@SuppressWarnings("serial")
public class DatabaseFactoryImpl extends UnicastRemoteObject implements
		DatabaseFactory {

	public DatabaseFactoryImpl() throws RemoteException {
		super();

	}

	public FinanceFactory getFinanceFactory() throws RemoteException {
		return null;
	}

	public InformationFactory getInformationFactory() throws RemoteException {
		InformationFactoryImpl info = new InformationFactoryImpl();
		return info;
	}

	public InquireFactory getInquireFactory() throws RemoteException {
		InquireFactoryImpl inquire=new InquireFactoryImpl();
		return inquire;
	}

	public OrderFactory getOrderFactory() throws RemoteException {
		return null;
	}

	public StoreFactory getStoreFactory() throws RemoteException {
		return null;
	}

	public UserFactory getUserFactory() throws RemoteException {
		UserFactoryImpl us = new UserFactoryImpl();
		return us;
	}

}
