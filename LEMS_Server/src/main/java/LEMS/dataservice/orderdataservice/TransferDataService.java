package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.TransferNotePO;

public interface TransferDataService extends Remote {
	public TransferNotePO find(String id) throws RemoteException;
	
	public void insert(TransferNotePO transferNotePO) throws RemoteException;
	
	public void update(TransferNotePO transferNotePO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	/*
	 * 根据数据库中已存在的订单ID，生成新的中转单ID
	 */
	public String createID(String institution, String date) throws RemoteException;
}
