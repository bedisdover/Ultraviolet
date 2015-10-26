package LEMS.data.informationdata.stub;

import java.rmi.RemoteException;


public class InformationDeleteDataService_Stub {
	public void deleteDriverPO(long id) throws RemoteException {
		System.out.println("删除司机信息成功");
	}
	
	public void deleteVehiclePO(long id) throws RemoteException {
		System.out.println("删除车辆信息成功");
	}
	
	public void deleteInstitutionPO(String id) throws RemoteException {
		
		System.out.println("删除机构信息成功");
	}
	
	public void deleteStuffPO(String id) throws RemoteException {
		
		System.out.println("删除人员信息成功");
	}
	
	public void deleteAccountPO(String name)  throws RemoteException {
		
		System.out.println("删除账户信息成功");
	}
}
