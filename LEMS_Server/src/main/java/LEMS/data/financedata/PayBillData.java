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
import LEMS.dataservice.financedataservice.PayBillDataService;
import LEMS.po.financepo.IncomeBillPO;
import LEMS.po.financepo.PayBillPO;

@SuppressWarnings("serial")
public class PayBillData extends UnicastRemoteObject implements PayBillDataService {

	public PayBillData() throws RemoteException {
		super();
	}

	public ArrayList<PayBillPO> getPayBill(String start, String end) throws RemoteException {
		ArrayList<PayBillPO> pa=new ArrayList<PayBillPO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql="SELECT date,institution,amount,payer,account,item,remark FROM paybill";
		try {
			Class.forName(Connect.DBDRIVER);
			conn = DriverManager.getConnection(Connect.DBURL, Connect.DBUSER, Connect.DBPASS);
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			while (result.next()) {
				pa.add(new PayBillPO(result.getString(1),result.getString(2),result.getDouble(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7)));
			}
			result.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pa;
	}

}
