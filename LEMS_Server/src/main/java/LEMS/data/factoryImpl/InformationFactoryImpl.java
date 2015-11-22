package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.informationdata.InformationInsertData;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;

@SuppressWarnings("serial")
public class InformationFactoryImpl extends UnicastRemoteObject implements InformationFactory {

	public InformationFactoryImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public InformationInsertDataService getInformationInsertData() throws RemoteException {
		// TODO Auto-generated method stub
		InformationInsertDataService ii=new InformationInsertData();
		return (InformationInsertData)ii;
	}

}
