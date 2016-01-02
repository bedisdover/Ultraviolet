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
	
	public void endDeliver(String id, String receiver) throws RemoteException {
		OrderPO order = findOrder(id);
		
		this.setReceiver(order, receiver);
		this.setTime(order);
		//更新订单信息
		updateOrder(order);
	}
	
	private void setReceiver(OrderPO order, String name) {
		order.setReceiver(name);
	}
	
	/**
	 * 存储收件时间
	 */
	private void setTime(OrderPO orderPO) {
		String time = orderPO.getTime();
		try {
			Date sendDate = DateFormate.DATE_FORMAT.parse(time);
			Date receiveDate = new Date();
			long diff = receiveDate.getTime() - sendDate.getTime();
			//天数
			long day = diff / (1000 * 60 * 60 * 24);
			//小时数
			long hour = (diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
			//时间（天数+小时数）
			time = day + "" + hour;
			//更新快递所需时间
			orderPO.setTime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
