package LEMS.data.informationdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;

/**
 * @author 苏琰梓
 * InformationInsert包数据
 * 2015年10月26日
 */
@SuppressWarnings("serial")
public class InformationInsertData extends UnicastRemoteObject implements InformationInsertDataService{

	public InformationInsertData() throws RemoteException {
		super();
	}
	public void insert(DriverPO po) throws RemoteException{
		Connect co=new Connect();
		String sql="INSERT INTO driver VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1,po.getId());
			pstmt.setString(2,po.getName());
			pstmt.setString(3,po.getDateOfBirth());
			pstmt.setString(4,po.getIDcardNumber());
			pstmt.setString(5,po.getPhoneNumber());
			pstmt.setString(6,po.getDrivingPeriod());
			pstmt.setString(7,po.getGender()+"");
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(VehiclePO po) throws RemoteException{
		
	}
	public void insert(InstitutionPO po) throws RemoteException{
		Connect co=new Connect();
		String sql="INSERT INTO institution VALUES (?,?) ";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1,po.getID());
			pstmt.setString(2,po.getLocation());			
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(UserPO po) throws RemoteException{
		String userRole="";
		switch(po.getRole()){
		case Manager:userRole="Manager";break;
		case GeneralManager:userRole="GeneralManager";break;
		case StoreManager:userRole="StoreManager";break;
		case BusinessClerk:userRole="BusinessClerk";break;
		case TransferClerk:userRole="TransferClerk";break;
		case Courier:userRole="Courier";break;
		case FinanceClerk:userRole="FinanceClerk";break;
		default:break;
		}
		InstitutionPO ipo=po.getInstitution();
		Connection conn=null;
		PreparedStatement pstmt = null; 
		String sql="INSERT INTO user(id,password,role,name,institutionid,institutionlocation) VALUES (?,?,?,?,?,?) ";
		try {
			Class.forName(Connect.DBDRIVER);
			conn = DriverManager.getConnection(Connect.DBURL, Connect.DBUSER, Connect.DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1,po.getId());
			pstmt.setString(2,po.getPassword());
			pstmt.setString(3,userRole);
			pstmt.setString(4,po.getName());
			pstmt.setString(5,ipo.getID());
			pstmt.setString(6,ipo.getLocation());
			pstmt.executeUpdate();
			pstmt.close() ;
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void insert(AccountPO po) throws RemoteException{
		
	}
	
	
}
