package LEMS.data.userdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






import LEMS.dataservice.userdataservice.UserDataService;
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
		// TODO Auto-generated method stub
		
	}

	public void getUserDatabase(UserPO po) throws RemoteException{
		
	}
	public void delete(UserPO po) throws RemoteException{
		
	}
	public void update(UserPO po) throws RemoteException{
		
	}
	public ArrayList<UserPO> find(UserRole r) throws RemoteException{
		ArrayList<UserPO> ua=new ArrayList<UserPO>();
		switch(r){
		case Manager:try {
				FileInputStream fi=new FileInputStream("Manager.ser");
				ObjectInputStream os=new ObjectInputStream(fi);
				while(fi.available()>0){
					UserPO user=(UserPO)os.readObject();
					ua.add(user);
				}
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case GeneralManager:try {
				FileInputStream fi=new FileInputStream("GeneralManager.ser");
				ObjectInputStream os=new ObjectInputStream(fi);
				while(fi.available()>0){
					UserPO user=(UserPO)os.readObject();
					ua.add(user);
				}
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case StoreManager:	try {
				FileInputStream fi=new FileInputStream("StoreManager.ser");
				ObjectInputStream os=new ObjectInputStream(fi);
				while(fi.available()>0){
					UserPO user=(UserPO)os.readObject();
					ua.add(user);
				}
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case BusinessClerk:	try {
				FileInputStream fi=new FileInputStream("BusinessClerk.ser");
				ObjectInputStream os=new ObjectInputStream(fi);
				while(fi.available()>0){
					UserPO user=(UserPO)os.readObject();
					ua.add(user);
				}
				os.close();
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case TransferClerk:try {
				FileInputStream fi=new FileInputStream("TransferClerk.ser");
				ObjectInputStream os=new ObjectInputStream(fi);
				while(fi.available()>0){
					UserPO user=(UserPO)os.readObject();
					ua.add(user);
				}
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case Courier:try {
				FileInputStream fi=new FileInputStream("Courier.ser");
				ObjectInputStream os=new ObjectInputStream(fi);
				while(fi.available()>0){
					UserPO user=(UserPO)os.readObject();
					ua.add(user);
				}
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case FinanceClerk:try {
				FileInputStream fi=new FileInputStream("FinanceClerk.ser");
				ObjectInputStream os=new ObjectInputStream(fi);
				while(fi.available()>0){
					UserPO user=(UserPO)os.readObject();
					ua.add(user);
				}
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:break;
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