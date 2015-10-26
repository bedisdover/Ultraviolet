package LEMS.data.informationdata.stub;

import java.rmi.RemoteException;

public class InformationUpdateDataService_Stub {
	public void updateDriverPO(long id) throws RemoteException {
		System.out.println("更新司机信息成功");
	}
	
	public void updateVehiclePO(long id) throws RemoteException {
		System.out.println("更新车辆信息成功");
	}
	
	public void updateInstitutionPO(String id) throws RemoteException {
		
		System.out.println("更新机构信息成功");
	}
	
	public void updateStuffPO(String id) throws RemoteException {
		
		System.out.println("更新人员信息成功");
	}
	
}
