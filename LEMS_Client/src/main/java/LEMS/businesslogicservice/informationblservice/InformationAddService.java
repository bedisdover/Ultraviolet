package LEMS.businesslogicservice.informationblservice;

import LEMS.vo.informationvo.AccountVO;
import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.StaffVO;
import LEMS.vo.informationvo.VehicleVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓
 * 新增InformationVO接口
 * 2015年10月25日
 */
public interface InformationAddService {
	/**
	 * 增加司机信息
	 */
	public void addDriver(DriverVO drivervo);
	/**
	 * 增加车辆信息
	 */
	public void addVehicle(VehicleVO vehiclevo);
	/**
	 * 增加机构信息
	 */
	public void addInstitution(InstitutionVO institutionvo);
	/**
	 * 增加人员信息
	 */
	public void addStaff(UserVO staffvo);
	/**
	 * 增加账户信息
	 */
	public void addAccout(AccountVO accoutvo);
	
}
