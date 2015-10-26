package LEMS.businesslogic.informationbl.driver;

import LEMS.businesslogicservice.informationblservice.InformationFindService;

/**
 * @author 苏琰梓
 * InformationFindService驱动程序
 * 2015年10月26日
 */
public class InformationFindService_Driver {
	public void drive(InformationFindService informationFindService){
		long idd = 025011007;
		long idh = 025011007;
		String idi = "NJ077385";
		String ids = "NJ077385123";
		
		informationFindService.findDriverVO(idd);
		informationFindService.findVehicleVO(idh);
		informationFindService.findInstitutionVO(idi);
		informationFindService.findStuffVO(ids);
	}
}
