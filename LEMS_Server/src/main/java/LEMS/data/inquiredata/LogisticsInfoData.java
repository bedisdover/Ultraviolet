package LEMS.data.inquiredata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
		// TODO Auto-generated constructor stub
	}

	public LogisticsInfoPO findLogisticsInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
