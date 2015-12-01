package LEMS.data.orderdata;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.po.OrderPO2;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.Packing;

/**
 * @author 宋益明
 * 
 * Order包数据
 */
public class OrderData2 extends UnicastRemoteObject {

	/**
	 */
	private static final long serialVersionUID = 1L;

	private Connect connect;
	
	public OrderData2() throws RemoteException {
		super();
		
		connect = new Connect();
	}

	
	public OrderPO2 find(String id) throws RemoteException {
		//TODO 待检验
		String sql = "SELECT * FROME order WHERE id = " + id;
		
		ResultSet result = connect.getResultSet(sql);
		
		OrderPO2 orderPO = new OrderPO2();
		
		try {
			orderPO.setId(result.getString(1));
			orderPO = (OrderPO2) result.getObject(2);
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderPO;
	}

	public void insert(OrderPO2 po) throws RemoteException {
		
		String sql = "INSERT INTO order VALUES (?, ?)";
		
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		
		try {
			//为检索方便，单独存储ID
			pstmt.setString(1, po.getId());
			pstmt.setObject(2, po);
			pstmt.executeUpdate();
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	//测试OrderPO2的读写
	public static void main(String[] args) {
		OrderPO2 order = new OrderPO2();
		order.setId("1234567890");
		
		order.setSenderName("张三");
		order.setSenderPhone("13919111911");
		order.setSenderAddress("南京市仙林大道163号");
		order.setReceiverName("李四");
		order.setReceiverPhone("13919111911");
		order.setReceiverAddress("北京市中关村34号");
		
		order.setName("电风扇");
		order.setExpressType(Express.economy);
		order.setPackageType(Packing.Carton);
		order.setAmount(75.0);
		order.setQuantity(1);
		order.setWeight(2.4);
		order.setVolumn(9.2);
		order.setTime("我也不造啊！");
		
		OrderPO2 orderPO2 = new OrderPO2();
		try {
			OrderData2 orderData = new OrderData2();
			orderData.insert(order);
			orderPO2 = orderData.find("1234567890");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		//输出检验
		System.out.println(orderPO2.getName());
		System.out.println(orderPO2.getId());
		System.out.println(orderPO2.getSenderAddress());
		System.out.println(orderPO2.getReceiverAddress());
		System.out.println(orderPO2.getTime());
	}
}
