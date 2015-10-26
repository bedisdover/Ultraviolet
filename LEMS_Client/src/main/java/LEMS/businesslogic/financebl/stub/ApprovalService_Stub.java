package LEMS.businesslogic.financebl.stub;

import LEMS.businesslogicservice.financeblservice.ApprovalService;
import LEMS.vo.financevo.DocumentState;
import LEMS.vo.financevo.DocumentVO;

/**
 * @author 宋益明
 * 
 * 审批单据任务桩程序
 */
public class ApprovalService_Stub implements ApprovalService {

	public void accepted(DocumentVO document) {
		// TODO Auto-generated method stub
		document.setState(DocumentState.accepted);
		System.out.println("订单状态更改为通过！");
	}

	public void unaccepted(DocumentVO document) {
		// TODO Auto-generated method stub
		document.setState(DocumentState.unaccepted);
		System.out.println("订单状态更改为不通过！");
	}

}
