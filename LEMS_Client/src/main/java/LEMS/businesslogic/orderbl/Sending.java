package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.SendingService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.po.orderpo.DeliveryNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.DeliveryVO;
import LEMS.vo.uservo.UserVO;

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
	 * 派件单值对象
	 */
	private DeliveryVO deliveryVO;
	
	private UserVO userVO;
	
	public Sending(UserVO userVO, DeliveryVO deliveryVO) {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		
		this.userVO = userVO;
		this.deliveryVO = deliveryVO;
	}
	
	public void addOrder(String id, String deliver) {
		OrderPO orderPO = findOrder(id);
		orderPO.setDeliver(deliver);

		//更新订单信息
		updateOrder(orderPO);
		
		orders.add(orderPO);
	}

	public void createDeliveryNote() {
		DeliveryNotePO deliveryNotePO = new DeliveryNotePO();
		
		deliveryNotePO.setDate(deliveryVO.getDate());
		deliveryNotePO.setOrders(orders);
		deliveryNotePO.setId(this.createId());
		
		try {
			getDataService().insert(deliveryNotePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成派件单ID
	 */
	private String createId() {
		String id = "";
		try {
			id = this.getDataService().createID(userVO.getInstitution().getLocation(), deliveryVO.getDate());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	private SendingDataService getDataService() {
		
		SendingDataService sendingDataService = null;
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			sendingDataService = orderFactory.getSendingData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return sendingDataService;
	}
	
//	//TODO 应该是快递员送达以后设置的送达时间，但是似乎没有这个功能
//	/**
//	 * 存储收件时间
//	 */
//	private void setTime(OrderPO orderPO) {
//		String time = orderPO.getTime();
//		try {
//			Date sendDate = DateFormate.DATE_FORMAT.parse(time);
//			Date receiveDate = new Date();
//			long diff = receiveDate.getTime() - sendDate.getTime();
//			//天数
//			long day = diff / (1000 * 60 * 60 * 24);
//			//小时数
//			long hour = (diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
//			//时间（天数+小时数）
//			time = day + "" + hour;
//			//更新快递所需时间
//			orderPO.setTime(time);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 存储收件人
//	 */
//	private void setReceiver(OrderPO orderPO) {
//		//TODO 添加实际收件人
//	}
}
