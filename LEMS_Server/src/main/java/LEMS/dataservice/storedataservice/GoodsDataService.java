package LEMS.dataservice.storedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.storepo.GoodsPO;

public interface GoodsDataService extends Remote{

	public GoodsPO find(String id) throws RemoteException;
	
	public ArrayList<GoodsPO> find(String sTime,String eTime)throws RemoteException;
	
	public int insert(GoodsPO goodsPO)throws RemoteException;
	
	public int delete(String id)throws RemoteException;
	
	public int update(GoodsPO goodsPO)throws RemoteException;
	
	public void init()throws RemoteException;
	
	public void finish()throws RemoteException;
	

}
