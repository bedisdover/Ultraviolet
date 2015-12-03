package LEMS.data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

@SuppressWarnings("serial")
public class UserData extends UnicastRemoteObject implements UserDataService {
	public UserData() throws RemoteException {
		super();
	}

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/mldn";
	public static final String DBUSER = "root";
	public static final String DBPASS = "admin";

	public void insert(UserPO po) throws RemoteException {
		String userRole = "";
		switch (po.getRole()) {
		case Manager:
			userRole = "Manager";
			break;
		case GeneralManager:
			userRole = "GeneralManager";
			break;
		case StoreManager:
			userRole = "StoreManager";
			break;
		case BusinessClerk:
			userRole = "BusinessClerk";
			break;
		case TransferClerk:
			userRole = "TransferClerk";
			break;
		case Courier:
			userRole = "Courier";
			break;
		case FinanceClerk:
			userRole = "FinanceClerk";
			break;
		default:
			break;
		}
		InstitutionPO ipo = po.getInstitution();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO user(id,password,role,name,institutionid,institutionlocation) VALUES (?,?,?,?,?,?) ";
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, po.getId());
			pstmt.setString(2, po.getPassword());
			pstmt.setString(3, userRole);
			pstmt.setString(4, po.getName());
			pstmt.setString(5, ipo.getID());
			pstmt.setString(6, ipo.getLocation());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(UserPO po) throws RemoteException {

	}

	public void update(UserPO po) throws RemoteException {

	}

	public ArrayList<UserPO> find(UserRole r) throws RemoteException {
		ArrayList<UserPO> ua = new ArrayList<UserPO>();
		String userRole = "";
		switch (r) {
		case Manager:
			userRole = "Manager";
			break;
		case GeneralManager:
			userRole = "GeneralManager";
			break;
		case StoreManager:
			userRole = "StoreManager";
			break;
		case BusinessClerk:
			userRole = "BusinessClerk";
			break;
		case TransferClerk:
			userRole = "TransferClerk";
			break;
		case Courier:
			userRole = "Courier";
			break;
		case FinanceClerk:
			userRole = "FinanceClerk";
			break;
		default:
			break;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "SELECT id,password,role,name,institutionid,institutionlocation FROM user";
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			while (result.next()) {
				if (result.getString(3).equals(userRole)) {
					InstitutionPO ipo = new InstitutionPO(result.getString(5),
							result.getString(6));
					UserPO upo = new UserPO(result.getString(1),
							result.getString(2), r, result.getString(4), ipo);
					ua.add(upo);
				}
			}
			result.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ua;
	}

	public ArrayList<UserPO> findAll() throws RemoteException {
		ArrayList<UserPO> upos=new ArrayList<UserPO>();
		UserRole userRole=null;
		Connect co=new Connect();
		String sql="SELECT * FROM user";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				String role=result.getString(3);
				switch (role) {
				case "Manager":
					userRole = UserRole.Manager;
					break;
				case "GeneralManager":
					userRole = UserRole.GeneralManager;
					break;
				case "StoreManager":
					userRole = UserRole.StoreManager;
					break;
				case "BusinessClerk":
					userRole = UserRole.BusinessClerk;
					break;
				case "TransferClerk":
					userRole = UserRole.TransferClerk;
					break;
				case "Courier":
					userRole = UserRole.Courier;
					break;
				case "FinanceClerk":
					userRole = UserRole.FinanceClerk;
					break;
				default:
					break;
				}
				InstitutionPO ipo = new InstitutionPO(result.getString(5),result.getString(6));
				UserPO upo = new UserPO(result.getString(1),result.getString(2), userRole, result.getString(4), ipo);
				upos.add(upo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return upos;
	}

	

}