package LEMS.dataservice.informationdataservice;

import java.rmi.RemoteException;

import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StuffPO;
import LEMS.po.informationpo.VehiclePO;

/**
 * @author 苏琰梓
 * 查找Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationFindDataService {
	public void find(DriverPO po) throws RemoteException;
	public void find(VehiclePO po) throws RemoteException;
	public void find(InstitutionPO po) throws RemoteException;
	public void find(StuffPO po) throws RemoteException;
}
