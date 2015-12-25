package LEMS.dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.financepo.SalaryPO;
import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;

/**
 * @author 苏琰梓
 * 增加Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationInsertDataService extends Remote{
	public void insert(DriverPO po) throws RemoteException;
	public void insert(VehiclePO po) throws RemoteException;
	public void insert(InstitutionPO po) throws RemoteException;
	public void insert(UserPO po) throws RemoteException;
	public void insert(AccountPO po) throws RemoteException;
	public void insert(SalaryPO po) throws RemoteException;
}
