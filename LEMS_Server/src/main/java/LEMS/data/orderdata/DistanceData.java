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

	public static void main(String[] args) {

		DistanceData distanceData = null;
		DistancePO distancePO = new DistancePO();
		
		HashMap<String, Double> distance = new HashMap<>();
		//相同城市间距离
		distance.put("sameCity", 30.0);
		distance.put("北京上海", 1064.7);
		distance.put("北京广州", 1888.8);
		distance.put("北京南京", 900.0);
		distance.put("上海广州", 1213.0);
		distance.put("上海南京", 266.0);
		distance.put("广州南京", 1132.0);
		distancePO.setCityDistance(distance);
		//测试写入
		try {
			distanceData = new DistanceData();
			distanceData.setDistance(distancePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//测试读取数据
		try {
			DistancePO distancePO2 = distanceData.getDistance();
			System.out.println(distancePO2.getDistance("北京", "北京"));
			System.out.println(distancePO2.getDistance("北京", "上海"));
			System.out.println(distancePO2.getDistance("北京", "广州"));
			System.out.println(distancePO2.getDistance("上海", "南京"));
			System.out.println(distancePO2.getDistance("广州", "南京"));
			System.out.println(distancePO2.getDistance("广州", "广州"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
