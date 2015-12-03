package LEMS.businesslogic.informationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogicservice.informationblservice.InformationUpdateService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.informationdataservice.InformationDeleteDataService;
import LEMS.dataservice.informationdataservice.InformationUpdateDataService;
import LEMS.po.userpo.UserPO;

public class InformationUpdate implements InformationUpdateService{
	public void updateStaff(UserPO upo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			InformationFactory infof=database.getInformationFactory();
			InformationUpdateDataService infod=infof.getInformationUpdateData();
			infod.updateStaff(upo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDriverVO(long id) {
		
	}

	@Override
	public void updateVehicleVO(long id) {
		
	}

	@Override
	public void updateInstitutionVO(String id) {
		
	}


}
