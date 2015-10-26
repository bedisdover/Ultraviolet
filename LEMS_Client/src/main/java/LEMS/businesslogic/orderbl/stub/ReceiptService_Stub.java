package LEMS.businesslogic.orderbl.stub;

import LEMS.businesslogicservice.orderblservice.ReceiptService;
import LEMS.vo.ordervo.ArrivalVO;

/**
 * @author 宋益明
 * 
 * 接收任务桩程序
 */
public class ReceiptService_Stub implements ReceiptService{

	public void addOrder(long id) {
		System.out.println("添加订单成功！");
	}

	public void createArrivalNote(ArrivalVO arrivalInfo) {
		System.out.println("创建接收单成功！");		
	}

}
