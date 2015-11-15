package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

import junit.framework.TestCase;

public class InquireCostBenefitListTest extends TestCase {
	public void test(){
		CostBenefitList cbl=new CostBenefitList("2015/10/25","2015/10/26");
		assertEquals(49.9,cbl.calculateIncome());
		assertEquals(29.9,cbl.calculateExpense());
		assertEquals(20.0,cbl.calculateProfit());
	}
}
