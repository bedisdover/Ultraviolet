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
import LEMS.po.financepo.PayBillPO;

@SuppressWarnings("serial")
public class PayBillData extends UnicastRemoteObject implements PayBillDataService {

	public PayBillData() throws RemoteException {
		super();
	}

	//从数据库中读出所有付款单
	public ArrayList<PayBillPO> getPayBill() throws RemoteException {
		ArrayList<PayBillPO> pa=new ArrayList<PayBillPO>();
		Connect co=new Connect();
		String sql="SELECT * FROM paybill";
		ResultSet result = co.getResultSet(sql);
		try {
			while (result.next()) {
				pa.add(new PayBillPO(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8)));
			}
			co.closeConnection();;

		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return pa;
	}
	
	public void setPayBill(PayBillPO po) throws RemoteException{
		Connect co=new Connect();
		String sql="INSERT INTO payBill VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1,po.getDate());
			pstmt.setString(2,po.getId());
			pstmt.setString(3,po.getInstitution());
			pstmt.setString(4,po.getAmount()+"");
			pstmt.setString(5,po.getPayer());
			pstmt.setString(6,po.getAccount());
			pstmt.setString(7,po.getItem());
			pstmt.setString(8,po.getRemark());
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
