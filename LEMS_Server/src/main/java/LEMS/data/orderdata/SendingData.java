package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.data.TransferID;
import LEMS.dataservice.orderdataservice.SendingDataService;
import LEMS.po.financepo.DocumentState;
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
	
	private final int ID_LENGTH = 18;
	
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
			result.next();
			
			deliveryNotePO.setId(result.getString(1));
			deliveryNotePO.setState(DocumentState.valueOf(result.getString(2)));
			deliveryNotePO.setDate(result.getString(3));
			deliveryNotePO.setOrders(transferID.transferOrder(result.getString(4)));
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deliveryNotePO;
	}
	
	@Override
	public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
		ArrayList<DeliveryNotePO> deliveryNotePOs = new ArrayList<>();
		
		String sql = "SELECT * FROM deliverynote";
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			while (result.next()) {
				if (result.getString(2).equals("waiting")) {
					deliveryNotePOs.add(find(result.getString(1)));
				}
			}
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deliveryNotePOs;
	}

	@Override
	public void insert(DeliveryNotePO deliveryNotePO) throws RemoteException {
		String sql = "INSERT INTO deliverynote VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.setString(1, deliveryNotePO.getId());
			pstm.setString(2, deliveryNotePO.getState() + "");
			pstm.setString(3, deliveryNotePO.getDate());
			pstm.setString(4, transferID.transferOrder(deliveryNotePO.getOrders()));
			
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

	@Override
	public String createID(String institution, String date) throws RemoteException {
		String id = new CreateID().createID("delivery", ID_LENGTH, institution + date);
		
		return id;
	}
}
