package LEMS.vo.financevo;

/**
 * @author 宋益明
 * 
 * 成本收益表值对象
 */
public class CostProfitVO {
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
	
	public CostProfitVO(String date) {
		// TODO Auto-generated constructor stub
		//TODO 成本管理时新建成本收益信息
	}
	
	public CostProfitVO(String date, double income, double cost, double profit) {
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

	public void setDate(String date) {
		this.date = date;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
}
