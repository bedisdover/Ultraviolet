package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.userdata.UserData;
import LEMS.dataservice.factory.UserFactory;
import LEMS.dataservice.userdataservice.UserDataService;

@SuppressWarnings("serial")
public class UserFactoryImpl extends UnicastRemoteObject implements UserFactory {

	public UserFactoryImpl() throws RemoteException {
		super();
	}

	//获得UserDataService的引用
	public UserDataService getUserData() throws RemoteException {
		UserDataService user=new UserData();
		return (UserData)user;
	}

}
