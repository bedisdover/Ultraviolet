package LEMS.data.informationdata.driver;

import java.awt.Image;
import java.rmi.RemoteException;

import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.Gender;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StuffPO;
import LEMS.po.informationpo.VehiclePO;

public class InformationInsertDataService_Driver {
	public void drive(InformationInsertDataService informationInsertDataService){
		Image i = null;
		DriverPO pod = new DriverPO("025011007","狗头","1994年3月23日","622421199403246430"
				,"17752748532","2016年7月4日",Gender.MAN);
		VehiclePO vov = new VehiclePO("025011007","苏A3022","1994年3月23日",i);
		InstitutionPO voi = new InstitutionPO("NJ077385","南京市");
		InstitutionPO poTemp = new InstitutionPO("NJ077385","南京市");
		StuffPO vos = new StuffPO("NJ077385123",poTemp);
		AccountPO voa = new AccountPO("账户1","12345",12300.45);
		
		try {
			informationInsertDataService.insertDriverPO(pod);
			informationInsertDataService.insertVehiclePO(vov);
			informationInsertDataService.insertInstitutionPO(voi);
			informationInsertDataService.insertStuffPO(vos);
			informationInsertDataService.insertAccountPO(voa);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
