package LEMS.businesslogic.orderbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import LEMS.businesslogicservice.orderblservice.SendingService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.DeliveryVO;

/**
 * @author 宋益明
 * 
 * 派件任务
 */
public class Sending extends AddOrder implements SendingService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	/**
	 * 日期格式
	 */
	private SimpleDateFormat dateFormat;
	
	public Sending() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		
		dateFormat = new SimpleDateFormat("yyyyMMddhh");
	}
	
	public void addOrder(String id) {
		OrderPO orderPO = findOrder(id);
		
		//记录收件时间
		this.setTime(orderPO);
		//记录收件人
		this.setReceiver(orderPO);
		//更新订单信息
		updateOrder(orderPO);
		
		orders.add(orderPO);
	}

	public void createDeliveryNote(DeliveryVO deliveryInfo) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	/**
	 * 存储收件时间
	 */
	private void setTime(OrderPO orderPO) {
		String time = orderPO.getTime();
		try {
			Date sendDate = dateFormat.parse(time);
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
	
	/**
	 * 存储收件人
	 */
	private void setReceiver(OrderPO orderPO) {
		//TODO 添加实际收件人
	}
}
