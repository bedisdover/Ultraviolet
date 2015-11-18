package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.informationdataservice.InformationInsertDataService;

public interface InformationFactory extends Remote{
	public InformationInsertDataService getInformationInsertData() throws RemoteException;
}
