package LEMS.businesslogic.financebl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LEMS.businesslogic.financebl.mock.MockCost;
import LEMS.po.financepo.CostProfitPO;
import LEMS.po.financepo.PayBillPO;
import LEMS.vo.financevo.CostProfitVO;
import LEMS.vo.financevo.PayBillVO;

public class CostTest {
	MockCost cost = new MockCost();
	
	@Test
	public void testPayBill(PayBillVO pay) {
		PayBillPO payBill = cost.payBill(pay);
		assertEquals(new PayBillPO(pay), payBill);
	}
	
	@Test
	public void testCostProfit(String date) {
		CostProfitVO costProfit = cost.costProfit(date);
		assertEquals(new CostProfitVO(date), costProfit);
	}
	
	@Test
	public void testCostBenifitBill(CostProfitVO costProfitVO) {
		CostProfitPO costProfit = cost.costBenifitBill(costProfitVO);
		assertEquals(new CostProfitPO(costProfitVO), costProfit);
	}
}
