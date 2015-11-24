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
				if(result.getString(1).equals(id)){
					al.add(result.getString(1));
					al.add(result.getString(2));
					al.add(result.getString(3));
					al.add(result.getString(4));
					al.add(result.getString(5));
					al.add(result.getString(6));
					al.add(result.getString(7));
					al.add(result.getString(8));
					al.add(result.getString(9));
					al.add(result.getString(10));
					
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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO goods(id,inDate,outDate,destination,area,row,stand,position,transportType,transferNum) VALUES (?,?,?,?,?,?,?,?,?,?) ";
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodsPO.getId());
			pstmt.setString(2, goodsPO.getInDate());
			pstmt.setString(3, goodsPO.getOutDate());
			pstmt.setString(4, goodsPO.getDestination().name());
			pstmt.setString(5, goodsPO.getArea().name());
			pstmt.setString(6, goodsPO.getRow()+"");
			pstmt.setString(7, goodsPO.getStand()+"");
			pstmt.setString(8, goodsPO.getPosition()+"");
			pstmt.setString(9, goodsPO.getTransportType().name());
			pstmt.setString(10, goodsPO.getTransferNum()+"");
			pstmt.executeUpdate();
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

	public void delete(GoodsPO goodsPO){
		String idTarget=goodsPO.getId();
		Connection conn=null;
		PreparedStatement pstmt = null; 
		ResultSet result=null;
		String sql="DELETE FROM goods WHRER id=idTarget";
		//可以这么写么 id=idTarget?
		try {
			
//			con = DBCon.getConn();
//			String sql = "delete from tb_employee where id=?";
//			pstmt = (PreparedStatement) con.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			int i = pstmt.executeUpdate();
//			if(i == 1)
//				result = true;
			
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			result=pstmt.executeQuery();
			while(result.next()){
				if(result.getString(1).equals(idTarget)){
					//不知道写啥 应该不用了吧。。。
					pstmt.setString(1, idTarget);
					pstmt.executeUpdate();
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
		
	}

	public void update(GoodsPO goodsPO){
		ArrayList<String> al=new ArrayList<String>();
		String idTarget=goodsPO.getId();
		String inDateTarget=goodsPO.getInDate();
		String outDateTarget=goodsPO.getOutDate();
		String destinationTarget=goodsPO.getDestination().name();		//change enum to string
		String areaTarget=goodsPO.getArea().name();
		String rowTarget=goodsPO.getRow()+"";
		String standTarget=goodsPO.getStand()+"";
		String positionTarget=goodsPO.getPosition()+"";
		String transportTypeTarget=goodsPO.getTransportType().name();
		String transferNumTarget=goodsPO.getTransferNum()+"";
		al.add(idTarget);
		al.add(inDateTarget);
		al.add(outDateTarget);
		al.add(destinationTarget);
		al.add(areaTarget);
		al.add(rowTarget);
		al.add(standTarget);
		al.add(positionTarget);
		al.add(transportTypeTarget);
		al.add(transferNumTarget);
		Connection conn=null;
		PreparedStatement pstmt = null; 
		ResultSet result=null;
		String sql="UPDATE goods set  WHRER id=idTarget";
	//这句话不知道怎么写。。。
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			result=pstmt.executeQuery();
			int i=1;
			while(result.next()){
				if(!result.getString(i).equals(al.get(i))){
					pstmt.setString(i, al.get(i));
					pstmt.executeUpdate();
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
		
	}
		
	

	public void init(){
		
	}

	public void finish() {
		
	}

	

}
