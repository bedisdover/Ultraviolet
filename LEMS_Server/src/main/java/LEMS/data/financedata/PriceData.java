package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import LEMS.data.Connect;
import LEMS.dataservice.financedataservice.PriceDataService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

@SuppressWarnings("serial")
public class PriceData extends UnicastRemoteObject implements PriceDataService {
	private PricePO pricePO;
	private Connect connect;
	
	public PriceData() throws RemoteException {
		super(); 
		
		connect = new Connect();
		pricePO= new PricePO();
	}

	public PricePO getPrice() throws RemoteException {
		// 创建并初始化快递类型价格表
		List<String> expressList = new ArrayList<String>();
		Express[] expresses = Express.values();
		for (int i = 0; i < expresses.length; i++) {
			expressList.add(expresses[i] + "");
		}
		
		//创建并初始化包装类型价格表
		List<String> packingList = new ArrayList<String>();
		Packing[] packings = Packing.values();
		for (int i = 0; i < packings.length; i++) {
			packingList.add(packings[i] + "");
		}
		
		HashMap<Express, Double> express = new HashMap<Express, Double>();		
		HashMap<Packing, Double> packing = new HashMap<Packing, Double>();
		
		String sql = "SELECT * FROM price";

		ResultSet result = null;
		result = connect.getResultSet(sql);
		
		try {
			//价格类型判断
			while (result.next()) {
				if (expressList.contains(result.getString(1))) {
					express.put(Express.valueOf(result.getString(1)), result.getDouble(2));
				} else if (packingList.contains(result.getString(1))) {
					packing.put(Packing.valueOf(result.getString(1)), result.getDouble(2));
				}
			}
			//断开数据库连接
			connect.closeConnection();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//更新价格	
		pricePO.setExpressPrice(express);
		pricePO.setPackagePrice(packing);
		
		return pricePO;
	}

	public void pricing(PricePO price) throws RemoteException {

		connect = new Connect();
		String sql = "INSERT INTO price(type, price) VALUES (?, ?)";
		this.delete();
		
		HashMap<Express, Double> expressPrice = price.getExpressPrice();
		HashMap<Packing, Double> packagePrice = price.getPackagePrice();
		
		Set<Entry<Express, Double>> expressEntry = expressPrice.entrySet();
		Set<Entry<Packing, Double>> packageEntry = packagePrice.entrySet();
		
		try {
			PreparedStatement pstmt = connect.getPreparedStatement(sql);
			//更新快递价格
			for (Entry<Express, Double> entry : expressEntry) {
				pstmt.setString(1, entry.getKey() + "");
				pstmt.setDouble(2, entry.getValue());
				pstmt.executeUpdate();
			}
			//更新包装价格
			for (Entry<Packing, Double> entry : packageEntry) {
				pstmt.setString(1, entry.getKey() + "");
				pstmt.setDouble(2, entry.getValue());
				pstmt.executeUpdate();
			}
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void delete() throws RemoteException{
		PreparedStatement pstmt = null;

		connect = new Connect();
		String sql = "DELETE FROM price";

		try {
			pstmt = connect.getPreparedStatement(sql);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		connect.closeConnection();
	}
}
