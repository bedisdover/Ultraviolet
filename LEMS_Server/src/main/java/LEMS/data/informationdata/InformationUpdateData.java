package LEMS.data.informationdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationUpdateDataService;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

/**
 * @author 苏琰梓
 * InformationUpdate包数据
 * 2015年10月26日
 */
@SuppressWarnings("serial")
public class InformationUpdateData extends UnicastRemoteObject implements InformationUpdateDataService{
	public InformationUpdateData() throws RemoteException {
		super();
	}
	
	//更新一项司机信息
	public void updateDriver(DriverPO dpo) throws RemoteException{
		InformationDeleteData delete=new InformationDeleteData();
		delete.deleteDriver(dpo.getId());
		InformationInsertData insert=new InformationInsertData();
		insert.insert(dpo);
	}
	
	//更新一项车辆信息
	public void updateVehicle(VehiclePO vpo) throws RemoteException{
		InformationDeleteData delete=new InformationDeleteData();
		delete.deleteVehicle(vpo.getId());
		InformationInsertData insert=new InformationInsertData();
		insert.insert(vpo);
	}
	
	//更新一项机构信息
	public void updateInstitution(InstitutionPO ipo) throws RemoteException{
		InformationDeleteData delete=new InformationDeleteData();
		delete.deleteInstitution(ipo.getID());
		InformationInsertData insert=new InformationInsertData();
		insert.insert(ipo);
	}
	
	//更新一项人员信息
	public void updateStaff(UserPO upo) throws RemoteException{
		InformationDeleteData delete=new InformationDeleteData();
		delete.deleteStaff(upo.getId());
		InformationInsertData insert=new InformationInsertData();
		insert.insert(upo);
	}
	
	
	public static void main(String[] args){
		try {
			InformationUpdateData o=new InformationUpdateData();
			InstitutionPO ipo=new InstitutionPO("","");
			o.updateStaff(new UserPO("m00000","123456",UserRole.Manager,"宋益明",ipo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
