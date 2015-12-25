package LEMS.businesslogicservice.informationblservice;

import java.util.ArrayList;

import LEMS.vo.informationvo.AccountVO;
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
	 * 根据司机编号查找司机信息
	 */
	public DriverVO findTheDriver(String id);
	/**
	 * 查找车辆信息
	 */
	public ArrayList<VehicleVO> findVehicle(String businessid);
	/**
	 * 根据车辆编号查找车辆信息
	 */
	public VehicleVO findTheVehicle(String id);
	/**
	 * 查找机构信息
	 */
	public ArrayList<InstitutionVO> findInstitution();
	/**
	 * 根据指定编号查找机构信息
	 */
	public InstitutionVO findTheInstitution(String s);
	/**
	 * 查找所有人员信息
	 */
	public ArrayList<UserVO> findStaff();
	/**
	 * 查找指定id的人员信息
	 */
	public UserVO findStaff(String id);
	/**
	 * 查找所有账户信息
	 */
	public ArrayList<AccountVO> findAccount();
	/**
	 * 根据卡号查找账户信息
	 */
	public AccountVO findTheAccount(String id);
}
