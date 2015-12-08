package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.Packing;

/**
 * @author 宋益明
 * 
 * Order包数据
 */
public class OrderData extends UnicastRemoteObject implements OrderDataService {

	/**
	 */
	private static final long serialVersionUID = 1L;

	private Connect connect;
	
	public OrderData() throws RemoteException {
		super();
		
		connect = new Connect();
	}

	
	public OrderPO find(String id) throws RemoteException {
		//TODO 待检验
		String sql = "SELECT * FROME order WHERE id = " + id;
		
		ResultSet result = connect.getResultSet(sql);
		
		OrderPO orderPO = new OrderPO();
		
		try {
			//设置寄件人信息
			orderPO.setSenderName(result.getString(2));
			orderPO.setSenderPhone(result.getString(3));
			orderPO.setSenderAddress(result.getString(4));
			//设置收件人信息
			orderPO.setReceiverName(result.getString(5));
			orderPO.setReceiverPhone(result.getString(6));
			orderPO.setReceiverAddress(result.getString(7));
			//设置货物信息
			orderPO.setName(result.getString(8));
			orderPO.setExpressType(Express.valueOf(result.getString(9)));
			orderPO.setPackageType(Packing.valueOf(result.getString(10)));
			orderPO.setAmount(result.getDouble(11));
			orderPO.setQuantity(result.getInt(12));
			orderPO.setWeight(result.getDouble(13));
			orderPO.setVolumn(result.getDouble(14));
			orderPO.setTime(result.getString(15));
			//设置实际收件人
			orderPO.setReceiver(result.getString(16));
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderPO;
	}

	public void insert(OrderPO orderPO) throws RemoteException {
		
		String sql = "INSERT INTO dingdan VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, orderPO.getId());
			pstmt.setString(2, orderPO.getSenderName());
			pstmt.setString(3, orderPO.getSenderPhone());
			pstmt.setString(4, orderPO.getSenderAddress());
			
			pstmt.setString(5, orderPO.getReceiverName());
			pstmt.setString(6, orderPO.getReceiverPhone());
			pstmt.setString(7, orderPO.getReceiverAddress());
			
			pstmt.setString(8, orderPO.getName());
			pstmt.setString(9,  orderPO.getExpressType()+"");
			pstmt.setString(10,  orderPO.getPackageType()+"");
			pstmt.setDouble(11, orderPO.getAmount());
			pstmt.setInt(12, orderPO.getQuantity());
			pstmt.setDouble(13, orderPO.getWeight());
			pstmt.setDouble(14, orderPO.getVolumn());
			pstmt.setString(15, orderPO.getTime());
			//实际收件人
			pstmt.setString(16, orderPO.getReceiver());
			
			pstmt.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(OrderPO po) throws RemoteException {
		String sql = "DELETE FROM dingdan WHERE id = " + po.getId();
		
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		
		try {
			pstmt.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(OrderPO po) throws RemoteException {
		// TODO 待检验
		this.delete(po);
		this.insert(po);
	}
	
	@Override
	public ArrayList<String> findAll(String institution) throws RemoteException {
		ArrayList<String> orders = new ArrayList<String>();
		
		String sql = "SELECT * FROM dingdan";
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			while (result.next()) {
				if (result.getString(1).substring(0, 3).equals(institution)) {
					orders.add(result.getString(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public String createID(String institution) throws RemoteException {
		String id = "";
		
		ArrayList<String> orders = this.findAll(institution);
		
		if (orders.isEmpty()) {
			id = institution + "0000001";
			return id;
		}
		
		for (String string : orders) {
			if (string.compareTo(id) > 0) {
				id = string;
			}
		}
		
		id = Long.parseLong(id) + 1 + "";
		
		return id;
	}
	
	public static void main(String[] args){
		OrderPO opo=new OrderPO();
		opo.setId("1111100000");
		opo.setSenderName("tt");
		opo.setSenderPhone("123455");
		opo.setSenderAddress("5555");
		opo.setReceiverName("ttg");
		opo.setReceiverPhone("tt");
		opo.setReceiverAddress("tt");
		opo.setName("re");
		opo.setExpressType(Express.economy);
		opo.setPackageType(Packing.Bag);
		opo.setAmount(1.1);
		opo.setQuantity(2);
		opo.setWeight(3.1);
		opo.setVolumn(5.3);
		opo.setTime("10");
		try {
			OrderData od=new OrderData();
			od.insert(opo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
