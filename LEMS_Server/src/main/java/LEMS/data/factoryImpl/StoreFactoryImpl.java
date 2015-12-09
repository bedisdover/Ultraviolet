package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.storedata.GoodsData;
import LEMS.dataservice.factory.StoreFactory;
import LEMS.dataservice.storedataservice.GoodsDataService;


@SuppressWarnings("serial")
public class StoreFactoryImpl extends UnicastRemoteObject implements StoreFactory{
	public StoreFactoryImpl() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
	}
	
	//获得GoodsDataService的引用
	public GoodsDataService getGoodsData() throws RemoteException{
		GoodsDataService goods=new GoodsData();
		return (GoodsData)goods;
	}
}






