package LEMS.data.informationdata.stub;

import java.rmi.RemoteException;

public class InformationFindDataService_Stub {
	public void findDriverPO(long id) throws RemoteException {
		System.out.println("查询司机信息成功");
	}
	
	public void findVehiclePO(long id) throws RemoteException {
		System.out.println("查询车辆信息成功");
	}
	
	public void findInstitutionPO(String id) throws RemoteException {
		
		System.out.println("查询机构信息成功");
	}
	
	public void findStuffPO(String id) throws RemoteException {
		
		System.out.println("查询人员信息成功");
	}
	
}
