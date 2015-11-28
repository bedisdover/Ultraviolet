package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import LEMS.data.userdata.UserData;
import LEMS.dataservice.financedataservice.PriceDataService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;

public class PriceData implements PriceDataService {

	private PricePO pricePO;

	public PricePO getPrice() throws RemoteException {
		// 创建并初始化快递类型价格表
		Map<String, Double> expressPrice = new HashMap<String, Double>();
		expressPrice.put("economy", 0.0);
		expressPrice.put("standard", 0.0);
		expressPrice.put("special", 0.0);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "SELECT type, price FROM price";
		try {
			Class.forName(UserData.DBDRIVER);
			conn = DriverManager.getConnection(UserData.DBURL, UserData.DBUSER,
					UserData.DBPASS);
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			while (result.next()) {
				if (expressPrice.containsKey(result.getString(1))) {
					expressPrice.put(result.getString(1),
							Double.parseDouble(result.getString(2)));
				}
			}
			result.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pricePO;
	}

	public void pricing(PricePO price) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		// TODO 添加Double类型
		String sql = "INSERT INTO price(type, price) VALUES (?, ?)";

		try {
			// TODO 多次写入数据
			Class.forName(UserData.DBDRIVER);
			conn = DriverManager.getConnection(UserData.DBURL, UserData.DBUSER,
					UserData.DBPASS);
			pstmt = conn.prepareStatement(sql);

			// 存储快递类型“经济”的价格
			pstmt.setString(1, "economy");
			pstmt.setString(2, PricePO.getPrice(Express.economy) + "");
			pstmt.executeUpdate();
			// 存储快递类型“普通”的价格
			pstmt.setString(1, "standard");
			pstmt.setString(2, PricePO.getPrice(Express.standard) + "");
			pstmt.executeUpdate();
			// 存储快递类型“特快”的价格
			pstmt.setString(1, "special");
			pstmt.setString(2, PricePO.getPrice(Express.special) + "");
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
