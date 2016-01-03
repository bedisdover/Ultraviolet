package LEMS.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;

import LEMS.businesslogic.utility.DateFormate;
import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * 快递员送达快递后，输入送达时间及收件人姓名
 */
public class Deliver extends AddOrder {
	
	private OrderPO order;
	
	public void endDeliver(String id, String time, String receiver) throws RemoteException {
		order = findOrder(id);
		
		this.setReceiver(receiver);
		this.setTime(time);
		//更新订单信息
		updateOrder(order);
		System.out.println(order.getReceiver());
	}
	
	private void setReceiver(String name) {
		order.setReceiver(name);
	}
	
	/**
	 * 存储收件时间
	 */
	private void setTime(String time) {
		String orderTime = order.getTime();
		try {
			Date sendDate = DateFormate.DATE_FORMAT.parse(orderTime);
			Date receiveDate = new Date();
			long diff = receiveDate.getTime() - sendDate.getTime();
			//天数
			long day = diff / (1000 * 60 * 60 * 24);
			//小时数
			long hour = (diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
			//时间（天数+小时数）
			orderTime = day + "" + hour;
			//更新快递所需时间
			order.setTime(orderTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
