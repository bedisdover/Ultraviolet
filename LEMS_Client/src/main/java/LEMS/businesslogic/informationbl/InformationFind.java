package LEMS.businesslogic.informationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.informationblservice.InformationFindService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.factory.UserFactory;
import LEMS.dataservice.informationdataservice.InformationFindDataService;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;
import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.StaffVO;
import LEMS.vo.informationvo.VehicleVO;
import LEMS.vo.uservo.UserVO;

public class InformationFind implements InformationFindService{
	/**
	 * 查找司机信息
	 */
	public ArrayList<DriverVO> findDriver(String businessid){
		ArrayList<DriverVO> drivervo=new ArrayList<DriverVO>();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			ArrayList<DriverPO> drivers=infofind.findDriver(businessid);
			for(int i=0;i<drivers.size();i++){
				DriverVO dvo=new DriverVO(drivers.get(i).getId(),drivers.get(i).getName(),drivers.get(i).getDateOfBirth(),drivers.get(i).getIDcardNumber(),drivers.get(i).getPhoneNumber(),drivers.get(i).getDrivingPeriod(),drivers.get(i).getGender());
				drivervo.add(dvo);
			}			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return drivervo;
	}
	/**
	 * 查找车辆信息
	 */
	public ArrayList<VehicleVO> findVehicle(String businessid){
		ArrayList<VehicleVO> vehiclevo=new ArrayList<VehicleVO>();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			ArrayList<VehiclePO> vehicles=infofind.findVehicle(businessid);
			for(int i=0;i<vehicles.size();i++){
				VehicleVO vvo=new VehicleVO(vehicles.get(i).getId(),vehicles.get(i).getPlateNumber(),vehicles.get(i).getWorkTime(),vehicles.get(i).getImage());
				vehiclevo.add(vvo);
			}			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return vehiclevo;
	}
	/**
	 * 查找机构信息
	 */
	public ArrayList<InstitutionVO> findInstitution(){
		ArrayList<InstitutionVO> institutionvo=new ArrayList<InstitutionVO>();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			ArrayList<InstitutionPO> institutions=infofind.findInstitution();
			for(int i=0;i<institutions.size();i++){
				InstitutionVO ivo=new InstitutionVO(institutions.get(i).getID(),institutions.get(i).getLocation());
				institutionvo.add(ivo);
			}			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return institutionvo;
	}
	/**
	 * 查找人员信息
	 */
	public ArrayList<UserVO> findStaff(){
		ArrayList<UserVO> uservo=new ArrayList<UserVO>();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
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
