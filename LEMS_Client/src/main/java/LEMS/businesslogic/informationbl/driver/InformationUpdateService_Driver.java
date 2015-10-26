package LEMS.businesslogic.informationbl.driver;

import LEMS.businesslogicservice.informationblservice.InformationUpdateService;

/**
 * @author 苏琰梓
 * InformationUpdateService驱动程序
 * 2015年10月26日
 */
public class InformationUpdateService_Driver {
	public void drive(InformationUpdateService informationUpdateService){
		long idd = 025011007;
		long idh = 025011007;
		String idi = "NJ077385";
		String ids = "NJ077385123";

		informationUpdateService.updateDriverVO(idd);
		informationUpdateService.updateVehicleVO(idh);
		informationUpdateService.updateInstitutionVO(idi);
		informationUpdateService.updateStuffVO(ids);
	}
}
