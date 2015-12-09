package LEMS.businesslogic.inquirebl.inquirebusinesslist;

import LEMS.businesslogicservice.inquireblservice.InquireBusinessListService;
import LEMS.vo.inquirevo.BusinessListVO;

/**
 * @author 章承尧
 * inquireBusinessService接口的实现
 */
public class InquireBusinessList implements InquireBusinessListService {

	public BusinessListVO getBusinessList(String startTime, String endTime) {
		BusinessList bl=new BusinessList(startTime,endTime);
		BusinessListVO bvo=new BusinessListVO(startTime,endTime,bl.getPayBill(),bl.getIncomeBill());
		return bvo;
	}

}
