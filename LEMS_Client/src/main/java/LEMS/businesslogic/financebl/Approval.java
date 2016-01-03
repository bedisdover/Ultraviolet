package LEMS.businesslogic.financebl;

import LEMS.businesslogic.utility.Approvalable;
import LEMS.businesslogicservice.financeblservice.ApprovalService;
import LEMS.po.financepo.DocumentState;
import LEMS.vo.financevo.DocumentVO;

/**
 * @author 宋益明
 * 
 * 审批单据任务
 */
public class Approval implements ApprovalService {

	private Approvalable approvalable;
	
	public Approval(int index) {
		approvalable = Factory.factory.create(index);
	}
	
	public void accepted(String id) {
		approvalable.approval(id, DocumentState.accepted);
	}

	public void unaccepted(String id) {
		approvalable.approval(id, DocumentState.unaccepted);
	}

}
