package LEMS.data.inquiredata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
	
}
