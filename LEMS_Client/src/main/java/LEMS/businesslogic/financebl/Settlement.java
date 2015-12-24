package LEMS.businesslogic.financebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.financeblservice.SettlementService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.financedataservice.IncomeBillDataService;
import LEMS.po.orderpo.IncomePO;
import LEMS.vo.ordervo.IncomeVO;

/**
 * @author 宋益明
 *
 *         结算管理任务
 */
public class Settlement implements SettlementService {

	@Override
	public ArrayList<IncomePO> getIncomeByDateAndIns(String date, String institution) {
		ArrayList<IncomePO> incomeBills = null;

		try {
			incomeBills = this.getDataService().getIncomeByDateAndIns(date, institution);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return incomeBills;
	}

//	@Override
//	public ArrayList<IncomeBillPO> getIncomeByDate(String date) {
//		ArrayList<IncomeBillPO> incomeBills = null;
//
//		try {
//			incomeBills = this.getDataService().getIncomeByDate(date);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		return incomeBills;
//	}

//	@Override
//	public ArrayList<IncomeBillPO> getIncomeByIns(String institution) {
//		ArrayList<IncomeBillPO> incomeBills = null;
//
//		try {
//			incomeBills = this.getDataService().getIncomeByIns(institution);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		return incomeBills;
//	}

	@Override
	public void addIncomeInfo(IncomeVO income) {
		IncomePO incomePO = new IncomePO();
		incomePO.setDate(income.getDate());
		incomePO.setAmount(income.getAmount());
		//TODO 
		
		
//		try {
//			this.getDataService().addIncomeBill(incomePO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}

	// TODO 似乎没有用的方法
	@Override
	public void incomeBill() {

	}

	private IncomeBillDataService getDataService() {
		IncomeBillDataService dataService = null;
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			FinanceFactory financeFactory = databaseFactory.getFinanceFactory();
			dataService = financeFactory.getIncomeBillData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		return dataService;
	}
}
