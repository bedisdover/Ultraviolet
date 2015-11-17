package LEMS.dataservice.informationdataservice;

import java.rmi.RemoteException;

import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.informationpo.VehiclePO;

/**
 * @author 苏琰梓
 * 增加Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationInsertDataService {
	public void insertDriverPO(DriverPO po) throws RemoteException;
	public void insertVehiclePO(VehiclePO po) throws RemoteException;
	public void insertInstitutionPO(InstitutionPO po) throws RemoteException;
	public void insertStaffPO(StaffPO po) throws RemoteException;
	public void insertAccountPO(AccountPO po) throws RemoteException;
}
