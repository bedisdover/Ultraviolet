package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.financedataservice.FinanceDeleteDataService;

@SuppressWarnings("serial")
public class FinanceDeleteData extends UnicastRemoteObject implements FinanceDeleteDataService{
	
	public FinanceDeleteData() throws RemoteException {
		super();
	}

	public void deleteCost(String id) throws RemoteException {
		System.out.println("从数据库删除付款单~~~");
		Connect co=new Connect();
		String sql="DELETE FROM cost WHERE id = ?";
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
