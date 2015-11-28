package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 *
 * Order包数据接口
 */
public interface OrderDataService extends Remote {
	
	/**
	 * 按ID进行查找返回对应的OrderPO结果
	 */
	public OrderPO find(String id) throws RemoteException;
	
	/**
	 * 在数据库中插入一个po记录
	 */
	public void insert(OrderPO po) throws RemoteException;
	
	/**
	 * 在数据库中删除一个po
	 */
	public void delete(OrderPO po) throws RemoteException;
	
	/**
	 * 在数据库中更新一个po
	 */
	public void update(OrderPO po) throws RemoteException;
	
	/**
	 * 初始化持久化数据库
	 */
	public void init() throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 */
	public void finish() throws RemoteException;
}
