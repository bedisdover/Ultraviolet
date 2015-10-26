package LEMS.businesslogic.financebl.stub;

import LEMS.businesslogicservice.financeblservice.CostService;
import LEMS.vo.financevo.CostProfitVO;
import LEMS.vo.financevo.PayBillVO;

/**
 * @author 宋益明
 * 
 * 成本管理任务桩程序
 */
public class CostService_Stub implements CostService {

	public void payBill(PayBillVO pay) {
		System.out.println("付款单ID：" + pay.getId() + " \t金额：" + pay.getAmount());
		System.out.println("付款日期：" + pay.getDate() + "\t事项：" + pay.getItem());
		System.out.println("备注：" + pay.getRemark());
		System.out.println("生成付款单成功！\n");
	}

	public CostProfitVO costProfit(String date) {
		// TODO 总收入、支出的来源
		System.out.println("截止" + date);
		System.out.println("\t总收入：\t" + 14323);
		System.out.println("\t总支出：\t" + 7002);
		System.out.println("\t总利润：\t" + 7321 + "\n");
		return null;
	}

	public void costBenifitBill() {
		System.out.println("生成成本收益表成功！\n");
	}

}
