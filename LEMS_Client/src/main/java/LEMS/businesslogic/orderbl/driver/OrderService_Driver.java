package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.OrderService_Stub;
import LEMS.vo.ordervo.Express;
import LEMS.vo.ordervo.GoodsVO;
import LEMS.vo.ordervo.ReceiverVO;
import LEMS.vo.ordervo.SenderVO;

/**
 * @author 宋益明
 * 
 * 订单管理任务驱动程序
 */
public class OrderService_Driver {
	
	public void drive(OrderService_Stub orderService_Stub) {
		orderService_Stub.addSender(new SenderVO("张三", "13919191919", "南京市仙林大道163号"));
		orderService_Stub.addReceiver(new ReceiverVO("李四", "13818181818", "北京市海淀区1234号"));
		orderService_Stub.addGoodsInfo(new GoodsVO("运动鞋", "20*30*10", 10, 2, 20));
		orderService_Stub.chooseType(Express.economy);
		orderService_Stub.getMoney();
		orderService_Stub.getTotal();
		orderService_Stub.getTime();
		orderService_Stub.createID();
		orderService_Stub.endOrder();
	}
}
