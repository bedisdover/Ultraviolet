package LEMS.businesslogic.financebl.mock;

import LEMS.po.financepo.CostProfitPO;
import LEMS.po.financepo.IncomeBillPO;
import LEMS.po.financepo.PayBillPO;
import LEMS.vo.financevo.CostProfitVO;
import LEMS.vo.financevo.PayBillVO;

public class MockCost {
	
	public PayBillPO payBill(PayBillVO pay) {
		PayBillPO payBill = new PayBillPO(pay);
		return payBill;
	}
	
	public CostProfitVO costProfit(String date) {
		PayBillPO payBill = new PayBillPO(date);
		IncomeBillPO incomeBill = new IncomeBillPO(date);
		CostProfitVO costProfit = new CostProfitVO(date);
		
		costProfit.setCost(payBill.getAmount());
		costProfit.setIncome(incomeBill.getAmount());
		costProfit.setProfit(incomeBill.getAmount() - payBill.getAmount());
		
		return costProfit;
	}
	
	public CostProfitPO costBenifitBill(CostProfitVO costProfitVO) {
		return new CostProfitPO(costProfitVO);
	}
}
