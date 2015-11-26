package LEMS.data.informationdata;

import java.rmi.RemoteException;
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
public class InformationDeleteData implements InformationDeleteDataService{
	public void deleteDriverPO(long id) throws RemoteException{
		
	}
	public void deleteVehiclePO(long id) throws RemoteException{
		
	}
	public void deleteInstitutionPO(String id) throws RemoteException{
		
	}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteAccountPO(String name) throws RemoteException{
		
	}	
}
