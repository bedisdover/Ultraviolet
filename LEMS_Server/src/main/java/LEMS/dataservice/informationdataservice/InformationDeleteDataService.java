package LEMS.dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author 苏琰梓
 * 删除Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationDeleteDataService extends Remote{
	public void deleteDriver(String id) throws RemoteException;
	public void deleteVehicle(String id) throws RemoteException;
	public void deleteInstitution(String id) throws RemoteException;
	public void deleteStaff(String id) throws RemoteException;
	public void deleteAccount(String id) throws RemoteException;
	public void deleteSalary(String id) throws RemoteException;
}
