package LEMS.dataservice.informationdataservice;

import java.rmi.RemoteException;

import javax.swing.text.Position;

import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.informationpo.VehiclePO;

/**
 * @author 苏琰梓
 * 查找Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationFindDataService {
	public void findDriverPO(long id) throws RemoteException;
	public void findVehiclePO(long id) throws RemoteException;
	public void findInstitutionPO(String id) throws RemoteException;
	public StaffPO findStaffPO(String i,String password,Position p) throws RemoteException;
}
