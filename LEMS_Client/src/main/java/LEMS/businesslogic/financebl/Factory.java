package LEMS.businesslogic.financebl;

import LEMS.businesslogic.orderbl.Load;
import LEMS.businesslogic.orderbl.ReceiptRecord;
import LEMS.businesslogic.orderbl.Sending;
import LEMS.businesslogic.orderbl.VehicleLoad;
import LEMS.businesslogic.orderbl.transfer.Transfer;
import LEMS.businesslogic.utility.Approvalable;
import LEMS.po.financepo.DocumentPO;

/**
 * @author 宋益明
 * 
 * 工厂类
 * 用于生成审批单据时所需的具体实现类
 */
public class Factory {
	
	public static Factory factory;
	
	static {
		factory = new Factory();
	}
	
	private Factory() {}
	
	/**
	 * 根据下拉框中选择的单据类型生成具体的实现类
	 * 派件单
	 * 中转单
	 * 装车单
	 * 装运单
	 * 付款单
	 * 收款单
	 * @param index 选择的选项
	 */
	public Approvalable<? extends DocumentPO> create(String item) {
		Approvalable<? extends DocumentPO> approvalable = null;
		
		switch (item) {
		case "派件单":
			approvalable = new Sending();
			break;
		case "中转单":
			approvalable = new Transfer();
			break;
		case "装车单":
			approvalable = new VehicleLoad();
			break;
		case "装运单":
			approvalable = new Load();
			break;
		case "付款单":
			approvalable = new ReceiptRecord();
			break;
		case "收款单":
			approvalable = new ReceiptRecord();
		}
		
		return approvalable;
	}
}
