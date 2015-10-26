package LEMS.data.informationdata.driver;

import java.rmi.RemoteException;

import LEMS.dataservice.informationdataservice.InformationDeleteDataService;

public class InformationDeleteDataService_Driver {
	public void drive(InformationDeleteDataService informationDeleteDataService){
		long idd = 025011007;
		long idh = 025011007;
		String idi = "NJ077385";
		String ids = "NJ077385123";
		String name = "账户1";
		
		try {
			informationDeleteDataService.deleteDriverPO(idd);
			informationDeleteDataService.deleteVehiclePO(idh);
			informationDeleteDataService.deleteInstitutionPO(idi);
			informationDeleteDataService.deleteStuffPO(ids);
			informationDeleteDataService.deleteAccountPO(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
