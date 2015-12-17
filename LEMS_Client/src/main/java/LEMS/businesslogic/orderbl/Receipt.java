package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.ReceiptService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.ReceiptDataService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.ArrivalNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.presentation.MainFrame;
import LEMS.presentation.orderui.ReceiveUi;
import LEMS.vo.inquirevo.LogisticsInfoVO;
import LEMS.vo.ordervo.ArrivalVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 接收任务
 */
public class Receipt extends AddOrder implements ReceiptService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	private MainFrame mainFrame;
	
	/**
	 * 营业厅业务员
	 */
	private UserVO user;
	
	/**
	 * 到达单值对象
	 */
	private ArrivalVO arrivalVO;
	
	public Receipt(UserVO user, ArrivalVO arrivalVO) {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		
		this.user = user;
		this.arrivalVO = arrivalVO;
	}
	
	public void addOrder(String id) throws RemoteException {
		//获得物流信息
//		LogisticsInfoVO logistics = getLogistics(id);
		//更新物流信息
//		logistics.setTrace("到达" + user.getInstitution().getLocation() + "营业厅");
//		logistics.setInstitution(user.getInstitution().getLocation());
//		updateLogistics(logistics);
		
		//添加订单到订单列表中
		//TODO 其他异常
		orders.add(findOrder(id));
	}

	public void createArrivalNote() {
		// TODO 添加货物状态
		ArrivalNotePO arrivalNotePO = new ArrivalNotePO();
		
		arrivalNotePO.setDate(arrivalVO.getDate());
		arrivalNotePO.setDeparture(arrivalVO.getDepature());
		arrivalNotePO.setOrders(orders);
		arrivalNotePO.setId(createId());
		arrivalNotePO.setState(DocumentState.waiting);
		arrivalNotePO.setInstitution(user.getInstitution().getID());
		//TODO 
		arrivalNotePO.setTransferNoteId("123134313414");
		
		try {		
			getDataService().insert(arrivalNotePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成到达单ID
	 */
	private String createId() {
		String id = "";
		try {		
			id = this.getDataService().createID(user.getInstitution().getID(), arrivalVO.getDate());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	private ReceiptDataService getDataService() {
		
		ReceiptDataService receiptDataService = null;
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			receiptDataService = orderFactory.getReceiptData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return receiptDataService;
	}
}
