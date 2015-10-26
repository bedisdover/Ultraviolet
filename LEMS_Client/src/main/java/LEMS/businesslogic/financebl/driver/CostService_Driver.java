package LEMS.businesslogic.financebl.driver;

import LEMS.businesslogic.financebl.stub.CostService_Stub;
import LEMS.vo.financevo.PayBillVO;
import LEMS.vo.informationvo.AccountVO;

/**
 * @author 宋益明
 * 
 * 成本管理任务驱动程序
 */
public class CostService_Driver {
	
	public void drive(CostService_Stub costService_Stub) {
		AccountVO account = new AccountVO("南京市栖霞区中转中心支付账户", 100000.0);
		PayBillVO payBill = new PayBillVO("2015/10/12", 10312341, "南京栖霞区中转中心",2314.5, account, "支付运费", "无");
		costService_Stub.payBill(payBill);
		costService_Stub.costProfit("2015/10/23");
		costService_Stub.costBenifitBill();
	}
}
