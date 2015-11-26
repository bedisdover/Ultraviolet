package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

import java.util.ArrayList;

import LEMS.po.financepo.IncomeBillPO;
import LEMS.po.financepo.PayBillPO;

/**
 * @author 章承尧 获得制定时间段的成本收益表
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

	private ArrayList<IncomeBillPO> getIncomeBill(String startTime,String endTime) {
		return incomeBills;
	}
}
