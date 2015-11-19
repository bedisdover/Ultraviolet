package LEMS.businesslogic.financebl.mock;

import LEMS.po.financepo.DocumentPO;
import LEMS.po.financepo.DocumentState;

public class MockApproval {
	
	public void accepted(DocumentPO document) {
		document.setState(DocumentState.accepted);
	}
	
	public void unaccepted(DocumentPO document) {
		document.setState(DocumentState.unaccepted);
	}
}
