package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.data.TransferID;
import LEMS.dataservice.orderdataservice.LoadDataService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.LoadNotePO;

public class LoadData extends UnicastRemoteObject implements LoadDataService {
	private static final long serialVersionUID = 1L;

	private Connect connect;
	
	private TransferID transferID;

	/**
	 * ID长度
	 * 营业厅编号+20150921日期+00000编码 、五位数字
	 */
	private static final int ID_LENGTH = 20;
	
	public LoadData() throws RemoteException {
		super();

		connect = new Connect();
		transferID = new TransferID();
	}

	@Override
	public LoadNotePO find(String id) throws RemoteException {
		LoadNotePO LoadNotePO = new LoadNotePO();
		
		String sql = "SELECT * FROM loadnote WHERE id = " + id;
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			LoadNotePO.setId(id);
			LoadNotePO.setState(DocumentState.valueOf(result.getString(2)));
			LoadNotePO.setDate(result.getString(3));
			LoadNotePO.setVehicle(result.getString(4));
			LoadNotePO.setDeparture(result.getString(5));
			LoadNotePO.setDestination(result.getString(6));
			LoadNotePO.setSuperVision(result.getString(7));
			LoadNotePO.setSuperCargo(result.getString(8));
			LoadNotePO.setOrders(transferID.transferOrder(result.getString(9)));
			LoadNotePO.setPassage(result.getDouble(10));
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return LoadNotePO;
	}

	@Override
	public void insert(LoadNotePO loadNotePO) throws RemoteException {

		String sql = "INSERT INTO loadnote VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.setString(1, loadNotePO.getId());
			pstm.setString(2, loadNotePO.getState() + "");
			pstm.setString(3, loadNotePO.getDate());
			pstm.setString(4, loadNotePO.getVehicle());
			pstm.setString(5, loadNotePO.getDeparture());
			pstm.setString(6, loadNotePO.getDestination());
			pstm.setString(7, loadNotePO.getSuperVision());
			pstm.setString(8, loadNotePO.getSuperCargo());
			pstm.setString(9, transferID.transferOrder(loadNotePO.getOrders()));
			pstm.setDouble(10, loadNotePO.getPassage());
			
			pstm.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(LoadNotePO loadNotePO) throws RemoteException {
		this.delete(loadNotePO.getId());
		this.insert(loadNotePO);
	}

	@Override
	public void delete(String id) throws RemoteException {
		String sql = "DELETE FROM loadnote WHERE id = " + id;
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		
		try {
			pstm.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public ArrayList<LoadNotePO> findAll() throws RemoteException {
		ArrayList<LoadNotePO> loadNotePOs = new ArrayList<>();
		
		String sql = "SELECT * FROM loadnote";
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			while (result.next()) {
				if (result.getString(2).equals("waiting")) {
					loadNotePOs.add(find(result.getString(1)));
				}
			}
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loadNotePOs;
	}
	
	@Override
	public String createID(String institution, String date) throws RemoteException {
		String id = new CreateID().createID("cash", ID_LENGTH, institution + date);
		
		return id;
	}
}
