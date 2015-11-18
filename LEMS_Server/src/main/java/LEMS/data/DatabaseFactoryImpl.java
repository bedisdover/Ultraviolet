package LEMS.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.inquiredata.CostBenefitListData;
import LEMS.data.inquiredata.DiaryData;
import LEMS.data.userdata.UserData;
import LEMS.dataservice.factory.DatabaseFactory;
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

}
