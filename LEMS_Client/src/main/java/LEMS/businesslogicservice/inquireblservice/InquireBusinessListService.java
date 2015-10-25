package LEMS.businesslogicservice.inquireblservice;

import LEMS.vo.inquirevo.BusinessListVO;

public interface InquireBusinessListService {
	public BusinessListVO getBusinessList(String startTime,String endTime);

}
