package LEMS.vo.inquirevo;

/**
 * @author 章承尧
 * CostBenefitList的值对象
 */
public class CostBenefitListVO {
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
	long totalIncome;
	/**
	 * 总支出
	 */
	long totalExpense;
	/**
	 * 总利润
	 */
	long totalBenefit;
	
	public CostBenefitListVO(String st,String et,long ti,long te,long tb){
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
