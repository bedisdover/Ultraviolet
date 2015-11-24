package LEMS.businesslogic.inquirebl.inquirebusinesslist;

import java.util.ArrayList;

import LEMS.businesslogic.inquirebl.inquirecostbenefitlist.MockPayBill;
import junit.framework.TestCase;

public class InquireBusinessListTest extends TestCase {
	
	public void testInquireBusinessList() {
		BusinessList bl=new BusinessList("2015/10/25","2015/10/26");
		ArrayList<MockPayBill> a1=bl.getPayBill();		
		MockPayBill b1=a1.get(0);
		MockPayBill b2=a1.get(1);
		assertEquals(21.3,b1.getExpense());
		assertEquals(22.1,b2.getExpense());
	}
}
