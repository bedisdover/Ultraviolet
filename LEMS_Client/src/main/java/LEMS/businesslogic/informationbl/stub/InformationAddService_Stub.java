package LEMS.businesslogic.informationbl.stub;

import java.awt.Image;
import java.util.ArrayList;

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
public class InformationAddService_Stub {
	public void addDriverVO(DriverVO drivervo){
		DriverVO vo = new DriverVO(025011007,"狗头","1994年3月23日","622421199403246430"
				,"17752748532","2016年7月4日",Gender.MAN);
	}
	
	public void addVehicleVO(VehicleVO vehiclevo){
		Image i = null;
		VehicleVO vo = new VehicleVO(025011007,"苏A3022","1994年3月23日",i);
	}
	
	public void addInstitutionVO(InstitutionVO institutionvo){
		InstitutionVO vo = new InstitutionVO("NJ077385","南京市");
	}
	
	public void addStuffVO(StuffVO stuffvo){
		InstitutionPO po = new InstitutionPO("NJ077385","南京市");
		StuffVO vo = new StuffVO("NJ077385123",po);
	}
	
	public void addAccountVO(AccountVO accountvo){
		AccountVO vo = new AccountVO("账户1",12300.45);
	}
}
