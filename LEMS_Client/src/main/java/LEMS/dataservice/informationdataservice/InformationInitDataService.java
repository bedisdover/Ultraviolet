package LEMS.dataservice.informationdataservice;

import java.rmi.RemoteException;

/**
 * @author 苏琰梓
 * 初始化持久化数据库
 * 2015年10月26日
 */
public interface InformationInitDataService {
	public void init() throws RemoteException;
}
