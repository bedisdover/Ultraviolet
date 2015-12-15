package LEMS.businesslogic.orderbl.load;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.orderbl.AddOrder;
import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.LoadService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.LoadDataService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.LoadNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.LoadVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 装运管理任务
 * TODO 自从我把transfer和load分离出来后，就发现这个类和车辆装车管理真的好像……
 * 	装车单（记录装车日期、本中转中心汽运编号（中转中心编号+日期+0000000七位数字）、到达地（营业厅）、
 * 	车辆代号、监装员、押运员、本次装箱所有订单条形码号）、运费（运费根据出发地和目的地自动生成）。
 * 	
 * 以下为车辆装车管理内容（营业厅）
 * 	装车单（记录装车日期、本营业厅编号（025城市编码+1营业厅+0000鼓楼营业厅）、
 * 	汽运编号 （营业厅编号+20150921日期+00000编码 、五位数字）、到达地（本地中转中心或者其它营业厅）、
 * 	车辆代号、监装员、押运员、本次装箱所有订单条形码号）、运费（运费根据出发地和目的地自动生成）
 */
public class Load extends AddOrder implements LoadService {
	/**
	 * 订单列表
	 */
	protected ArrayList<OrderPO> orders;
	
	private LoadVO loadVO;
	
	private UserVO user;
	
	public Load(LoadVO loadVO, UserVO user) {
		this.loadVO = loadVO;
		this.user = user;
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		orders.add(findOrder(id));
	}

	public void createLoadNote() {
		LoadNotePO loadNote = new LoadNotePO();
		loadNote.setId(this.createID());
		loadNote.setState(DocumentState.waiting);
		loadNote.setDate(loadVO.getDate());
		loadNote.setDeparture(user.getInstitution().getID());
		loadNote.setDestination(loadVO.getDestination());
		loadNote.setSuperVision(loadVO.getSuperVision());
		loadNote.setSuperCargo(loadVO.getSuperCargo());
		loadNote.setOrders(orders);
		loadNote.setPassage(this.calculatePassage());
		
		try {
			this.getDataService().insert(loadNote);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private String createID() {
		String id = "";
		
		try {
			id = this.getDataService().createID(user.getInstitution().getID(), loadVO.getDate());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	private double calculatePassage() {
		return 0;
	}
	
	private LoadDataService getDataService() {
		LoadDataService dataService = null;
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			dataService = orderFactory.getLoadData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return dataService;
	}
	
	public void setDate() {
		
	}
//	
//	public void setNumber(String number) {
//		
//	}
//	
//	public void setDeparture(String departure) {
//		
//	}
//	
//	public void setDestination(String destination) {
//		
//	}
//	
//	public void setSuperVision(UserPO superVision) {
//		
//	}
}
