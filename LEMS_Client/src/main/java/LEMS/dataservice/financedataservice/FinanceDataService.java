package LEMS.dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.financepo.FinancePO;

/**
 * @author 宋益明
 * 
 * Finance包数据接口
 */
public interface FinanceDataService extends Remote{
	
	/**
	 * 按ID进行查找返回对应的FinancePO结果
	 */
	public FinancePO find(long id) throws RemoteException;
	
	/**
	 * 在数据库中插入一个po记录
	 */
	public void insert(FinancePO po) throws RemoteException;
	
	/**
	 * 在数据库中删除一个po记录
	 */
	public void delete(FinancePO po) throws RemoteException;
	
	/**
	 * 更新一个po
	 */
	public void update(FinancePO po) throws RemoteException;
	
	/**
	 * 初始化持久化数据库
	 */
	public void init() throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 */
	public void finish() throws RemoteException;
}
