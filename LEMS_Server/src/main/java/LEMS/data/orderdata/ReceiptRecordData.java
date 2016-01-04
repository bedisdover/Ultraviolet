package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.data.TransferID;
import LEMS.dataservice.orderdataservice.ReceiptRecordDataService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.IncomePO;
import LEMS.po.orderpo.OrderPO;

public class ReceiptRecordData extends UnicastRemoteObject implements ReceiptRecordDataService {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据库连接对象
	 */
	private Connect connect;
	
	/**
	 * 订单ID转换
	 */
	private TransferID transferID;
	
	/**
	 * ID长度
	 * 营业厅编号+20150921日期+00000编码 、五位数字
	 */
	private final int ID_LENGTH = 20;
	
	public ReceiptRecordData() throws RemoteException {
		super();
		
		connect = new Connect();
		transferID = new TransferID();
	}

	@Override
	public IncomePO find(String id) throws RemoteException {
		//收款单表名设为cash，以便与财务管理中的收款单混淆
		String sql = "SELECT * FROM cash WHERE id = " + id;
		
		IncomePO incomeBillPO = new IncomePO();
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			result.next();
			incomeBillPO.setId(result.getString(1));
			incomeBillPO.setState(DocumentState.valueOf(result.getString(2)));
			incomeBillPO.setDate(result.getString(3));
			incomeBillPO.setAmount(result.getDouble(4));
			incomeBillPO.setCollector(result.getString(5));
			incomeBillPO.setOrders(transferID.transferOrder(result.getString(6)));
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return incomeBillPO;
	}

	@Override
	public ArrayList<IncomePO> findAll() throws RemoteException {
		ArrayList<IncomePO> incomePOs = new ArrayList<>();
		
		String sql = "SELECT * FROM cash";
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			while (result.next()) {
				if (result.getString(2).equals("waiting")) {
					incomePOs.add(find(result.getString(1)));
				}
			}
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return incomePOs;
	}

	@Override
	public void insert(IncomePO incomeBillPO) throws RemoteException {
		String sql = "INSERT INTO cash VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.setString(1, incomeBillPO.getId());
			pstm.setString(2, incomeBillPO.getState() + "");
			pstm.setString(3, incomeBillPO.getDate());
			pstm.setDouble(4, incomeBillPO.getAmount());
			pstm.setString(5, incomeBillPO.getCollector());
			pstm.setString(6, transferID.transferOrder(incomeBillPO.getOrders()));
			
			pstm.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(IncomePO incomeBillPO) throws RemoteException {
		this.delete(incomeBillPO.getId());
		this.insert(incomeBillPO);
	}

	@Override
	public void delete(String id) throws RemoteException {
		String sql = "DELETE FROM cash WHERE id = " + id;
		
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
		String id = new CreateID().createID("cash", ID_LENGTH, institution + date);
		
		return id;
	}

	@Override
	public ArrayList<OrderPO> getOrders(String collector, String date) throws RemoteException {
		//从order表中获取所有符合条件的订单
		ArrayList<OrderPO> orders = new OrderData().findAll(collector, date);
		return orders;
	}
}
