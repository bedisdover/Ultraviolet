package LEMS.businesslogic.orderbl.stub;

import LEMS.businesslogicservice.orderblservice.OrderService;
import LEMS.vo.ordervo.Express;
import LEMS.vo.ordervo.GoodsVO;
import LEMS.vo.ordervo.ReceiverVO;
import LEMS.vo.ordervo.SenderVO;

/**
 * @author 宋益明
 *
 * 订单管理任务桩程序
 */
public class OrderService_Stub implements OrderService {
	
	public void addSender(SenderVO sender) {
		System.out.println("添加寄件人成功！");
	}

	public void addReceiver(ReceiverVO receiver) {
		System.out.println("添加收件人成功！");
	}

	public void addGoodsInfo(GoodsVO goods) {
		System.out.println("添加货物信息成功！");
	}

	public void chooseType(Express type) {
		System.out.println("选择快递类型成功！");
	}

	public long createID() {
		System.out.println("创建订单条形码成功！");
		return 123456;
	}

	public double getMoney() {
		System.out.println("单件金额为15元");
		return 15;
	}

	public double getTotal() {
		System.out.println("总金额为15元");
		return 15;
	}

	public String getTime() {
		System.out.println("预计需3天送达");
		return "三天";
	}

	public void endOrder() {
		System.out.println("订单管理任务结束！");
	}

}
