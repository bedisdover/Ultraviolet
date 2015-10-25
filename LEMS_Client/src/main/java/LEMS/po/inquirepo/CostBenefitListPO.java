package LEMS.po.inquirepo;

import java.io.Serializable;

/**
 * @author 章承尧
 * 成本收益表持久化对象
 */
@SuppressWarnings("serial")
public class CostBenefitListPO implements Serializable {
	/**
	 * 开始日期
	 */
	String startTime;
	/**
	 * 结束日期
	 */
	String endTime;
	/**
	 * 期间内总收入
	 */
	long totalIncome;
	/**
	 * 期间内总支出
	 */
	long totalExpense;
	/**
	 * 期间内总收益
	 */
	long totalBenefit;
	
	public CostBenefitListPO(String st,String et,long ti,long te,long tb){
		startTime=st;
		endTime=et;
		totalIncome=ti;
		totalExpense=te;
		totalBenefit=tb;
	}
	public String getStartTime(){
		return startTime;
	}
	public String getEndTime(){
		return endTime;
	}
	public long getTotalIncome(){
		return totalIncome;
	}
	public long getTotalExpense(){
		return totalExpense;
	}
	public long getTotalBenefit(){
		return totalBenefit;
	}
}
