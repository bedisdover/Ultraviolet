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
	private static final long serialVersionUID = 1L;

	private Connect connect;
	
	/**
	 * ID长度
	 */
	private static final int ID_LENGTH = 10;
	
	public OrderData() throws RemoteException {
		super();
		
		connect = new Connect();
	}

	
	public OrderPO find(String id) throws RemoteException {
		//TODO 待检验
		String sql = "SELECT * FROM dingdan WHERE id = " + id;
		
		ResultSet result = connect.getResultSet(sql);

		OrderPO orderPO = new OrderPO();
		
		try {
			result.next();
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
		this.delete(po);
		this.insert(po);
	}
	
	@Override
	public ArrayList<String> findAll(String institution) throws RemoteException {
		//TODO 可能没用的方法
		return null;
	}

	@Override
	public String createID(String date) throws RemoteException {
		String id = new CreateID().createID("dingdan", ID_LENGTH, date);
		
		return id;
	}
	
	public static void main(String[] args){
		OrderPO opo=new OrderPO();
		opo.setId("1234567890");
		opo.setSenderName("章承尧");
		opo.setSenderPhone("12345511111");
		opo.setSenderAddress("南京市栖霞区123号");
		opo.setReceiverName("苏燕子");
		opo.setReceiverPhone("12345678901");
		opo.setReceiverAddress("上海市闵行区111号");
		opo.setName("笔记本电脑");
		opo.setExpressType(Express.economy);
		opo.setPackageType(Packing.Bag);
		opo.setAmount(1.1);
		opo.setQuantity(2);
		opo.setWeight(3.1);
		opo.setVolumn(5.3);
		opo.setReceiver("宋一鸣");
		opo.setTime("10");
		try {
			OrderData od=new OrderData();
//			od.insert(opo);
			OrderPO orderPO = od.find("1234567890");
			System.out.println(orderPO.getAmount());
			System.out.println(orderPO.getReceiver());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
