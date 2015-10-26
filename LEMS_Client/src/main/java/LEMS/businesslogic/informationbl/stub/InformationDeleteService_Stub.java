package LEMS.businesslogic.informationbl.stub;

import java.awt.Image;

import LEMS.businesslogicservice.informationblservice.InformationDeleteService;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.vo.informationvo.AccountVO;
import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.informationvo.Gender;
import LEMS.vo.informationvo.InstitutionVO;
import LEMS.vo.informationvo.StuffVO;
import LEMS.vo.informationvo.VehicleVO;

/**
 * @author 苏琰梓
 * InformationDeleteService桩程序
 * 2015年10月26日
 */
public class InformationDeleteService_Stub implements InformationDeleteService{
	public void deleteDriverVO(long id){
		System.out.println("删除司机信息成功!");
	}
	
	public void deleteVehicleVO(long id){
		System.out.println("删除车辆信息成功!");
	}
	
	public void deleteInstitutionVO(String id){
		System.out.println("删除机构信息成功!");
	}
	
	public void deleteStuffVO(String id){
		System.out.println("删除人员信息成功!");
	}
	
	public void deleteAccoutVO(String name){
		System.out.println("删除账户信息成功!");
	}
}
