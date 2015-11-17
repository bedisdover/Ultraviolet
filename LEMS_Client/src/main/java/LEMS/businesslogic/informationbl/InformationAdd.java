package LEMS.businesslogic.informationbl;

import java.rmi.Naming;

import LEMS.dataservice.DatabaseFactory;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.inquirepo.DiaryPO;
import LEMS.vo.informationvo.AccountVO;
import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.StaffVO;
import LEMS.vo.informationvo.VehicleVO;

public class InformationAdd {
	/**
	 * 增加司机信息
	 */
	public void addDriverVO(DriverVO drivervo){

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
	public void addStaff(StaffVO staffvo){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			InformationInsertDataService infoinsert=database.getInformationInsertData();
			StaffPO sp=new StaffPO(staffvo.getID(),staffvo.getPassword(),staffvo.getPosition(),staffvo.getInstitution());
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
