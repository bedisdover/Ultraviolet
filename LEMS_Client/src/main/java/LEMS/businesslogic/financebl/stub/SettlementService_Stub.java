package LEMS.businesslogic.financebl.stub;

import LEMS.businesslogicservice.financeblservice.SettlementService;
import LEMS.vo.financevo.IncomeBillVO;

/**
 * @author 宋益明
 * 
 * 结算管理任务桩程序
 */
public class SettlementService_Stub implements SettlementService {

	public IncomeBillVO getIncomeInfo(long id) {
		return new IncomeBillVO("2015/10/4", "南京市栖霞区营业厅", 1032); 
	}

	public void addIncomeInfo(IncomeBillVO income) {
		System.out.println("收款信息添加成功！\n");
	}

	public void incomeBill() {
		System.out.println("新建收款单成功！\n");
	}

}
