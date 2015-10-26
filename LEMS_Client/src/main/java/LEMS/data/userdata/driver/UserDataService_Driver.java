package LEMS.data.userdata.driver;

import java.rmi.RemoteException;

import LEMS.businesslogicservice.userblservice.UserLoginService;
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

public class UserDataService_Driver {
	public void drive(UserDataService userDataService){
		UserPO po = new UserPO(123456, "用户2", "hh", null);
		try {
			userDataService.insert(po);
			userDataService.delete(123456);
			userDataService.find(123456);
			userDataService.update(123456);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
