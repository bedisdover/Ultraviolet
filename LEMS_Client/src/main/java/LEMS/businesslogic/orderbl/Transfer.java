package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.TransferService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.orderdataservice.TransferDataService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.TransferVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 中转接收任务
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
	
	public void addOrder(String id) {
		// TODO Auto-generated method stub
		
	}

	public void createTransferNote() {
		// TODO Auto-generated method stub
		
	}
	
	private TransferDataService getDataService() {
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
