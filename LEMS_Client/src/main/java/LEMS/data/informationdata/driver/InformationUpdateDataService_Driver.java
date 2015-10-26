package LEMS.data.informationdata.driver;

import java.rmi.RemoteException;

import LEMS.dataservice.informationdataservice.InformationUpdateDataService;

public class InformationUpdateDataService_Driver {
	public void drive(InformationUpdateDataService informationUpdateDataService){
		long idd = 025011007;
		long idh = 025011007;
		String idi = "NJ077385";
		String ids = "NJ077385123";
		
		
		try {
			informationUpdateDataService.updateDriverPO(idd);
			informationUpdateDataService.updateVehiclePO(idh);
			informationUpdateDataService.updateInstitutionPO(idi);
			informationUpdateDataService.updateStuffPO(ids);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
