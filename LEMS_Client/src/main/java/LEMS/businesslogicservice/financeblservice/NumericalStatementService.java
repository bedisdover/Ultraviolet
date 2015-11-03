package LEMS.businesslogicservice.financeblservice;

/**
 * @author 宋益明
 * 
 * 统计报表任务接口
 */
public interface NumericalStatementService {
	/**
	 * 导出统计报表
	 * 
	 * @param id 报表ID
	 */
	public void export(String id);
}
