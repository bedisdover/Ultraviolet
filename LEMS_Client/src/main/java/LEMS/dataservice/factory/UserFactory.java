package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.userdataservice.UserDataService;

public interface UserFactory extends Remote {
	public UserDataService getUserData() throws RemoteException;
}
