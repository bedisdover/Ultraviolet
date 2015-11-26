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
	double totalIncome;
	/**
	 * 总支出
	 */
	double totalExpense;
	/**
	 * 总利润
	 */
	double totalBenefit;
	
	public CostBenefitListVO(String st,String et,double ti,double te,double tb){
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
	public double getTotalIncome(){
		return totalIncome;
	}
	public double getTotalExpense(){
		return totalExpense;
	}
	public double getTotalBenefit(){
		return totalBenefit;
	}
}
