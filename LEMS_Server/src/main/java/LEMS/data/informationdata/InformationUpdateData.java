package LEMS.data.informationdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationUpdateDataService;
import LEMS.po.informationpo.InstitutionPO;
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
	public void updateDriver(String id) throws RemoteException{
		
	}
	public void updateVehicle(String id) throws RemoteException{
		
	}
	public void updateInstitution(String id) throws RemoteException{
		
	}
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
