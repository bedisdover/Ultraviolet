package LEMS.dataservice.informationdataservice;

import java.rmi.RemoteException;

import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StuffPO;
import LEMS.po.informationpo.VehiclePO;

/**
 * @author 苏琰梓
 * 删除Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationDeleteDataService {
	public void deleteDriverPO(long id) throws RemoteException;
	public void deleteVehiclePO(long id) throws RemoteException;
	public void deleteInstitutionPO(String id) throws RemoteException;
	public void deleteStuffPO(String id) throws RemoteException;
	public void deleteAccountPO(String name) throws RemoteException;

}
