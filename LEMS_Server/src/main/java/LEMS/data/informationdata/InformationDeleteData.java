package LEMS.data.informationdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationDeleteDataService;

/**
 * @author 苏琰梓
 * InformationDelete包数据
 * 2015年10月26日
 */
@SuppressWarnings("serial")
public class InformationDeleteData extends UnicastRemoteObject implements InformationDeleteDataService{
	public InformationDeleteData() throws RemoteException {
		super();
	}
	
	//删除对应id的司机信息
	public void deleteDriver(String id) throws RemoteException{
		Connect co=new Connect();
		String sql="DELETE FROM driver WHERE id = ?";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//删除对应id的车辆信息
	public void deleteVehicle(String id) throws RemoteException{
		Connect co=new Connect();
		String sql="DELETE FROM vehicle WHERE id = ?";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//删除对应id的机构信息
	public void deleteInstitution(String id) throws RemoteException{
		Connect co=new Connect();
		String sql="DELETE FROM institution WHERE id = ?";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//删除对应id的人员信息
	public void deleteStaff(String id) throws RemoteException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="DELETE FROM user WHERE id = ?";
		try {
			Class.forName(Connect.DBDRIVER);
			conn = DriverManager.getConnection(Connect.DBURL, Connect.DBUSER, Connect.DBPASS);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//删除对应id的账户信息
	public void deleteAccount(String id) throws RemoteException{
		Connect co=new Connect();
		String sql="DELETE FROM account WHERE id = ?";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//删除对应id的人员薪水信息
	public void deleteSalary(String id) throws RemoteException {
		Connect co=new Connect();
		String sql="DELETE FROM salary WHERE id = ?";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
}
