package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.informationdata.InformationDeleteData;
import LEMS.data.informationdata.InformationInsertData;
import LEMS.data.informationdata.InformationUpdateData;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.informationdataservice.InformationDeleteDataService;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.informationdataservice.InformationUpdateDataService;

@SuppressWarnings("serial")
public class InformationFactoryImpl extends UnicastRemoteObject implements InformationFactory {

	public InformationFactoryImpl() throws RemoteException {
		super();
	}

	public InformationInsertDataService getInformationInsertData() throws RemoteException {
		InformationInsertDataService ii=new InformationInsertData();
		return ii;
	}

	public InformationDeleteDataService getInformationDeleteData() throws RemoteException {
		InformationDeleteDataService ind=new InformationDeleteData();
		return ind;
	}
	public InformationUpdateDataService getInformationUpdateData() throws RemoteException{
		InformationUpdateDataService iu=new InformationUpdateData();
		return iu;
	}

}
