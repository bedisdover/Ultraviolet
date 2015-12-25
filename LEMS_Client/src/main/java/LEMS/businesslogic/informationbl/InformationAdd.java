package LEMS.businesslogic.informationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.informationblservice.InformationAddService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
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

public class InformationAdd implements InformationAddService{
	/**
	 * 增加司机信息
	 */
	public void addDriver(DriverVO drivervo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory inf=database.getInformationFactory();
			InformationInsertDataService infoinsert=inf.getInformationInsertData();
			DriverPO dp=new DriverPO(drivervo.getId(),drivervo.getName(),drivervo.getDateOfBirth(),drivervo.getIDcardNumber(),drivervo.getPhoneNumber(),drivervo.getDrivingPeriod(),drivervo.getGender());
			infoinsert.insert(dp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 增加车辆信息
	 */
	public void addVehicle(VehicleVO vehiclevo){
		try{
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory inf=database.getInformationFactory();
			InformationInsertDataService infoinsert=inf.getInformationInsertData();
			VehiclePO vp=new VehiclePO(vehiclevo.getId(),vehiclevo.getPlateNumber(),vehiclevo.getWorkTime(),vehiclevo.getImage());
			infoinsert.insert(vp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 增加机构信息
	 */
	public void addInstitution(InstitutionVO institutionvo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory inf=database.getInformationFactory();
			InformationInsertDataService infoinsert=inf.getInformationInsertData();
			InstitutionPO ip=new InstitutionPO(institutionvo.getID(),institutionvo.getLocation());
			infoinsert.insert(ip);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 增加人员信息
	 */
	public void addStaff(UserVO uservo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory inf=database.getInformationFactory();
			InformationInsertDataService infoinsert=inf.getInformationInsertData();
			UserPO sp=new UserPO(uservo.getId(),uservo.getPassword(),uservo.getRole(),uservo.getName(),uservo.getInstitution());
			infoinsert.insert(sp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 增加账户信息
	 */
	public void addAccount(AccountVO accountvo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory inf=database.getInformationFactory();
			InformationInsertDataService infoinsert=inf.getInformationInsertData();
			AccountPO ap=new AccountPO(accountvo.getId(),accountvo.getPassword(),accountvo.getBalance());
			infoinsert.insert(ap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 增加人员薪水信息
	 */
	public void addSalary(SalaryVO salaryvo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory inf=database.getInformationFactory();
			InformationInsertDataService infoinsert=inf.getInformationInsertData();
			SalaryPO sp=new SalaryPO(salaryvo.getId(),salaryvo.getInstitution(),salaryvo.getName(),salaryvo.getSalary());
			infoinsert.insert(sp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
