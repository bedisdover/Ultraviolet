package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
		Map<String, Double> expressPrice = new HashMap<String, Double>();
		expressPrice.put("economy", 0.0);
		expressPrice.put("standard", 0.0);
		expressPrice.put("special", 0.0);
		
		//创建并初始化包装类型价格表
		Map<String, Double> packagePrice = new HashMap<String, Double>();
		packagePrice.put("Carton", 0.0);
		packagePrice.put("Wooden", 0.0);
		packagePrice.put("Bag", 0.0);
		packagePrice.put("Other", 0.0);
		
		String sql = "SELECT * FROM price";

		ResultSet result = null;
		result = connect.getResultSet(sql);
		
		try {
			//TODO 价格类型判断
			while (result.next()) {
				if (expressPrice.containsKey(result.getString(1))) {
					expressPrice.put(result.getString(1), result.getDouble(2));
				} else if (packagePrice.containsKey(result.getString(1))) {
					packagePrice.put(result.getString(1), result.getDouble(2));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connect.closeConnection();
		HashMap<Express, Double> express = new HashMap<Express, Double>();
		express.put(Express.economy, expressPrice.get("economy"));
		express.put(Express.standard, expressPrice.get("standard"));
		express.put(Express.special, expressPrice.get("special"));
		
		//创建并初始化包装类型价格表
		HashMap<Packing, Double> pack = new HashMap<Packing, Double>();
		pack.put(Packing.Carton,packagePrice.get("Carton"));
		pack.put(Packing.Wooden, packagePrice.get("Wooden"));
		pack.put(Packing.Bag, packagePrice.get("Bag"));
		pack.put(Packing.Other, packagePrice.get("Other"));
		pricePO.setExpressPrice(express);
		pricePO.setPackagePrice(pack);
		
		return pricePO;
	}

	public void pricing(PricePO price) throws RemoteException {

		connect = new Connect();
		String sql = "INSERT INTO price(type, price) VALUES (?, ?)";
		this.makeEmpty();
		
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
	
	private void makeEmpty() throws RemoteException{
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
	public static void main(String[] args) {
		PriceData priceData=null;
		
		PricePO pricePO=new PricePO();
		try {
			priceData = new PriceData();
			pricePO = priceData.getPrice();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		try {
			PricePO p=new PricePO();
			p.pricing(Express.economy, 18.0);
			p.pricing(Express.standard, 23.0);
			p.pricing(Express.special, 25.0);
			
			p.pricing(Packing.Carton, 5.0);
			p.pricing(Packing.Wooden, 10.0);
			p.pricing(Packing.Bag, 1.0);
			p.pricing(Packing.Other, 0.0);
			priceData.pricing(p);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println(pricePO.getPrice(Express.economy));
		System.out.println(pricePO.getPrice(Express.standard));
		System.out.println(pricePO.getPrice(Express.special));
		
		System.out.println(pricePO.getPrice(Packing.Bag));
		System.out.println(pricePO.getPrice(Packing.Carton));
		System.out.println(pricePO.getPrice(Packing.Wooden));
		System.out.println(pricePO.getPrice(Packing.Other));
	}
}
