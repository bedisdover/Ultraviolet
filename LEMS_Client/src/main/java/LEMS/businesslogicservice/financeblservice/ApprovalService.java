package LEMS.businesslogicservice.financeblservice;

import LEMS.vo.financevo.DocumentVO;

/**
 * @author 宋益明
 * 
 * 审批单据任务接口
 */
public interface ApprovalService {
	/**
	 * 审批单据通过
	 * 
	 * @param document 待审核单据
	 */
	public void accepted(DocumentVO document);
	/**
	 * 审批单据不通过
	 * 
	 * @param document 待审核单据
	 */
	public void unaccepted(DocumentVO document);
}
