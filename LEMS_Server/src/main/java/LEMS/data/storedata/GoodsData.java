package LEMS.data.storedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.dataservice.storedataservice.GoodsDataService;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.GoodsPO;
import LEMS.po.userpo.UserPO;

@SuppressWarnings("serial")
public class GoodsData extends UnicastRemoteObject implements GoodsDataService {

	public GoodsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/mldn";
	public static final String DBUSER = "root";
	public static final String DBPASS = "admin";

	public void getStoreDatabase(GoodsPO goodsPO) throws RemoteException {

	}

	public ArrayList find(String id){
		ArrayList al=new  ArrayList(); 
		Connection conn=null;
		PreparedStatement pstmt = null; 
		ResultSet result=null;
		String sql="SELECT id,inDate,outDate,destination,area,row,stand,position,transportType,transferNum FROM goods";
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			result=pstmt.executeQuery();
			while(result.next()){
				if(result.getString("id").equals(id)){
					al.add(result.getString("id"));
					al.add(result.getString("inDate"));
					al.add(result.getString("outDate"));
					al.add(result.getString("destination"));
					al.add(result.getString("area"));
					al.add(result.getString("row"));
					al.add(result.getString("stand"));
					al.add(result.getString("position"));
					al.add(result.getString("transportType"));
					al.add(result.getString("transferNum"));
					
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
		return al;
	}

	public void insert(GoodsPO goodsPO){
		System.out.println("Insert succeed!");
	}

	public void delete(GoodsPO goodsPO){
		System.out.println("Delete succeed!");
	}

	public void update(GoodsPO goodsPO){
		System.out.println("Update succeed!");
	}

	public void init(){
		System.out.println("Initialization succeed!");
	}

	public void finish() {
		System.out.println("end!");
	}

	public GoodsPO find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
