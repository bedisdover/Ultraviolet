package LEMS.businesslogic.financebl.driver;

import LEMS.businesslogic.financebl.stub.ApprovalService_Stub;
import LEMS.vo.financevo.DocumentVO;

/**
 * @author 宋益明
 * 
 * 审批单据任务驱动程序
 */
public class ApprovalService_Driver {
	public void driver(ApprovalService_Stub approval) {
		approval.accepted(new DocumentVO());
		System.out.println();
		approval.unaccepted(new DocumentVO());
		System.out.println();
	}
}
