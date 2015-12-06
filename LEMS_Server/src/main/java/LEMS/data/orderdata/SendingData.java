package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.po.orderpo.DeliveryNotePO;

public class SendingData extends UnicastRemoteObject implements SendingDataService {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据库连接对象
	 */
	private Connect connect;
	
	/**
	 * 订单ID转换
	 */
	private TransferID transferID;
	
	public SendingData() throws RemoteException {
		super();
		
		connect = new Connect();
		transferID = new TransferID();
	}

	@Override
	public DeliveryNotePO find(String id) throws RemoteException {
		
		String sql = "SELECT * FROM deliverynote WHERE id = " + id;
		
		DeliveryNotePO deliveryNotePO = new DeliveryNotePO();
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			deliveryNotePO.setId(result.getString(1));
			deliveryNotePO.setDate(result.getString(2));
			deliveryNotePO.setOrders(transferID.transferOrder(result.getString(3)));
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deliveryNotePO;
	}

	@Override
	public void insert(DeliveryNotePO deliveryNotePO) throws RemoteException {
		String sql = "INSERT INTO deliverynote VALUES (?, ?, ?)";
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.setString(1, deliveryNotePO.getId());
			pstm.setString(2, deliveryNotePO.getDate());
			pstm.setString(3, transferID.transferOrder(deliveryNotePO.getOrders()));
			
			pstm.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(DeliveryNotePO deliveryNotePO) throws RemoteException {
		this.delete(deliveryNotePO.getId());
		this.insert(deliveryNotePO);
	}

	@Override
	public void delete(String id) throws RemoteException {
		String sql = "DELETE FROM deliverynote WHERE id = " + id;
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
