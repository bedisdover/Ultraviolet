package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.financedataservice.IncomeBillDataService;
import LEMS.dataservice.financedataservice.PayBillDataService;
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
		incomeBills = getIncomeBill(startTime, endTime);
		for(IncomeBillPO ibpo:incomeBills){
			totalIncome+=ibpo.getAmount();
		}
		return (double) Math.round(totalIncome * 100) / 100;
	}

	/**
	 * @return double 计算若干付款单的总支出
	 */
	public double calculateExpense() {
		payBills=getPayBill(startTime,endTime);
		for(PayBillPO pbpo:payBills){
			totalExpense+=pbpo.getAmount();
		}
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
	 * @return ArrayList<IncomeBillPO> 获得这段时间内所有收款单
	 */
	public ArrayList<IncomeBillPO> getIncomeBill(String startTime,
			String endTime) {
		try {
			DatabaseFactory database = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			FinanceFactory ff = database.getFinanceFactory();
			IncomeBillDataService in = ff.getIncomeBillData();
			incomeBills = in.getIncomeBill();
			for (int i = 0; i < incomeBills.size(); i++) {
				if (!isValid(incomeBills.get(i).getDate())) {
					incomeBills.remove(i);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		return incomeBills;
	}

	public ArrayList<PayBillPO> getPayBill(String startTime, String endTime) {
		try {
			DatabaseFactory database = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			FinanceFactory ff = database.getFinanceFactory();
			PayBillDataService in = ff.getPayBillData();
			payBills = in.getPayBill();
			for (int i = 0; i < payBills.size(); i++) {
				if (!isValid(payBills.get(i).getDate())) {
					incomeBills.remove(i);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return payBills;
	}

	private boolean isValid(String time) {
		String[] t1 = startTime.split("-");
		String[] t2 = endTime.split("-");
		String[] t = time.split("-");
		int month1=Integer.parseInt(t1[1].substring(0, 1))*10+Integer.parseInt(t1[1].substring(1));
		int month2=Integer.parseInt(t2[1].substring(0, 1))*10+Integer.parseInt(t2[1].substring(1));
		int month=Integer.parseInt(t[1].substring(0, 1))*10+Integer.parseInt(t[1].substring(1));
		int day1=Integer.parseInt(t1[2].substring(0, 1))*10+Integer.parseInt(t1[2].substring(1));
		int day2=Integer.parseInt(t2[2].substring(0, 1))*10+Integer.parseInt(t2[2].substring(1));
		int day=Integer.parseInt(t[2].substring(0, 1))*10+Integer.parseInt(t[2].substring(1));
		if ((Integer.parseInt(t[0]) > Integer.parseInt(t1[0]))&& (Integer.parseInt(t[0]) < Integer.parseInt(t2[0]))) {
			return true;
		} 
		else if((Integer.parseInt(t[0]) == Integer.parseInt(t1[0]))&& (Integer.parseInt(t[0]) < Integer.parseInt(t2[0]))){
			if(month>month1){
				return true;
			}
			else if(month==month1&&day>=day1){
				return true;
			}
			else{
				return false;
			}			
		}
		else if((Integer.parseInt(t[0]) > Integer.parseInt(t1[0]))&& (Integer.parseInt(t[0]) == Integer.parseInt(t2[0]))){
			if(month<month2){
				return true;
			}
			else if(month==month2&&day<=day2){
				return true;
			}
			else{
				return false;
			}
		}
		else if((Integer.parseInt(t[0]) == Integer.parseInt(t1[0]))&& (Integer.parseInt(t[0]) == Integer.parseInt(t2[0]))){
			if(month>month1&&month<month2){
				return true;
			}
			else if(month==month1&&month<month2){
				if(day>=day1){
					return true;
				}
				else{
					return false;
				}
			}
			else if(month>month1&&month==month2){
				if(day<=day2){
					return true;
				}
				else{
					return false;
				}
			}
			else if(month==month1&&month==month2){
				if(day>=day1&&day<=day2){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}		
	}

}
