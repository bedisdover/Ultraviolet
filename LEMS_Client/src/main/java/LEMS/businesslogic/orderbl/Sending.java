package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.Approvalable;
import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.SendingService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.DeliveryNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.DeliveryVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 派件任务
 */
public class Sending extends AddOrder implements SendingService, Approvalable<DeliveryNotePO> {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	/**
	 * 派件单值对象
	 */
	private DeliveryVO deliveryVO;
	
	private UserVO userVO;
	
	public Sending() {}
	
	public Sending(UserVO userVO, DeliveryVO deliveryVO) {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		
		this.userVO = userVO;
		this.deliveryVO = deliveryVO;
	}
	
	public void addOrder(String id, String deliver) throws RemoteException {
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
	
	@Override
	public void approval(String id, DocumentState state) {
		try {
			this.getDataService().find(id).setState(state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
		return this.getDataService().findAll();
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
}
