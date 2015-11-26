package LEMS.data.informationdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.informationdataservice.InformationUpdateDataService;
import LEMS.po.userpo.UserPO;

/**
 * @author 苏琰梓
 * InformationUpdate包数据
 * 2015年10月26日
 */
@SuppressWarnings("serial")
public class InformationUpdateData extends UnicastRemoteObject implements InformationUpdateDataService{
	public InformationUpdateData() throws RemoteException {
		super();
	}
	public void updateDriverPO(long id) throws RemoteException{
		
	}
	public void updateVehiclePO(long id) throws RemoteException{
		
	}
	public void updateInstitutionPO(String id) throws RemoteException{
		
	}
	public void updateStaff(UserPO upo) throws RemoteException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="DELETE FROM user WHERE id = ?";
		try {
			Class.forName(Connect.DBDRIVER);
			conn = DriverManager.getConnection(Connect.DBURL, Connect.DBUSER, Connect.DBPASS);
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,id);
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
