package LEMS.businesslogic.informationbl.stub;

import LEMS.businesslogicservice.informationblservice.InformationFindService;


/**
 * @author 苏琰梓
 * InformationFindService桩程序
 * 2015年10月26日
 */
public class InformationFindService_Stub implements InformationFindService{
	public void findDriverVO(long id){
		System.out.println("查询司机信息成功");
	}
	
	public void findVehicleVO(long id){
		System.out.println("查询车辆信息成功");
	}
	
	public void findInstitutionVO(String id){
		System.out.println("查询机构信息成功");
	}
	
	public void findStuffVO(String id){
		System.out.println("查询人员信息成功");
	}
	
	public void findAccountVO(String name){
		System.out.println("添加账户信息成功");
	}
}
