package LEMS.businesslogic.informationbl.stub;

import LEMS.businesslogicservice.informationblservice.InformationUpdateService;


/**
 * @author 苏琰梓
 * InformationUpdateService桩程序
 * 2015年10月26日
 */
public class InformationUpdateService_Stub implements InformationUpdateService{
	public void updateDriverVO(long id){
		System.out.println("修改司机信息成功!");
	}
	
	public void updateVehicleVO(long id){
		System.out.println("修改车辆信息成功!");
	}
	
	public void updateInstitutionVO(String id){
		System.out.println("修改机构信息成功!");
	}
	
	public void updateStuffVO(String id){
		System.out.println("修改人员信息成功!");
	}
}
