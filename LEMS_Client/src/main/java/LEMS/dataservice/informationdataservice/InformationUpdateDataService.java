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
	public void updateDriverPO(long id) throws RemoteException;
	public void updateVehiclePO(long id) throws RemoteException;
	public void updateInstitutionPO(String id) throws RemoteException;
	public void updateStuffPO(String id) throws RemoteException;
}
