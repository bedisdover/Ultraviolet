package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.Connect;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * Order包数据
 */
public class OrderData extends UnicastRemoteObject implements OrderDataService {

	/**
	 */
	private static final long serialVersionUID = 1L;

	public OrderData() throws RemoteException {
		super();
	}

	private Connect connect;
	
	public OrderPO find(String id) throws RemoteException {
		
		connect = new Connect();
		
		String sql = "SELECT id,password,role,name,institutionid,institutionlocation FROM order";
		
		return null;
	}

	public void insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
