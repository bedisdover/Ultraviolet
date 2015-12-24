package LEMS.businesslogicservice.financeblservice;

import java.util.ArrayList;

import LEMS.po.orderpo.IncomePO;
import LEMS.vo.ordervo.IncomeVO;

/**
 * @author 宋益明
 * 
 * 结算管理任务接口
 */
public interface SettlementService {
//	/**
//	 * 根据日期获取收款信息
//	 * 
//	 * @param date 收款日期
//	 * @return 收款信息
//	 */
//	public ArrayList<IncomeBillPO> getIncomeByDate(String date);
	
//	/**
//	 * 根据营业厅获取收款信息
//	 * 
//	 * @param institution 营业厅编号
//	 * @return 收款信息
//	 */
//	public ArrayList<IncomeBillPO> getIncomeByIns(String institution);
	
	/**
	 * 按天、按营业厅查看收款单记录
	 * 
	 * @param date 日期
	 * @param institution 营业厅编号
	 * @return 收款单记录
	 */
	public ArrayList<IncomePO> getIncomeByDateAndIns(String date, String institution);
	
	/**
	 * 添加收款信息到收款单
	 * 
	 * @param income
	 */
	public void addIncomeInfo(IncomeVO income);
	
	/**
	 * 生成收款单
	 */
	public void incomeBill();
}
