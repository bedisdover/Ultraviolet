package LEMS.data.informationdata.driver;

import java.rmi.RemoteException;

import LEMS.businesslogicservice.informationblservice.InformationFindService;
import LEMS.dataservice.informationdataservice.InformationFindDataService;

public class InformationFindDataService_Driver {
	public void drive(InformationFindDataService informationFindDataService){
		long idd = 025011007;
		long idh = 025011007;
		String idi = "NJ077385";
		String ids = "NJ077385123";
		
		
		try {
			informationFindDataService.findDriverPO(idd);
			informationFindDataService.findVehiclePO(idh);
			informationFindDataService.findInstitutionPO(idi);
			informationFindDataService.findStuffPO(ids);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
