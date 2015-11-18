package LEMS.dataservice.informationdataservice;

import java.rmi.RemoteException;





import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserRole;


/**
 * @author 苏琰梓
 * 查找Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationFindDataService {
	public void findDriverPO(long id) throws RemoteException;
	public void findVehiclePO(long id) throws RemoteException;
	public void findInstitutionPO(String id) throws RemoteException;
	public StaffPO findStaffPO(String i,String password,UserRole r) throws RemoteException;
}
