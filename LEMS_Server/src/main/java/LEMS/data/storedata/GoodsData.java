package LEMS.data.storedata;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.GoodsPO;
import LEMS.po.storepo.TransportType;
import LEMS.data.Connect;
import LEMS.dataservice.storedataservice.GoodsDataService;

@SuppressWarnings("serial")
public class GoodsData extends UnicastRemoteObject implements GoodsDataService {

	private Connect connect;

	public GoodsData() throws RemoteException {
		super();
		connect = new Connect();
	}

	public void getStoreDatabase(GoodsPO goodsPO) throws RemoteException {

	}

	public GoodsPO find(String id) {
//		ArrayList<String> al = new ArrayList<String>();
//		String sql = "SELECT id,inDate,outDate,destination,area,row,stand,position,transportType,transferNum,money FROM goods where id ='"
//				+ id + "'";
		String sql = "SELECT id,inDate,outDate,destination,area,row,stand,position,transportType,transferNum,money FROM goods where id = "
				+ id ;
		ResultSet result = connect.getResultSet(sql);
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		GoodsPO goodsPO = new GoodsPO("", "", "", Destination.Beijing, Area.Airline, 1, 1, 1, TransportType.Airplane,
				"", 1);
		try {
			while (result.next()) {
				goodsPO.setId(result.getString(1));
				goodsPO.setInDate(result.getString(2));
				goodsPO.setOutDate(result.getString(3));
				goodsPO.setDestination(Destination.valueOf(result.getString(4))); 
				goodsPO.setArea(Area.valueOf(result.getString(5)));
				goodsPO.setRow(Integer.parseInt(result.getString(6)));
				goodsPO.setStand(Integer.parseInt(result.getString(7)));
				goodsPO.setPosition(Integer.parseInt(result.getString(8)));
				goodsPO.setTransportType(TransportType.valueOf(result.getString(9)));
				goodsPO.setTransferNum(result.getString(10));
				goodsPO.setMoney(Double.parseDouble(result.getString(11)));
				pstmt.executeUpdate();
				connect.closeConnection();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodsPO;
	}

	public ArrayList<GoodsPO> find(String startTime, String endTime) {

		ArrayList<GoodsPO> al = new ArrayList<GoodsPO>();

		String sql = "SELECT id,inDate,outDate,destination,area,row,stand,position,"
				+ "transportType,transferNum,money FROM goods where(  inDate <'"+endTime + "' )" + 
				"and (outDate > '" + startTime + "' )";
		ResultSet result = connect.getResultSet(sql);
//		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		
		try {
			while (result.next()) {
				GoodsPO goodsPO = new GoodsPO("", "", "", Destination.Beijing, Area.Airline, -1, -1, -1,
						TransportType.YetToKnow, "", -1);
				goodsPO.setId(result.getString(1));
				goodsPO.setInDate(result.getString(2));
				goodsPO.setOutDate(result.getString(3));
				goodsPO.setDestination(Destination.valueOf(result.getString(4))); // string to enum
				goodsPO.setArea(Area.valueOf(result.getString(5)));
				goodsPO.setRow(Integer.parseInt(result.getString(6)));
				goodsPO.setStand(Integer.parseInt(result.getString(7)));
				goodsPO.setPosition(Integer.parseInt(result.getString(8)));
				goodsPO.setTransportType(TransportType.valueOf(result.getString(9)));
				goodsPO.setTransferNum(result.getString(10));
				goodsPO.setMoney(Double.parseDouble(result.getString(11)));
				al.add(goodsPO);
			}
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;

	}

	public int insert(GoodsPO goodsPO) {
		int judge = 0;
		String sql = "INSERT INTO goods(id,inDate,outDate,destination,area,row,stand,position,transportType,transferNum,money) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
//		ResultSet result = connect.getResultSet(sql);
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		try {

			pstmt.setString(1, goodsPO.getId());
			pstmt.setString(2, goodsPO.getInDate());
			pstmt.setString(3, goodsPO.getOutDate());
			pstmt.setString(4, goodsPO.getDestination().name());
			pstmt.setString(5, goodsPO.getArea().name());
			pstmt.setString(6, goodsPO.getRow() + "");
			pstmt.setString(7, goodsPO.getStand() + "");
			pstmt.setString(8, goodsPO.getPosition() + "");
			pstmt.setString(9, goodsPO.getTransportType().name());
			pstmt.setString(10, goodsPO.getTransferNum() + "");
			pstmt.setString(11, goodsPO.getMoney() + "");
			judge = pstmt.executeUpdate();
			connect.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge;
	}

	public int delete(String id) {
		int judge = 0;
		String idTarget = id;
		String sql = "DELETE FROM goods WHERE id= '" + idTarget + "'";
//		ResultSet result = connect.getResultSet(sql);
		PreparedStatement pstmt = connect.getPreparedStatement(sql);
		try {
			judge = pstmt.executeUpdate(); // 返回int类型 0不成功 大于0成功
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge;

	}

	public int update(GoodsPO goodsPO) {
		int judge = 0;
		ArrayList<String> al = new ArrayList<String>();
		String idTarget = goodsPO.getId();
		String inDateTarget = goodsPO.getInDate();
		String outDateTarget = goodsPO.getOutDate();
		String destinationTarget = goodsPO.getDestination().name(); //enum to string
		String areaTarget = goodsPO.getArea().name();
		String rowTarget = goodsPO.getRow() + "";
		String standTarget = goodsPO.getStand() + "";
		String positionTarget = goodsPO.getPosition() + "";
		String transportTypeTarget = goodsPO.getTransportType().name();
		String transferNumTarget = goodsPO.getTransferNum() + "";
		String moneyTarget = goodsPO.getMoney() + "";
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
		al.add(moneyTarget);
		String sql = "UPDATE goods set inDate=?,outDate=?,destination=?,area=?, row=?,"
				+ "stand=?,position=?,transportType=?,transferNum=?,money=? WHERE id=?";
//		ResultSet result = connect.getResultSet(sql);
		PreparedStatement pstmt = null;
		pstmt = connect.getPreparedStatement(sql);
		try {
			pstmt.setString(1, goodsPO.getInDate());
			pstmt.setString(2, goodsPO.getOutDate());
			pstmt.setString(3, goodsPO.getDestination().name());
			pstmt.setString(4, goodsPO.getArea().name());
			pstmt.setString(5, goodsPO.getRow() + "");
			pstmt.setString(6, goodsPO.getStand() + "");
			pstmt.setString(7, goodsPO.getPosition() + "");
			pstmt.setString(8, goodsPO.getTransportType().name());
			pstmt.setString(9, goodsPO.getTransferNum() + "");
			pstmt.setString(10, goodsPO.getMoney() + "");
			pstmt.setString(11, goodsPO.getId() + "");
			judge = pstmt.executeUpdate();
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge;
	}

	public void init() {
	}

	public void finish() {
	}

	// public static void main(String[] args) throws RemoteException{
	// GoodsPO g=new GoodsPO("10", "10", "10", Destination.Nanjing,
	// Area.Airline, 1, 1, 1, TransportType.Airplane, "11");
	// GoodsData gd=new GoodsData();
	// gd.delete(g);
	// }

}