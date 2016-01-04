package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import LEMS.data.Connect;
import LEMS.dataservice.orderdataservice.DistanceDataService;
import LEMS.po.orderpo.DistancePO;

public class DistanceData extends UnicastRemoteObject implements DistanceDataService {
	private static final long serialVersionUID = 1L;

	// 获取数据库连接
	private Connect connect;

	public DistanceData() throws RemoteException {
		super();
		connect = new Connect();
	}

	public DistancePO getDistance() throws RemoteException {
		DistancePO distancePO = new DistancePO();
		;
		HashMap<String, Double> distance = new HashMap<String, Double>();

		String sql = "SELECT * FROM distance";

		ResultSet result = connect.getResultSet(sql);

		try {
			while (result.next()) {
				distance.put(result.getString(1), result.getDouble(2));
			}
			// 关闭数据库连接
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		distancePO.setCityDistance(distance);
		return distancePO;
	}

	public void setDistance(DistancePO distancePO) throws RemoteException {
		String sql = "INSERT INTO distance VALUES (?, ?)";
		//清空数据库
		this.delete();
		
		PreparedStatement pstm = connect.getPreparedStatement(sql);
		// 获得距离列表
		HashMap<String, Double> distance = distancePO.getCityDistance();

		Set<Entry<String, Double>> temp = distance.entrySet();

		try {
			for (Entry<String, Double> entry : temp) {
				pstm.setString(1, entry.getKey());
				pstm.setDouble(2, entry.getValue());
				pstm.executeUpdate();
			}
			// 关闭数据库连接
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void delete() throws RemoteException{
		PreparedStatement pstmt = null;

		connect = new Connect();
		String sql = "DELETE FROM distance";

		try {
			pstmt = connect.getPreparedStatement(sql);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		connect.closeConnection();
	}
}
