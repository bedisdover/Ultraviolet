package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.ReceiptRecordService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.ReceiptRecordDataService;
import LEMS.po.orderpo.IncomeBillPO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.IncomeBillVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 记录收款单任务
 */
public class ReceiptRecord extends AddOrder implements ReceiptRecordService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	private IncomeBillVO incomeBillVO;
	
	private UserVO userVO;
	
	public ReceiptRecord(UserVO uservo, IncomeBillVO incomeBillVO) {
		
		this.userVO = uservo;
		this.incomeBillVO = incomeBillVO;
		
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id, String collector) {
		OrderPO order = findOrder(id);
		orders.add(order);
		order.setCollector(collector);
		
		incomeBillVO.setAmount(incomeBillVO.getAmount() + order.getAmount());
	}

	public void createIncomeBill() {
		IncomeBillPO incomeBillPO = new IncomeBillPO();
		
		incomeBillPO.setDate(incomeBillVO.getDate());
		incomeBillPO.setAmount(incomeBillVO.getAmount());
		incomeBillPO.setCollector(incomeBillVO.getCollector());
		incomeBillPO.setOrders(orders);
		incomeBillPO.setId(this.createID());
		
		try {
			this.getDataService().insert(incomeBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private String createID() {
		String id = "";
		try {
			id = this.getDataService().createID(userVO.getInstitution().getLocation(), incomeBillVO.getDate());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	private ReceiptRecordDataService getDataService() {
		ReceiptRecordDataService dataService = null;
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			dataService = orderFactory.getReceiptRecordData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return dataService;
	}
}
