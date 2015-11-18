package LEMS.businesslogic.informationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;



import LEMS.dataservice.DatabaseFactory;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;
import LEMS.vo.informationvo.StaffVO;

public class InformationFind {
	/**
	 * 查找司机信息
	 */
	public void findDriverVO(long id){
		
	}
	/**
	 * 查找车辆信息
	 */
	public void findVehicleVO(long id){
		
	}
	/**
	 * 查找机构信息
	 */
	public void findInstitutionVO(String id){
		
	}
	/**
	 * 查找人员信息
	 */
	public StaffVO findStaff(String id){
		return null;
	}
	public static void main(String[] args){
		
		
		
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			UserDataService u = database.getUserData();
			ArrayList<UserPO> ua=u.find(UserRole.Manager);
			UserPO upo=ua.get(1);
			System.out.println(upo.getId()+" "+upo.getPassword()+" "+upo.getRole()+" "+upo.getName());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
