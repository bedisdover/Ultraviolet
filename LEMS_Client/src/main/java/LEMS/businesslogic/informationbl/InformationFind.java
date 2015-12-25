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
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.financepo.SalaryPO;
import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;
import LEMS.vo.financevo.SalaryVO;
import LEMS.vo.informationvo.AccountVO;
import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.VehicleVO;
import LEMS.vo.uservo.UserVO;

public class InformationFind implements InformationFindService{
	/**
	 * 根据营业厅编号查找司机信息
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
	 * 根据司机编号查找司机信息
	 */
	public DriverVO findTheDriver(String id){
		DriverVO d=new DriverVO();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			DriverPO dpo=infofind.findTheDriver(id);
			d.setId(dpo.getId());
			d.setName(dpo.getName());
			d.setDateOfBirth(dpo.getDateOfBirth());
			d.setDrivingPeriod(dpo.getDrivingPeriod());
			d.setIDcardNumber(dpo.getIDcardNumber());
			d.setPhoneNumber(dpo.getPhoneNumber());
			d.setGender(dpo.getGender());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return d;
	}
	/**
	 * 根据营业厅编号查找车辆信息
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
	 * 根据车辆编号查找车辆信息
	 */
	public VehicleVO findTheVehicle(String id){
		VehicleVO vvo=new VehicleVO();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			VehiclePO vpo=infofind.findTheVehicle(id);
			vvo.setId(vpo.getId());
			vvo.setPlateNumber(vpo.getPlateNumber());
			vvo.setWorkTime(vpo.getWorkTime());
			vvo.setImage(vpo.getImage());
			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return vvo;
	}
	/**
	 * 查找所有机构信息
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
	 * @param s
	 * @return InstitutionVO
	 * 根据指定编号查找机构信息
	 */
	public InstitutionVO findTheInstitution(String s){
		InstitutionVO institution=new InstitutionVO();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			InstitutionPO theinstitution=infofind.findTheInstitution(s);
			institution.setID(theinstitution.getID());
			institution.setLocation(theinstitution.getLocation());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return institution;
	}
	/**
	 * 查找所有人员信息
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
	public UserVO findStaff(String id){
		UserVO uvo=null;
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infoFac=database.getInformationFactory();
			InformationFindDataService find = infoFac.getInformationFindData();
			UserPO upo=find.findStaff(id);
			uvo=new UserVO(upo.getId(),upo.getPassword(),upo.getRole(),upo.getName(),upo.getInstitution());			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return uvo;
	}
	/**
	 * 查找所有账户信息
	 */
	public ArrayList<AccountVO> findAccount(){
		ArrayList<AccountVO> accountvo=new ArrayList<AccountVO>();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			ArrayList<AccountPO> accounts=infofind.findAccount();
			for(int i=0;i<accounts.size();i++){
				AccountVO avo=new AccountVO(accounts.get(i).getId(),accounts.get(i).getPassword(),accounts.get(i).getBalance());
				accountvo.add(avo);
			}			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return accountvo;
	}
	/**
	 * 根据卡号查找账户信息
	 */
	public AccountVO findTheAccount(String id){
		AccountVO account=null;
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			AccountPO theaccount=infofind.findTheAccount(id);
			account=new AccountVO(theaccount.getId(),theaccount.getPassword(),theaccount.getBalance());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return account;
	}
	
	/**
	 * 查找所有人员薪水信息
	 */
	public ArrayList<SalaryVO> findSalary(){
		ArrayList<SalaryVO> salavo=new ArrayList<SalaryVO>();
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			ArrayList<SalaryPO> salas=infofind.findSalary();
			for(int i=0;i<salas.size();i++){
				SalaryVO svo=new SalaryVO(salas.get(i).getId(),salas.get(i).getInstitution(),salas.get(i).getName(),salas.get(i).getSalary());
				salavo.add(svo);
			}			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return salavo;
	}
	
	/**
	 * 根据id查找某一人员薪水信息
	 */
	public SalaryVO findTheSalary(String id){
		SalaryVO sala=null;
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory findFac=database.getInformationFactory();
			InformationFindDataService infofind = findFac.getInformationFindData();
			SalaryPO thesala=infofind.findTheSalary(id);
			sala=new SalaryVO(thesala.getId(),thesala.getInstitution(),thesala.getName(),thesala.getSalary());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		return sala;
	}
}
