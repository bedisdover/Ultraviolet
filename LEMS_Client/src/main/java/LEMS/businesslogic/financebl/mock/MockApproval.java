package LEMS.businesslogic.financebl.mock;

import LEMS.po.financepo.DocumentPO;
import LEMS.vo.financevo.DocumentState;

public class MockApproval {
	
	public void accepted(DocumentPO document) {
		document.setState(DocumentState.accepted);
	}
	
	public void unaccepted(DocumentPO document) {
		document.setState(DocumentState.unaccepted);
	}
}
