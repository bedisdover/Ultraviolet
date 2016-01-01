package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.dataservice.financedataservice.IncomeBillDataService;
import LEMS.po.financepo.IncomeBillPO;

@SuppressWarnings("serial")
public class IncomeBillData extends UnicastRemoteObject implements IncomeBillDataService {

	public IncomeBillData() throws RemoteException {
		super();
	}

	//从数据库中读出所有的收款单
	public ArrayList<IncomeBillPO> getIncomeBill() throws RemoteException {
		ArrayList<IncomeBillPO> in=new ArrayList<IncomeBillPO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql="SELECT date,institution,amount,account FROM incomebill";
		try {
			Class.forName(Connect.DBDRIVER);
			conn = DriverManager.getConnection(Connect.DBURL, Connect.DBUSER, Connect.DBPASS);
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			while (result.next()) {
				in.add(new IncomeBillPO(result.getString(1),result.getString(2),result.getDouble(3),result.getString(4)));
			}
			result.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return in;
	}

	@Override
	public void addIncomeBill(IncomeBillPO incomeBillPO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<IncomeBillPO> getIncomeByDateAndIns(String date, String institution) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
