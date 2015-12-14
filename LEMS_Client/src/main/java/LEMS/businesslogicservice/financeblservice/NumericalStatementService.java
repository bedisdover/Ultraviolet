package LEMS.businesslogicservice.financeblservice;

/**
 * @author 宋益明
 * 
 * 统计报表任务接口
 * 包括导出成本收益表与导出经营情况表
 */
public interface NumericalStatementService {
	/**
	 * 导出成本收益表
	 * 
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 */
	public void costProfit(String startTime, String endTime);
	
	/**
	 * 导出经营情况表
	 * 
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 */
	public void exportBusiness(String startTime, String endTime);
}
