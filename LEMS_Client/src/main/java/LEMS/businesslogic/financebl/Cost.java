package LEMS.businesslogic.financebl;

import LEMS.businesslogicservice.financeblservice.CostService;
import LEMS.po.financepo.PayBillPO;
import LEMS.vo.financevo.CostProfitVO;
import LEMS.vo.financevo.PayBillVO;

/**
 * @author 宋益明
 * 
 * 成本管理任务
 */
public class Cost implements CostService {

	public PayBillPO payBill(PayBillVO pay) {
		//根据付款单值对象直接生成持久化对象
		return new PayBillPO(pay);
	}

	public CostProfitVO costProfit(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void costBenifitBill(CostProfitVO costProfitVO) {
		// TODO Auto-generated method stub
		
	}

}
