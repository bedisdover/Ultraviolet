package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.factory.InquireFactory;
import LEMS.dataservice.factory.UserFactory;
import LEMS.dataservice.financedataservice.IncomeBillDataService;
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.financepo.IncomeBillPO;
import LEMS.po.financepo.PayBillPO;

/**
 * @author 章承尧 获得指定时间段的成本收益表
 */
public class CostBenefitList {

	/**
	 * 开始日期
	 */
	String startTime;
	/**
	 * 结束日期
	 */
	String endTime;
	/**
	 * 总收入
	 */
	double totalIncome = 0;
	/**
	 * 总支出
	 */
	double totalExpense = 0;
	/**
	 * 总利润
	 */
	double totalProfit = 0;
	/**
	 * 期间内的所有收款单
	 */
	ArrayList<IncomeBillPO> incomeBills;
	/**
	 * 期间内的所有付款单
	 */
	ArrayList<PayBillPO> payBills;

	public CostBenefitList(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * @return double 计算若干收款单的总收入
	 */
	public double calculateIncome() {
		incomeBills=getIncomeBill(startTime,endTime);
		
		return (double) Math.round(totalIncome * 100) / 100;
	}

	/**
	 * @return double 计算若干付款单的总支出
	 */
	public double calculateExpense() {
		MockPayBill b1 = new MockPayBill(startTime, 10.1);
		MockPayBill b2 = new MockPayBill(startTime, 19.8);
		totalExpense = b1.getExpense() + b2.getExpense();
		return (double) Math.round(totalExpense * 100) / 100;
	}

	/**
	 * @return double 计算这段时间内的总收入
	 */
	public double calculateProfit() {
		return (double) Math.round((totalIncome - totalExpense) * 100) / 100;
	}

	/**
	 * @param startTime
	 * @param endTime
	 * @return ArrayList<IncomeBillPO>
	 * 获得这段时间内所有收款单
	 */
	private ArrayList<IncomeBillPO> getIncomeBill(String startTime,String endTime) {
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			FinanceFactory ff=database.getFinanceFactory();
			IncomeBillDataService in=ff.getIncomeBillData();
			incomeBills=in.getIncomeBill(startTime, endTime);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return incomeBills;
	}
	private ArrayList<PayBillPO> getPayBill(String startTime,String endTime) {
		return payBills;
	}
	private boolean isValid(String time){
		String[] t1=startTime.split("-");
		String[] t2=endTime.split("-");
		String[] t=time.split("-");
		if((Integer.parseInt(t[0])>=Integer.parseInt(t1[0]))&&(Integer.parseInt(t[0])<=Integer.parseInt(t2[0]))){
			
		}
		else{
			return false;
		}
		return false;
	}
}
