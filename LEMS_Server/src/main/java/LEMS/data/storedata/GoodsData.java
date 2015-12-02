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
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.GoodsPO;
import LEMS.po.storepo.TransportType;


@SuppressWarnings("serial")
public class GoodsData extends UnicastRemoteObject implements GoodsDataService {

	public GoodsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/mldn";
	public static final String DBUSER = "root";
	public static final String DBPASS = "";

	public void getStoreDatabase(GoodsPO goodsPO) throws RemoteException {

	}

	public ArrayList<String> find(String id){
		ArrayList<String> al=new  ArrayList<String>(); 
		Connection conn=null;
		PreparedStatement pstmt = null; 
		ResultSet result=null;
		String sql="SELECT id,inDate,outDate,destination,area,row,stand,position,transportType,transferNum FROM goods where id ='"+id+"'";
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			result=pstmt.executeQuery();
			while(result.next()){
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

	public int insert(GoodsPO goodsPO){
		int judge=0;
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
			judge=pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return judge;
	}

	public int delete(GoodsPO goodsPO){
		int judge=0;
		String idTarget=goodsPO.getId();
		Connection conn=null;
		PreparedStatement pstmt = null; 
		String sql="DELETE FROM goods WHERE id= '"+idTarget+"'";
		try {
			
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			judge=pstmt.executeUpdate();		//返回int类型 0不成功 大于0成功
				pstmt.close();
				conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return judge;
		
	}

	public int update(GoodsPO goodsPO){
		int judge=0;
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
		String sql="UPDATE goods set inDate=?,outDate=?,destination=?,area=?, row=?,"
				+ "stand=?,position=?,transportType=?,transferNum=? WHERE id=?";
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, goodsPO.getInDate());
			pstmt.setString(2, goodsPO.getOutDate());
			pstmt.setString(3, goodsPO.getDestination().name());
			pstmt.setString(4, goodsPO.getArea().name());
			pstmt.setString(5, goodsPO.getRow()+"");
			pstmt.setString(6, goodsPO.getStand()+"");
			pstmt.setString(7, goodsPO.getPosition()+"");
			pstmt.setString(8, goodsPO.getTransportType().name());
			pstmt.setString(9, goodsPO.getTransferNum()+"");
			pstmt.setString(10, goodsPO.getId()+"");
			
			judge=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return judge;
		
	}
		
	

	public void init(){
		
	}

	public void finish() {
		
	}
	
	


	public static void main(String[] args) throws RemoteException{
	GoodsPO g=new GoodsPO("10", "10", "10", Destination.Nanjing, Area.Airline, 1, 1, 1, TransportType.airplane, 11);
	GoodsData gd=new GoodsData();
	gd.delete(g);
	}

}
