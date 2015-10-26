package LEMS.businesslogic.financebl.driver;

import LEMS.businesslogic.financebl.stub.ApprovalService_Stub;
import LEMS.businesslogic.financebl.stub.CostService_Stub;
import LEMS.businesslogic.financebl.stub.PriceService_Stub;

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
	}

}
