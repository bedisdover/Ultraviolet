package LEMS.businesslogic.inquirebl.driver;

import java.util.ArrayList;

import LEMS.businesslogicservice.inquireblservice.InquireLogisticsInfoService;
import LEMS.vo.inquirevo.LogisticsInfoVO;

/**
 * @author 章承尧
 * InquireLogisticsInfoService的驱动程序
 */
public class InquireLogisticsInfoService_Driver {
	public void drive(InquireLogisticsInfoService inquireLogisticsInfoService){
		LogisticsInfoVO liv=inquireLogisticsInfoService.getInquireLogisticsInfo();
		System.out.println(liv.getId());
		ArrayList<String> t=liv.getTrace();
		for(int i=0;i<t.size();i++){
			System.out.println(t.get(i));
		}
	}
}
