package LEMS.businesslogic.financebl;

import LEMS.businesslogicservice.financeblservice.ApprovalService;
import LEMS.po.financepo.DocumentState;
import LEMS.vo.financevo.DocumentVO;

/**
 * @author 宋益明
 * 
 * 审批单据任务
 */
public class Approval implements ApprovalService {

	public void accepted(DocumentVO document) {
		document.setState(DocumentState.accepted);
	}

	public void unaccepted(DocumentVO document) {
		document.setState(DocumentState.unaccepted);		
	}

}
