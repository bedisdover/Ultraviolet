package LEMS.businesslogicservice.informationblservice;

import java.rmi.Remote;


/**
 * @author 苏琰梓
 * 删除InformationVO接口
 * 2015年10月25日
 */
public interface InformationDeleteService extends Remote{
	/**
	 * 删除司机信息
	 */
	public void deleteDriverVO(long id);
	/**
	 * 删除车辆信息
	 */
	public void deleteVehicleVO(long id);
	/**
	 * 删除机构信息
	 */
	public void deleteInstitutionVO(String id);
	/**
	 * 删除人员信息
	 */
	public void deleteStaff(String id);
	/**
	 * 删除账户信息
	 */
	public void deleteAccoutVO(String name);
	
}
