package LEMS.dataservice.informationdataservice;

import java.rmi.RemoteException;

import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StuffPO;
import LEMS.po.informationpo.VehiclePO;

/**
 * @author 苏琰梓
 * 更新Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationUpdateDataService {
	public void update(DriverPO po) throws RemoteException;
	public void update(VehiclePO po) throws RemoteException;
	public void update(InstitutionPO po) throws RemoteException;
	public void update(StuffPO po) throws RemoteException;
}
