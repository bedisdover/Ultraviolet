package LEMS.businesslogic.storebl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

	//public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/mldn";
	public static final String DBUSER = "root";
	public static final String DBPASS = "";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet result = null;

	public PreparedStatement getPreparedStatement(String sql) {

		try {
			Class.forName(Connect.DBDRIVER);
			conn = DriverManager.getConnection(Connect.DBURL, Connect.DBUSER, Connect.DBPASS);
			pstmt = conn.prepareStatement(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pstmt;
	}

	public ResultSet getResultSet(String sql) {
		
		try {
			pstmt = getPreparedStatement(sql);
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
public int doUpdate(String sql) {
	int a=0;	
		try {
			pstmt = getPreparedStatement(sql);
			a = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}


	public void closeConnection() {
		try {
			if (result != null) {
				result.close();
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
