package LEMS.businesslogic.informationbl;

import java.rmi.Naming;

import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.inquirepo.DiaryPO;
import LEMS.po.userpo.UserPO;
import LEMS.vo.informationvo.AccountVO;
import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.StaffVO;
import LEMS.vo.informationvo.VehicleVO;
import LEMS.vo.uservo.UserVO;

public class InformationAdd {
	/**
	 * 增加司机信息
	 */
	public void addDriverVO(DriverVO drivervo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			InformationFactory inf=database.getInformationFactory();
			InformationInsertDataService infoinsert=inf.getInformationInsertData();
//			UserPO sp=new UserPO(uservo.getId(),uservo.getPassword(),uservo.getRole(),uservo.getName(),uservo.getInstitution());
//			infoinsert.insertStaffPO(sp);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 增加车辆信息
	 */
	public void addVehicleVO(VehicleVO vehiclevo){
		
	}
	/**
	 * 增加机构信息
	 */
	public void addInstitutionVO(InstitutionVO institutionvo){
		
	}
	/**
	 * 增加人员信息
	 */
	public void addStaff(UserVO uservo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			InformationFactory inf=database.getInformationFactory();
			InformationInsertDataService infoinsert=inf.getInformationInsertData();
			UserPO sp=new UserPO(uservo.getId(),uservo.getPassword(),uservo.getRole(),uservo.getName(),uservo.getInstitution());
			infoinsert.insertStaffPO(sp);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 增加账户信息
	 */
	public void addAccout(AccountVO accoutvo){
		
	}
}
