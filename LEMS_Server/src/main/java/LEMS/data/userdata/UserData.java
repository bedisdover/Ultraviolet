package LEMS.data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;








import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

@SuppressWarnings("serial")
public class UserData extends UnicastRemoteObject implements UserDataService{
	public UserData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/mldn";
	public static final String DBUSER="root";
	public static final String DBPASS="admin";
	public void insert(UserPO po) throws RemoteException {
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
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getUserDatabase(UserPO po) throws RemoteException{
		
	}
	public void delete(UserPO po) throws RemoteException{
		
	}
	public void update(UserPO po) throws RemoteException{
		
	}
	public ArrayList<UserPO> find(UserRole r) throws RemoteException{
		ArrayList<UserPO> ua=new ArrayList<UserPO>();
		String userRole="";
		switch(r){
		case Manager:userRole="Manager";break;
		case GeneralManager:userRole="GeneralManager";break;
		case StoreManager:userRole="StoreManager";break;
		case BusinessClerk:userRole="BusinessClerk";break;
		case TransferClerk:userRole="TransferClerk";break;
		case Courier:userRole="Courier";break;
		case FinanceClerk:userRole="FinanceClerk";break;
		default:break;
		}
		Connection conn=null;
		PreparedStatement pstmt = null; 
		ResultSet result=null;
		String sql="SELECT id,password,role,name,institutionid,institutionlocation FROM user";
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			result=pstmt.executeQuery();
			while(result.next()){
				if(result.getString(3).equals(userRole)){
					InstitutionPO ipo=new InstitutionPO(result.getString(5),result.getString(6));
					UserPO upo=new UserPO(result.getString(1),result.getString(2),r,result.getString(4),ipo);
					ua.add(upo);
				}					
			}
			result.close();
				pstmt.close();
				conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ua;
	}
	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement pstmt = null; 
		ResultSet result=null;
		String sql="SELECT id,password,role,name,institutionid,institutionlocation FROM user";
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			result=pstmt.executeQuery();
			while(result.next()){
				String id=result.getString(1);
				String password=result.getString(2);
				String role=result.getString(3);
				String name=result.getString(4);
				String institutionid=result.getString(5);
				String institutionlocation=result.getString(6);
				System.out.println(id+" "+password+" "+role+" "+name+" "+institutionid+" "+institutionlocation);
				
				
			}
			result.close();
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

	
}