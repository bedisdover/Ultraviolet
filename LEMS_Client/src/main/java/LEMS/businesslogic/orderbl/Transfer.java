package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.orderbl.transfer.AirplaneTransfer;
import LEMS.businesslogic.orderbl.transfer.Factory;
import LEMS.businesslogic.orderbl.transfer.LandwayTransfer;
import LEMS.businesslogic.orderbl.transfer.Passage;
import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.TransferService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.TransferDataService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.transfer.TransferNotePO;
import LEMS.po.storepo.TransportType;
import LEMS.vo.ordervo.TransferVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 中转任务
 */
public class Transfer extends AddOrder implements TransferService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	private UserVO user;
	
	private TransferVO transferVO;
	
	public Transfer(UserVO user, TransferVO transferVO) {
		
		this.user = user;
		this.transferVO = transferVO;
		
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) throws RemoteException {
		orders.add(findOrder(id));
	}

	public void createTransferNote(TransportType type) throws RemoteException {
		TransferNotePO transferNotePO = new TransferNotePO();
		//TODO 测试运费计算
//		transferNotePO.setId(this.getDataService().createID(user.getInstitution().getID(), transferVO.getDate()));
//		transferNotePO.setState(DocumentState.waiting);
//		transferNotePO.setDate(transferVO.getDate());
//		transferNotePO.setFlight(transferVO.getFlight());
//		transferNotePO.setDeparture(user.getInstitution().getLocation());
//		transferNotePO.setDestination(transferVO.getDestination());
//		transferNotePO.setContainer(transferVO.getContainer());
//		transferNotePO.setSuperVision(transferVO.getSuperVision());
//		transferNotePO.setOrders(orders);
		transferNotePO.setPassage(this.calculatePassage(type));
		
		this.getDataService().insert(transferNotePO);
	}
	
	private double calculatePassage(TransportType type) {
		Passage passage = Factory.createPassage(type);
		double result = passage.calculateMessage(user.getInstitution().getLocation(), transferVO.getDestination()); 
		System.out.println(result);
		return result;
	}
	
	private TransferDataService getDataService() throws RemoteException {
		TransferDataService dataService = null;
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			dataService = orderFactory.getTransferData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			throw e;
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return dataService;
	}
}
