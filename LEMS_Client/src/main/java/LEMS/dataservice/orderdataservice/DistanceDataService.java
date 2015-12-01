package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.DistancePO;

/**
 * @author 宋益明
 * 
 * 距离数据接口
 */
public interface DistanceDataService extends Remote {
	
	/**
	 * 获得城市间距离持久化对象 
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public DistancePO getDistance() throws RemoteException;
	
	/**
	 * 更新距离持久化对象
	 * 
	 * @param distancePO
	 * @throws RemoteException
	 */
	public void setDistance(DistancePO distancePO) throws RemoteException;
}
