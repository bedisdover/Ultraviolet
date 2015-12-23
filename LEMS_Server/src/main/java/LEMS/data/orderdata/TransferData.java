package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.data.TransferID;
import LEMS.dataservice.orderdataservice.TransferDataService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.TransferNotePO;

/**
 * @author 宋益明
 *
 * 中转任务数据操作，负责实现中转单的增删改查及生成ID操作
 * 中转单包含：
 * 		中转单编号（中转中心编号+日期+0000000七位数字）、
 * 		中转单状态、日期、航班号、出发地、到达地、
 * 		货柜号、监装员、本次装箱所有托运单号、运费
 */
public class TransferData extends UnicastRemoteObject implements TransferDataService {
	private static final long serialVersionUID = 1L;

	private final int MAX_LENGTH = 20;
	
	private Connect connect;
	
	private TransferID transferID;
	
	public TransferData() throws RemoteException {
		super();
		
		connect = new Connect();
		transferID = new TransferID();
	}

	@Override
	public TransferNotePO find(String id) throws RemoteException {
		TransferNotePO transferNotePO = new TransferNotePO();
		
		String sql = "SELECT * FROM arrivalnote WHERE id = " + id;

		ResultSet result = connect.getResultSet(sql);
		
		try {
			result.next();
			transferNotePO.setId(id);
			transferNotePO.setState(DocumentState.valueOf(result.getString(2)));
			transferNotePO.setDate(result.getString(3));
			transferNotePO.setFlight(result.getString(4));
			transferNotePO.setDeparture(result.getString(5));
			transferNotePO.setDestination(result.getString(6));
			transferNotePO.setContainer(result.getString(7));
			transferNotePO.setSuperVision(result.getString(8));
			transferNotePO.setOrders(transferID.transferOrder(result.getString(9)));
			transferNotePO.setPassage(result.getDouble(10));
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transferNotePO;
	}

	@Override
	public void insert(TransferNotePO transferNotePO) throws RemoteException {
		String sql = "INSERT INTO transfernote VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.setString(1, transferNotePO.getId());
			pstm.setString(2, transferNotePO.getState() + "");
			pstm.setString(3, transferNotePO.getDate());
			pstm.setString(4, transferNotePO.getFlight());
			pstm.setString(5, transferNotePO.getDeparture());
			pstm.setString(6, transferNotePO.getDestination());
			pstm.setString(7, transferNotePO.getContainer());
			pstm.setString(8, transferNotePO.getSuperVision());
			pstm.setString(9, new TransferID().transferOrder(transferNotePO.getOrders()));
			pstm.setDouble(10, transferNotePO.getPassage());
			
			pstm.executeUpdate();
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(TransferNotePO transferNotePO) throws RemoteException {
		this.delete(transferNotePO.getId());
		this.insert(transferNotePO);
	}

	@Override
	public void delete(String id) throws RemoteException {
		String sql = "DELETE FROM transfernote WHERE id = " + id;
		
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
		String id = new CreateID().createID("transfernote", MAX_LENGTH, institution + date);
		
		return id;
	}
	
	public static void main(String[] args) {
		//中转单状态、日期、航班号、出发地、到达地、
		//货柜号、监装员、本次装箱所有托运单号、运费
		//TODO 待检验
		 
	}
}
