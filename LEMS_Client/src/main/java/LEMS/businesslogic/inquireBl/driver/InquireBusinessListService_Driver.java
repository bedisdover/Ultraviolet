package LEMS.businesslogic.inquirebl.driver;

import java.util.ArrayList;

import LEMS.businesslogicservice.inquireblservice.InquireBusinessListService;
import LEMS.vo.financevo.PayBillVO;
import LEMS.vo.inquirevo.BusinessListVO;
import LEMS.vo.ordervo.IncomeBillVO;

/**
 * @author 章承尧
 * InquireBusinessListService的驱动程序
 */
public class InquireBusinessListService_Driver {
	public void drive(InquireBusinessListService inquireBusinessListService){
		BusinessListVO blv=inquireBusinessListService.getBusinessList("2015/10/24", "2015/10/25");
		System.out.println(blv.getStartTime()+"-"+blv.getEndTime());
		System.out.println("付款单：none");
		ArrayList<PayBillVO> pbv=blv.getPayBill();
		System.out.println("收款单：");
		ArrayList<IncomeBillVO> ibv=blv.getIncomeBill();
		IncomeBillVO income=ibv.get(0);
		System.out.println(income.getDate());
		System.out.println("收款单编号："+income.getId());
		System.out.println("订单编号:");
		for(int i=0;i<income.getOrders().size();i++){
			System.out.println(income.getOrders().get(i));
		}
		System.out.println("Total income: "+income.getSum());
	}
}
