package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.IncomeBillPO;

public interface ReceiptRecordDataService extends Remote {
	public IncomeBillPO find(String id) throws RemoteException;
	
	public void insert(IncomeBillPO incomeBillPO) throws RemoteException;
	
	public void update(IncomeBillPO incomeBillPO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	/**
	 * 在数据库中查找指定机构最新的记录，并直接生成ID
	 * @param date 日期
	 * @param institution 机构
	 * 
	 * @return 记录ID
	 */
	public String createID(String institution, String date) throws RemoteException;
}
