package LEMS.dataservice.inquiredataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.inquirepo.LogisticsInfoPO;

/**
 * @author 章承尧
 * 物流信息数据层接口
 */
public interface LogisticsInfoDataService extends Remote{
	public LogisticsInfoPO findLogisticsInfo(String id) throws RemoteException;
	public void update(LogisticsInfoPO lpo) throws RemoteException;
	public void deleteLogisticsInfo(String id) throws RemoteException;
	public void insertLogisticsInfo(LogisticsInfoPO lpo) throws RemoteException;
}
