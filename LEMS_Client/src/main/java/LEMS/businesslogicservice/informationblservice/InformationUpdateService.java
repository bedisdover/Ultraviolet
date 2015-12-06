package LEMS.businesslogicservice.informationblservice;

import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.VehicleVO;
import LEMS.vo.uservo.UserVO;


/**
 * @author 苏琰梓
 * 修改InformationVO接口
 * 2015年10月25日
 */
public interface InformationUpdateService {
	/**
	 * 修改司机信息
	 */
	public void updateDriver(DriverVO dvo);
	/**
	 * 修改车辆信息
	 */
	public void updateVehicle(VehicleVO vvo);
	/**
	 * 修改机构信息
	 */
	public void updateInstitution(InstitutionVO ivo);
	/**
	 * 修改人员信息
	 */
	public void updateStaff(UserVO uvo);
}
