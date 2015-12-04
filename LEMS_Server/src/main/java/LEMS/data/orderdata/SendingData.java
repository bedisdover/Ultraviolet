package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.po.orderpo.DeliveryNotePO;
import LEMS.po.orderpo.OrderPO;

public class SendingData extends UnicastRemoteObject implements SendingDataService {
	private static final long serialVersionUID = 1L;

	private Connect connect;
	
	public SendingData() throws RemoteException {
		super();
		
		connect = new Connect();
	}

	@Override
	public DeliveryNotePO find(String id) throws RemoteException {
		
		String sql = "SELECT * FROM deliverynote WHERE id = " + id;
		
		DeliveryNotePO deliveryNotePO = new DeliveryNotePO();
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			deliveryNotePO.setId(result.getString(1));
			deliveryNotePO.setDate(result.getString(2));
			deliveryNotePO.setOrders(this.transferOrder(result.getString(3)));
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(DeliveryNotePO deliveryNotePO) throws RemoteException {
		String sql = "INSERT INTO deliverynote VALUES (?, ?, ?)";
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.setString(1, deliveryNotePO.getId());
			pstm.setString(2, deliveryNotePO.getDate());
			pstm.setString(3, this.transferOrder(deliveryNotePO.getOrders()));
			
			pstm.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(DeliveryNotePO deliveryNotePO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 将订单ID提取出并合并为一项，方便存储与读取
	 * 
	 * @param orders 所有托运订单
	 * @return 所有订单ID
	 */
	private String transferOrder(ArrayList<OrderPO> orders) {
		
		String result = "";
		
		for (OrderPO orderPO : orders) {
			result += orderPO.getId() + " ";
		}
		
		return result;
	}
	
	/**
	 * 将所有订单的ID转换为OrderPO集合
	 * 
	 * @param id 从数据库中读取出的所有订单ID
	 * @return 所有订单持久化对象
	 */
	private ArrayList<OrderPO> transferOrder(String id) {
		ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
		
		String temp[] = id.split(" ");
		
		try {
			OrderData orderData = new OrderData();
			
			for (String string : temp) {
				orders.add(orderData.find(string));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return orders;
	}
}
