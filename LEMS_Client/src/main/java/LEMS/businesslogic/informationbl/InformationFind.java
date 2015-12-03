package LEMS.businesslogic.informationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogicservice.informationblservice.InformationFindService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.factory.UserFactory;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;
import LEMS.vo.informationvo.StaffVO;
import LEMS.vo.uservo.UserVO;

public class InformationFind implements InformationFindService{
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
	public ArrayList<UserVO> findStaff(){
		ArrayList<UserVO> uservo=new ArrayList<UserVO>();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			UserFactory userFac=database.getUserFactory();
			UserDataService us = userFac.getUserData();
			ArrayList<UserPO> users=us.findAll();
			for(int i=0;i<users.size();i++){
				UserVO uvo=new UserVO(users.get(i).getId(),users.get(i).getPassword(),users.get(i).getRole(),users.get(i).getName(),users.get(i).getInstitution());
				uservo.add(uvo);
			}
			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return uservo;
	}
	
}
