package LEMS.businesslogic.financebl.driver;

import LEMS.businesslogic.financebl.stub.ApprovalService_Stub;
import LEMS.businesslogic.financebl.stub.CostService_Stub;
import LEMS.businesslogic.financebl.stub.NumericalStatementService_Stub;
import LEMS.businesslogic.financebl.stub.PriceService_Stub;
import LEMS.businesslogic.financebl.stub.SettlementService_Stub;

/**
 * @author 宋益明
 *
 * 
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//成本管理任务
		System.out.println("成本管理任务:");
		CostService_Driver cost = new CostService_Driver();
		cost.drive(new CostService_Stub());
		
		//制定价格任务
		System.out.println("制定价格任务:");
		PriceService_Driver priceService_Driver = new PriceService_Driver();
		priceService_Driver.drive(new PriceService_Stub());
		
		//审批单据任务
		System.out.println("审批单据任务:");
		ApprovalService_Driver approval = new ApprovalService_Driver();
		approval.driver(new ApprovalService_Stub());
		
		//结算管理任务
		System.out.println("结算管理任务:");
		SettlementService_Driver settlement = new SettlementService_Driver();
		settlement.drive(new SettlementService_Stub());
		
		//统计报表任务
		System.out.println("统计报表任务:");
		NumericalStatementService_Driver numericalStatementService_Driver = new NumericalStatementService_Driver();
		numericalStatementService_Driver.drive(new NumericalStatementService_Stub());
	}

}
