package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	private Connect connect;
	
	public OrderData() throws RemoteException {
		super();
		
		connect = new Connect();
	}

	
	public OrderPO find(String id) throws RemoteException {
		
//		String sql = "SELECT id, senderName, senderPhone, senderAddress, "
//					 + "receiverName, receiverPhone, receiverAddress, "
//					 + "name, quantity, weight, volumn, expressType, packageType, amount, time FROM order";
		//TODO 待检验
		String sql = "SELECT * FROME order WHERE id = " + id;
		
		ResultSet result = connect.getResultSet(sql);
		
		OrderPO orderPO = new OrderPO();
		
		try {
			orderPO.setSenderName(result.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(OrderPO po) throws RemoteException {
		
		String sql = "INSERT INTO order(id, senderName, senderPhone, senderAddress";
		
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
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
