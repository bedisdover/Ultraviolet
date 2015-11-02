package LEMS.businesslogic.informationbl.driver;

import java.awt.Image;

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
 * InformationAddService的驱动程序
 * 2015年10月26日
 */
public class InformationAddService_Driver {
	public void drive(InformationAddService informationAddService){
		Image i = null;
		DriverVO vod = new DriverVO("025011007","狗头","1994年3月23日","622421199403246430"
				,"17752748532","2016年7月4日",Gender.MAN);
		VehicleVO vov = new VehicleVO("025011007","苏A3022","1994年3月23日",i);
		InstitutionVO voi = new InstitutionVO("NJ077385","南京市");
		InstitutionPO poTemp = new InstitutionPO("NJ077385","南京市");
		StuffVO vos = new StuffVO("NJ077385123",poTemp);
		AccountVO voa = new AccountVO("账户1",12300.45,"12345");
		
		informationAddService.addDriverVO(vod);
		informationAddService.addVehicleVO(vov);
		informationAddService.addInstitutionVO(voi);
		informationAddService.addStuffVO(vos);
		informationAddService.addAccoutVO(voa);
	}
}
