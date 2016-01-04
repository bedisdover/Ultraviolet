package LEMS.businesslogic.financebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.financeblservice.CostService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.financedataservice.FinanceDeleteDataService;
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
		try {
			DatabaseFactory database = (DatabaseFactory) Naming
					.lookup(RMIConnect.RMI);
			FinanceFactory fif = database.getFinanceFactory();
			
			FinanceInsertDataService financeInsert = fif.getInsertData();
			PayBillPO p = new PayBillPO(pay.getDate(), pay.getId(),
					pay.getInstitution(), pay.getAmount(), pay.getPayer(),
					pay.getAccount(), pay.getItem(), pay.getRemark());
			financeInsert.insertCost(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCost(String id) {
		try {
			DatabaseFactory database = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			FinanceFactory fif = database.getFinanceFactory();
			System.out.println(1);
			FinanceDeleteDataService financeDelete = fif.getDeleteData();
			System.out.println(2);
			financeDelete.deleteCost(id);
			System.out.println(3);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
}
