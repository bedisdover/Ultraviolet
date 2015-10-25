package LEMS.businesslogicservice.inquireblservice;

import LEMS.vo.inquirevo.BusinessListVO;

/**
 * @author 章承尧
 * 查询经营情况表接口
 */
public interface InquireBusinessListService {
	public BusinessListVO getBusinessList(String startTime,String endTime);
}
