package LEMS.businesslogicservice.financeblservice;

import LEMS.vo.financevo.IncomeBillVO;

/**
 * @author 宋益明
 * 
 * 结算管理任务接口
 */
public interface SettlementService {
	/**
	 * 获取收款信息
	 * 
	 * @param id 收款ID
	 * @return 收款信息
	 */
	public IncomeBillVO getIncomeInfo(long id);
	/**
	 * 添加收款信息到收款单
	 * 
	 * @param income
	 */
	public void addIncomeInfo(IncomeBillVO income);
	/**
	 * 生成收款单
	 */
	public void incomeBill();
}
