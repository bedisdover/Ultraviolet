package LEMS.businesslogic.informationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.informationblservice.InformationUpdateService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.informationdataservice.InformationUpdateDataService;
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

public class InformationUpdate implements InformationUpdateService{
	//更新人员信息
	public void updateStaff(UserVO uvo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationUpdateDataService infod=infof.getInformationUpdateData();
			UserPO upo=new UserPO(uvo.getId(),uvo.getPassword(),uvo.getRole(),uvo.getName(),uvo.getInstitution());
			infod.updateStaff(upo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	//更新司机信息
	public void updateDriver(DriverVO dvo) {
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationUpdateDataService infod=infof.getInformationUpdateData();
			DriverPO dpo=new DriverPO(dvo.getId(),dvo.getName(),dvo.getDateOfBirth(),dvo.getIDcardNumber(),dvo.getPhoneNumber(),dvo.getDrivingPeriod(),dvo.getGender());
			infod.updateDriver(dpo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	//更新车辆信息
	public void updateVehicle(VehicleVO vvo) {
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationUpdateDataService infod=infof.getInformationUpdateData();
			VehiclePO vpo=new VehiclePO(vvo.getId(),vvo.getPlateNumber(),vvo.getWorkTime(),vvo.getImage());
			infod.updateVehicle(vpo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	//更新机构信息
	public void updateInstitution(InstitutionVO ivo) {
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationUpdateDataService infod=infof.getInformationUpdateData();
			InstitutionPO ipo=new InstitutionPO(ivo.getID(),ivo.getLocation());
			infod.updateInstitution(ipo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	//更新账户信息
		public void updateAccount(AccountVO avo) {
			try {
				DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
				InformationFactory infof=database.getInformationFactory();
				InformationUpdateDataService infod=infof.getInformationUpdateData();
				AccountPO apo=new AccountPO(avo.getId(),avo.getPassword(),avo.getBalance());
				infod.updateAccount(apo);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		}
		
		//更新人员薪水
		public void updateSalary(SalaryVO svo){
			try {
				DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
				InformationFactory infof=database.getInformationFactory();
				InformationUpdateDataService infod=infof.getInformationUpdateData();
				SalaryPO spo=new SalaryPO(svo.getId(),svo.getInstitution(),svo.getName(),svo.getSalary());
				infod.updateSalary(spo);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		}
}
