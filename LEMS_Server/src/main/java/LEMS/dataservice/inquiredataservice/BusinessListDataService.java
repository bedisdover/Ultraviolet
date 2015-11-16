package LEMS.dataservice.inquiredataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.inquirepo.BusinessListPO;

/**
 * @author 章承尧
 * 经营情况表数据层接口
 */
public interface BusinessListDataService extends Remote{
	public BusinessListPO findBusinessList(String startTime,String endTime) throws RemoteException;
}
