package LEMS.po.financepo;


/**
 * @author 宋益明
 * 
 * 成本收益表持久化对象
 */
public class CostProfitPO {
	/**
	 * 截止日期
	 */
	private String date;
	/**
	 * 总收入
	 */
	private double income;
	/**
	 * 总支出
	 */
	private double cost;
	/**
	 * 总利润
	 */
	private double profit;
	
	public CostProfitPO(String date, double income, double cost, double profit) {
		this.date = date;
		this.income = income;
		this.cost = cost;
		this.profit = profit;
	}

	public String getDate() {
		return date;
	}

	public double getIncome() {
		return income;
	}

	public double getCost() {
		return cost;
	}

	public double getProfit() {
		return profit;
	}
}
