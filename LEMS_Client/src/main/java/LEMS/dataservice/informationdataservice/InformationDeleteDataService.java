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
	public void delete(DriverPO po) throws RemoteException;
	public void delete(VehiclePO po) throws RemoteException;
	public void delete(InstitutionPO po) throws RemoteException;
	public void delete(StuffPO po) throws RemoteException;
	public void delete(AccountPO po) throws RemoteException;

}
