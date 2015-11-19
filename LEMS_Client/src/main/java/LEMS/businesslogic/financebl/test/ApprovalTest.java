package LEMS.businesslogic.financebl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.financebl.mock.MockApproval;
import LEMS.po.financepo.DocumentPO;
import LEMS.po.financepo.DocumentState;

public class ApprovalTest {
	
	MockApproval approval = new MockApproval();
	
	@Test
	public void testAccepted(DocumentPO document) {
		approval.accepted(document);
		assertEquals(DocumentState.accepted, document.getState());
	}
	
	@Test
	public void testunaccepted(DocumentPO document) {
		approval.unaccepted(document);
		assertEquals(DocumentState.unaccepted, document.getState());
	}
}
