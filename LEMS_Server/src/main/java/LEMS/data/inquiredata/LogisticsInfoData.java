package LEMS.data.inquiredata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;
import LEMS.po.inquirepo.LogisticsInfoPO;

/**
 * @author 章承尧
 * LogisticsInfoDataService的实现
 */
@SuppressWarnings("serial")
public class LogisticsInfoData extends UnicastRemoteObject implements LogisticsInfoDataService {

	public  LogisticsInfoData() throws RemoteException {
		super();
	}
	
	//更新物流信息
	public void update(LogisticsInfoPO lpo) throws RemoteException {
		this.deleteLogisticsInfo(lpo.getId());
		this.insertLogisticsInfo(lpo);
	}
	
	//根据id查找对应订单的物流信息
	public LogisticsInfoPO findLogisticsInfo(String id) throws RemoteException {
		LogisticsInfoPO lipo=null;
		ArrayList<String> trace=new ArrayList<String>();
		Connect co=new Connect();
		String sql="SELECT id,trace FROM logistics";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					String[] str=result.getString(2).split(" ");
					int i=0;
					for(;i<str.length;i++){
						trace.add(str[i]);
					}
					lipo=new LogisticsInfoPO(id,trace);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		co.closeConnection();
		return lipo;
	}
	
	//删除某个订单的物流信息
	public void deleteLogisticsInfo(String id) throws RemoteException{
		Connect co=new Connect();
		String sql="DELETE FROM logistics WHERE id = ?";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//插入一条物流信息
	public void insertLogisticsInfo(LogisticsInfoPO lpo) throws RemoteException{
		String trace="";
		for(int i=0;i<lpo.getTrace().size();i++){
			trace+=(lpo.getTrace().get(i)+" ");
		}
		Connect co=new Connect();
		String sql="INSERT INTO logistics VALUES (?,?,?)";
		PreparedStatement pstmt=co.getPreparedStatement(sql);
		try {
			pstmt.setString(1,lpo.getId());
			pstmt.setString(2,trace);
			pstmt.setString(3, lpo.getInstitution());
			pstmt.executeUpdate();
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
