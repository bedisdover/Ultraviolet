package LEMS.businesslogic.informationbl.driver;

import LEMS.businesslogicservice.informationblservice.InformationDeleteService;

/**
 * @author 苏琰梓
 * InformationDeleteService驱动程序
 * 2015年10月26日
 */
public class InformationDeleteService_Driver {
	public void drive(InformationDeleteService informationDeleteService){
		long idd = 025011007;
		long idh = 025011007;
		String idi = "NJ077385";
		String ids = "NJ077385123";
		String name = "账户1";
		informationDeleteService.deleteDriverVO(idd);
		informationDeleteService.deleteVehicleVO(idh);
		informationDeleteService.deleteInstitutionVO(idi);
		informationDeleteService.deleteStuffVO(ids);
		informationDeleteService.deleteAccoutVO(name);
		
	}
}
