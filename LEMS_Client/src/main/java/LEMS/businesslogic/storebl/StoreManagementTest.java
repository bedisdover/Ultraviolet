package LEMS.businesslogic.storebl;

import java.util.ArrayList;

import junit.framework.TestCase;

public class StoreManagementTest extends TestCase {
	public void test(){
		StoreManagement smt=new StoreManagement("20151025","20151026");
		ArrayList al=smt.inquire("20151025","20151026");
		
		
		
		
		assertEquals("1011001101",smt.inquire("20151025","20151026").get(1).getId());
		assertEquals("1111000011",smt.check().get(1).getId());
		smt.warning();
	}
}
