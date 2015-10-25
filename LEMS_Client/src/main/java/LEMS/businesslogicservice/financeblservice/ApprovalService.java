package LEMS.businesslogicservice.financeblservice;

import LEMS.vo.financevo.DocumentVO;

/**
 * @author 宋益明
 * 
 * 审批单据任务接口
 */
public interface ApprovalService {
	/**
	 * 审批单据
	 * 
	 * @param document 待审核单据
	 * @return 若通过返回true，否则返回false
	 */
	public boolean approval(DocumentVO document);
}
