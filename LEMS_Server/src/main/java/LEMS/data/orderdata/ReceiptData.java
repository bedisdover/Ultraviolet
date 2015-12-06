package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.data.TransferID;
import LEMS.dataservice.orderdataservice.ReceiptDataService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.ArrivalNotePO;

/**
 * @author 宋益明
 *
 * 接收任务数据操作，实现对到达单的增删改查
 * 到达单存储内容及顺序：
 * 		ID、单据状态、日期、出发地
 * 		所有托运单据ID（字符串，以空格隔开）
 * 		机构编号、中转单编号
 */
public class ReceiptData extends UnicastRemoteObject implements ReceiptDataService {
	private static final long serialVersionUID = 1L;

	private Connect connect;
	
	private TransferID transferID;
	
	public ReceiptData() throws RemoteException {
		super();
		
		connect = new Connect();
		transferID = new TransferID();
	}

	@Override
	public ArrivalNotePO find(String id) throws RemoteException {
		
		ArrivalNotePO arrivalNotePO = new ArrivalNotePO();
		
		String sql = "SELECT * FROM arrivalnote WHERE id = " + id;

		ResultSet result = connect.getResultSet(sql);
		
		try {
			arrivalNotePO.setId(id);
			arrivalNotePO.setState(DocumentState.valueOf(result.getString(2)));
			arrivalNotePO.setDate(result.getString(3));
			arrivalNotePO.setDeparture(result.getString(4));
			arrivalNotePO.setOrders(transferID.transferOrder(result.getString(5)));
			arrivalNotePO.setInstitution(result.getString(6));
			arrivalNotePO.setTransferNoteId(result.getString(7));
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arrivalNotePO;
	}

	@Override
	public void insert(ArrivalNotePO arrivalNotePO) throws RemoteException {
		String sql = "INSERT INTO arrivalnote VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.setString(1, arrivalNotePO.getId());
			pstm.setString(2, arrivalNotePO.getState() + "");
			pstm.setString(3, arrivalNotePO.getDate());
			pstm.setString(4, arrivalNotePO.getDeparture());
			pstm.setString(5, transferID.transferOrder(arrivalNotePO.getOrders()));
			pstm.setString(6, arrivalNotePO.getInstitution());
			pstm.setString(7, arrivalNotePO.getTransferNoteId());
			
			pstm.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(ArrivalNotePO arrivalNotePO) throws RemoteException {
		this.delete(arrivalNotePO.getId());
		this.insert(arrivalNotePO);
	}

	@Override
	public void delete(String id) throws RemoteException {

		String sql = "DELETE FROM arrivalnote WHERE id = " + id;
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
