package LEMS.data;

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
public class DatabaseFactoryImpl extends UnicastRemoteObject implements DatabaseFactory {

	public DatabaseFactoryImpl() throws RemoteException {
		super();

	}

	public DiaryData getDiaryData() throws RemoteException{
		// TODO Auto-generated method stub
		DiaryDataService diary=new DiaryData();
		return (DiaryData) diary;
	}

	public CostBenefitListData getCostBenefitList() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public InformationInsertDataService getInformationInsertData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDataService getUserData() throws RemoteException {
		// TODO Auto-generated method stub
		UserDataService user=new UserData();
		return (UserData)user;
	}

	
	//****************************************************
	//******************************************************
	//TODO
	
	public FinanceFactory getFinanceFactory() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public InformationFactory getInformationFactory() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public InquireFactory getInquireFactory() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderFactory getOrderFactory() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public StoreFactory getStoreFactory() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserFactory getUserFactory() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
