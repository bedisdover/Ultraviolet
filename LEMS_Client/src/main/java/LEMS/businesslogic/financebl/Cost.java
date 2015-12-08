package LEMS.businesslogic.financebl;

import java.rmi.Naming;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.financeblservice.CostService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.financedataservice.FinanceInsertDataService;
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
		return null;
	}

	public CostProfitVO costProfit(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void costBenifitBill(CostProfitVO costProfitVO) {
		// TODO Auto-generated method stub
		
	}

	public void addCost(PayBillVO pay) {
		try{
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			FinanceFactory fif = database.getFinanceFactory();
			FinanceInsertDataService financeInsert = fif.getInsertData();
//			PayBillPO p = new PayBillPO(pay.getDate(),pay.getId(),pay.getInstitution(),pay.g)
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteCost(String id) {
		
	}

}
