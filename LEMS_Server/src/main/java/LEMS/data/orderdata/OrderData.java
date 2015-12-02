package LEMS.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
//		String sql = "SELECT id, senderName, senderPhone, senderAddress, "
//					 + "receiverName, receiverPhone, receiverAddress, "
//					 + "name, quantity, weight, volumn, expressType, packageType, amount, time FROM order";
		//TODO 待检验
		String sql = "SELECT * FROME order WHERE id = " + id;
		
		ResultSet result = connect.getResultSet(sql);
		
		OrderPO orderPO = new OrderPO();
		
		try {
			orderPO.setSenderName(result.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
		// TODO 待检验
		String sql = "DELETE * FROM dingdan WHERE id = " + po.getId();
		
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(OrderPO po) throws RemoteException {
		// TODO 待检验
		String sql = "UPDATE * FROM dingdan WHERE id = " + po.getId();
		
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void init() throws RemoteException {
		// TODO 似乎没用的方法
		
	}

	public void finish() throws RemoteException {
		// TODO 似乎没用的方法
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
