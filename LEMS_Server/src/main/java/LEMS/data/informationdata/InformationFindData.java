package LEMS.data.informationdata;

import java.rmi.RemoteException;




import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationFindDataService;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

/**
 * @author 苏琰梓
 * InformationFind包数据
 * 2015年10月26日
 */
@SuppressWarnings("serial")
public class InformationFindData extends UnicastRemoteObject implements InformationFindDataService{
	public InformationFindData() throws RemoteException {
		super();
	}
	public void findDriverPO(long id) throws RemoteException{
		
	}
	public void findVehiclePO(long id) throws RemoteException{
		
	}
	public void findInstitutionPO(String id) throws RemoteException{
		
	}
	public UserPO findStaff(String id) throws RemoteException{
		UserRole role=null;
		UserPO spo=null;
		Connect co=new Connect();
		String sql="SELECT * FROM user";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					switch(result.getString(3)){
					case "Manager":
						role=UserRole.Manager;
						break;
					case "GeneralManager":
						role=UserRole.GeneralManager;
						break;
					case "StoreManager":
						role=UserRole.StoreManager;
						break;
					case "BusinessClerk":
						role=UserRole.BusinessClerk;
						break;
					case "TransferClerk":
						role=UserRole.TransferClerk;
						break;
					case "Courier":
						role=UserRole.Courier;
						break;
					case "FinanceClerk":
						role=UserRole.FinanceClerk;
						break;
					default:
						break;
					}
					InstitutionPO ipo=new InstitutionPO(result.getString(5),result.getString(6));
					spo=new UserPO(result.getString(1),result.getString(2),role,result.getString(4),ipo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		co.closeConnection();
		return spo;
	}
}
