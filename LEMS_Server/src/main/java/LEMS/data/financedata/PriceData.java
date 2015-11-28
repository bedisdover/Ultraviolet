package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import LEMS.data.Connect;
import LEMS.dataservice.financedataservice.PriceDataService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;

public class PriceData implements PriceDataService {

	private PricePO pricePO;

	private Connect connect;

	public PricePO getPrice() throws RemoteException {
		// 创建并初始化快递类型价格表
		Map<String, Double> expressPrice = new HashMap<String, Double>();
		expressPrice.put("economy", 0.0);
		expressPrice.put("standard", 0.0);
		expressPrice.put("special", 0.0);
		
		String sql = "SELECT type, price FROM price";

		connect = new Connect();
		ResultSet result = null;
		result = connect.getResultSet(sql);
		
		try {
			while (result.next()) {
				if (expressPrice.containsKey(result.getString(1))) {
					expressPrice.put(result.getString(1), Double.parseDouble(result.getString(2)));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connect.closeConnection();
		return pricePO;
	}

	public void pricing(PricePO price) throws RemoteException {
		PreparedStatement pstmt = null;

		connect = new Connect();
		String sql = "INSERT INTO price(type, price) VALUES (?, ?)";

		try {
			pstmt = connect.getPreparedStatement(sql);

			// 存储快递类型“经济”的价格
			pstmt.setString(1, "economy");
			pstmt.setDouble(2, PricePO.getPrice(Express.economy));
			pstmt.executeUpdate();
			// 存储快递类型“普通”的价格
			pstmt.setString(1, "standard");
			pstmt.setDouble(2, PricePO.getPrice(Express.standard));
			pstmt.executeUpdate();
			// 存储快递类型“特快”的价格
			pstmt.setString(1, "special");
			pstmt.setDouble(2, PricePO.getPrice(Express.special));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		connect.closeConnection();
	}

}
