package LEMS.businesslogicservice.informationblservice;

import java.util.ArrayList;

import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.VehicleVO;
import LEMS.vo.uservo.UserVO;



/**
 * @author 苏琰梓
 * 查找InformationVO接口
 * 2015年10月25日
 */
public interface InformationFindService {
	/**
	 * 查找司机信息
	 */
	public ArrayList<DriverVO> findDriver(String businessid);
	/**
	 * 查找车辆信息
	 */
	public ArrayList<VehicleVO> findVehicle(String businessid);
	/**
	 * 查找机构信息
	 */
	public ArrayList<InstitutionVO> findInstitution();
	/**
	 * 查找所有人员信息
	 */
	public ArrayList<UserVO> findStaff();
}
