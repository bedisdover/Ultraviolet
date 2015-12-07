package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.informationdataservice.InformationDeleteDataService;
import LEMS.dataservice.informationdataservice.InformationFindDataService;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.informationdataservice.InformationUpdateDataService;

public interface InformationFactory extends Remote{
	public InformationInsertDataService getInformationInsertData() throws RemoteException;
	public InformationDeleteDataService getInformationDeleteData() throws RemoteException;
	public InformationUpdateDataService getInformationUpdateData() throws RemoteException;
	public InformationFindDataService getInformationFindData() throws RemoteException;
}
