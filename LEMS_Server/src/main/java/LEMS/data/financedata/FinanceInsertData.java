package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.financedataservice.FinanceInsertDataService;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.po.financepo.PayBillPO;

@SuppressWarnings("serial")
public class FinanceInsertData extends UnicastRemoteObject implements FinanceInsertDataService{

	/**
	 * 
	 */

	public FinanceInsertData() throws RemoteException {
		super();
	}

	public void insertCost(PayBillPO po) throws RemoteException {
		
		
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
