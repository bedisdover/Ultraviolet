package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

import junit.framework.TestCase;

/**
 * @author user
 * 测试查询成本收益表
 */
public class InquireCostBenefitListTest extends TestCase {
	
	/**
	 * 测试CostBenefitList类中计算总收入、总支出、总利润的方法
	 */
	public void test(){
		CostBenefitList cbl=new CostBenefitList("2015/10/25","2015/10/26");
		assertEquals(49.9,cbl.calculateIncome());
		assertEquals(29.9,cbl.calculateExpense());
		assertEquals(20.0,cbl.calculateProfit());
	}
}
