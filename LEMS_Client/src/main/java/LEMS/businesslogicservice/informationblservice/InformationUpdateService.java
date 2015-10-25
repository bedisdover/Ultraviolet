package LEMS.businesslogicservice.informationblservice;


/**
 * @author 苏琰梓
 * 修改InformationVO接口
 * 2015年10月25日
 */
public interface InformationUpdateService {
	/**
	 * 修改司机信息
	 */
	public void updateDriverVO(long id);
	/**
	 * 修改车辆信息
	 */
	public void updateVehicleVO(long id);
	/**
	 * 修改机构信息
	 */
	public void updateInstitutionVO(String id);
	/**
	 * 修改人员信息
	 */
	public void updateStuffVO(String id);
}
