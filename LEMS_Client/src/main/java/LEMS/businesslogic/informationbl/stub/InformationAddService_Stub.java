package LEMS.businesslogic.informationbl.stub;

import java.awt.Image;
import java.util.ArrayList;

import LEMS.businesslogicservice.informationblservice.InformationAddService;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.vo.informationvo.AccountVO;
import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.Gender;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.StuffVO;
import LEMS.vo.informationvo.VehicleVO;

/**
 * @author 苏琰梓
 * InformationAddService的桩程序
 * 2015年10月26日
 */
public class InformationAddService_Stub implements InformationAddService{
	public void addDriverVO(DriverVO drivervo){
		System.out.println("司机姓名："+drivervo.getName());
		System.out.println("司机编号："+drivervo.getId());
		System.out.println("司机身份证号："+drivervo.getIDcardNumber());
		System.out.println("司机性别："+drivervo.getGender());
		System.out.println("司机出生年月："+drivervo.getDateOfBirth());
		System.out.println("司机电话号码："+drivervo.getPhoneNumber());
	}
	
	public void addVehicleVO(VehicleVO vehiclevo){
		System.out.println("车辆编号："+vehiclevo.getId());
		System.out.println("车辆服役时间："+vehiclevo.getWorkTime());
	}
	
	public void addInstitutionVO(InstitutionVO institutionvo){
		
		System.out.println("添加机构信息成功");
	}
	
	public void addStuffVO(StuffVO stuffvo){
		
		System.out.println("添加人员信息成功");
	}
	
	public void addAccoutVO(AccountVO accoutvo) {
		
		System.out.println("添加账户信息成功");
	}
}
