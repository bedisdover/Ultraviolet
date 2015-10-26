package LEMS.data.informationdata.stub;

import java.rmi.RemoteException;

import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StuffPO;
import LEMS.po.informationpo.VehiclePO;

public class InformationInsertDataService_Stub implements InformationInsertDataService{
	public void insertDriverPO(DriverPO drivervo) throws RemoteException {
		System.out.println("司机姓名："+drivervo.getName());
		System.out.println("司机编号："+drivervo.getId());
		System.out.println("司机身份证号："+drivervo.getIDcardNumber());
		System.out.println("司机性别："+drivervo.getGender());
		System.out.println("司机出生年月："+drivervo.getDateOfBirth());
		System.out.println("司机电话号码："+drivervo.getPhoneNumber());
	}
	
	public void insertVehiclePO(VehiclePO vehiclevo) throws RemoteException {
		System.out.println("车辆编号："+vehiclevo.getId());
		System.out.println("车辆服役时间："+vehiclevo.getWorkTime());
	}
	
	public void insertInstitutionPO(InstitutionPO institutionvo) throws RemoteException {
		
		System.out.println("添加机构信息成功");
	}
	
	public void insertStuffPO(StuffPO stuffvo) throws RemoteException {
		
		System.out.println("添加人员信息成功");
	}
	
	public void insertAccountPO(AccountPO accoutvo)  throws RemoteException {
		
		System.out.println("添加账户信息成功");
	}


}
