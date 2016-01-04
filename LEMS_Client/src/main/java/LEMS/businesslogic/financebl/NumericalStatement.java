package LEMS.businesslogic.financebl;

import java.util.ArrayList;

import LEMS.businesslogic.inquirebl.inquirebusinesslist.BusinessList;
import LEMS.businesslogic.inquirebl.inquirecostbenefitlist.CostBenefitList;
import LEMS.businesslogicservice.financeblservice.NumericalStatementService;
import LEMS.presentation.method.ExportExcel;
import LEMS.vo.financevo.CostProfitVO;
import LEMS.vo.financevo.IncomeBillVO;
import LEMS.vo.financevo.PayBillVO;

/**
 * @author 宋益明
 * 
 * 统计报表任务
 * 
 */
//TODO 生成截止当前日期的成本收益表
//TODO 待检验
public class NumericalStatement implements NumericalStatementService {

	private ArrayList<Object> item;
	
	//TODO 文件路径
	private static final String COST_PROFIT_NAME = "desktop:/成本收益表";
	private static final String COST_PROFIT_HEAD = "成本收益表";
	
	private static final String BUSINESS_NAME = "desktop:/经营情况表";
	private static final String BUSINESS_HEAD = "经营情况表";
	
	public NumericalStatement() {
		item = new ArrayList<Object>();
	}
	
	@Override
	public void costProfit(String startTime, String endTime) {
		CostBenefitList costBenefitList = new CostBenefitList(startTime, endTime);
		CostProfitVO costProfitVO = new CostProfitVO(endTime);
		costProfitVO.setCost(costBenefitList.calculateExpense());
		costProfitVO.setIncome(costBenefitList.calculateIncome());
		costProfitVO.setProfit(costBenefitList.calculateProfit());
		item.clear();
		item.add(costProfitVO);
		String[] title = {"日期", "总收入", "总支出", "总利润"};
		ExportExcel.exportExcel(COST_PROFIT_NAME + endTime + "xls", COST_PROFIT_HEAD, title, item);
	}

	@Override
	public void exportBusiness(String startTime, String endTime) {
		this.exportIncomeBill(startTime, endTime);
		this.exportPayBill(startTime, endTime);
	}
	
	private void exportIncomeBill(String startTime, String endTime) {
		BusinessList business = new BusinessList(startTime, endTime);
		ArrayList<IncomeBillVO> incomeBills = business.getIncomeBill();
		item.clear();
		item.add(incomeBills);
		String[] title = {"日期", "收款单位", "收款金额", "收款账户"};
		ExportExcel.exportExcel(BUSINESS_NAME + "（收入）" + endTime + "xls", 
								BUSINESS_HEAD, title, item);
	}
	
	private void exportPayBill(String startTime, String endTime) {
		BusinessList business = new BusinessList(startTime, endTime);
		ArrayList<PayBillVO> payBills = business.getPayBill();
		item.clear();
		item.add(payBills);
		String[] title = {"日期" , "付款单位", "付款金额", "付款账号", "付款条目", "备注"};
		ExportExcel.exportExcel(BUSINESS_NAME + "（支出）" + endTime + "xls", 
								BUSINESS_HEAD, title, item);
	}
}
