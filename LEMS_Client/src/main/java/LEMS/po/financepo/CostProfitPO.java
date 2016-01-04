package LEMS.po.financepo;

import java.io.Serializable;

import LEMS.vo.financevo.CostProfitVO;

/**
 * @author 宋益明
 * 
 * 成本收益表持久化对象
 */
public class CostProfitPO extends DocumentPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	
	public CostProfitPO(CostProfitVO costProfit) {
		// TODO Auto-generated constructor stub
		//TODO 根据成本收益信息生成成本收益表
	}
	
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
