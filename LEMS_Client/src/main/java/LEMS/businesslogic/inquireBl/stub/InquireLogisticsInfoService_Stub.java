package LEMS.businesslogic.inquirebl.stub;

import java.util.ArrayList;

import LEMS.businesslogicservice.inquireblservice.InquireLogisticsInfoService;
import LEMS.vo.inquirevo.LogisticsInfoVO;

/**
 * @author 章承尧
 * InquireLogisticsInfoService的桩程序
 */
public class InquireLogisticsInfoService_Stub implements InquireLogisticsInfoService {

	public LogisticsInfoVO getInquireLogisticsInfo() {
		// TODO Auto-generated method stub
		ArrayList<String> trace=new ArrayList<String>(5);
		trace.add("到达寄件人集散地");
		trace.add("到达寄件人中转点");
		trace.add("到达收件人集散地");
		trace.add("派送中");
		LogisticsInfoVO liv=new LogisticsInfoVO("213459382",trace);
		return liv;
	}
	
}
