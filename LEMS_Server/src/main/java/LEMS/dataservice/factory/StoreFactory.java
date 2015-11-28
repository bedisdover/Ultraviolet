package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.storedataservice.GoodsDataService;

public interface StoreFactory extends Remote{
	public GoodsDataService getGoodsData() throws RemoteException;
}
