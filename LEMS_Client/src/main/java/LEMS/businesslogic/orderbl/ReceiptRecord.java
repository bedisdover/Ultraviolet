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
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.IncomePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.IncomeVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 记录收款单任务
 */
public class ReceiptRecord implements ReceiptRecordService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	private IncomeVO incomeBillVO;
	
	private UserVO userVO;
	
	public ReceiptRecord(UserVO uservo, IncomeVO incomeBillVO) {
		
		this.userVO = uservo;
		this.incomeBillVO = incomeBillVO;
		
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}

	@Override
	public ArrayList<OrderPO> getOrders(String collector, String date) throws RemoteException {
		orders = this.getDataService().getOrders(collector, date);
		return orders;
	}
	
	public void createIncomeBill() {
		IncomePO income = new IncomePO();
		
		income.setId(this.createID());
		income.setState(DocumentState.waiting);
		income.setDate(incomeBillVO.getDate());
		income.setAmount(incomeBillVO.getAmount());
		income.setCollector(incomeBillVO.getCollector());
		income.setOrders(orders);
		
		try {
			this.getDataService().insert(income);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private String createID() {
		String id = "";
		try {
			id = this.getDataService().createID(userVO.getInstitution().getID(), incomeBillVO.getDate());
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
