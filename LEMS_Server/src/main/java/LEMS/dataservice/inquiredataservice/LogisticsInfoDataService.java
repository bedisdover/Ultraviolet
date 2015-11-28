package LEMS.dataservice.inquiredataservice;

import java.rmi.RemoteException;

import LEMS.po.inquirepo.LogisticsInfoPO;

/**
 * @author 章承尧
 * 物流信息数据层接口
 */
public interface LogisticsInfoDataService {
	public LogisticsInfoPO findLogisticsInfo(String id) throws RemoteException;
}
