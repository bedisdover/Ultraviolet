package LEMS.dataservice.informationdataservice;

import java.rmi.RemoteException;

/**
 * @author 苏琰梓
 * 结束持久化数据库的使用
 * 2015年10月26日
 */
public interface InformationFinishDataService {
	public void finish() throws RemoteException;
}
