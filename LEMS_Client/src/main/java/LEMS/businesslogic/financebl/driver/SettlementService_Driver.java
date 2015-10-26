package LEMS.businesslogic.financebl.driver;

import LEMS.businesslogic.financebl.stub.SettlementService_Stub;
import LEMS.vo.financevo.IncomeBillVO;

/**
 * @author 宋益明
 * 
 * 结算管理任务驱动程序
 */
public class SettlementService_Driver {
	
	public void drive(SettlementService_Stub settlement) {
		IncomeBillVO income = settlement.getIncomeInfo(1041341);
		System.out.println("获取收款信息........\n");
		System.out.println("日期：\t" +income.getDate() + "金额：\t" + income.getAmount());
		System.out.println("收款单位：\t" + income.getInstitution() + "\n");
		settlement.addIncomeInfo(income);
		settlement.incomeBill();
	}
}
