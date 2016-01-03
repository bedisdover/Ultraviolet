package LEMS.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LEMS.init.GetIP;

public class Connect {
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://"+GetIP.IP+":3306/mldn";
	public static final String DBUSER = "root";
	public static final String DBPASS = "admin";

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
