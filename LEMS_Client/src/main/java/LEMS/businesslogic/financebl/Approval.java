package LEMS.businesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.Approvalable;
import LEMS.businesslogicservice.financeblservice.ApprovalService;
import LEMS.po.financepo.DocumentState;

/**
 * @author 宋益明
 * 
 * 审批单据任务
 */
public class Approval implements ApprovalService {

	private Approvalable<?> approvalable;
	
	public Approval(String item) {
		approvalable = Factory.factory.create(item);
	}

	public ArrayList<?> findAll() throws RemoteException {
		return approvalable.findAll();
	}
	
	public void accepted(String id) {
		approvalable.approval(id, DocumentState.accepted);
	}

	public void unaccepted(String id) {
		approvalable.approval(id, DocumentState.unaccepted);
	}
}
