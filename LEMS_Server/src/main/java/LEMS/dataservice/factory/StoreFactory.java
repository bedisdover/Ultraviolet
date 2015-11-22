package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import LEMS.dataservice.storedataservice.GoodsDataService;

/**
 * @author 周梦佳
 *store模块的数据工厂
 */
public interface StoreFactory extends Remote{

	public GoodsDataService getGoodsData() throws RemoteException;
	
	/**
	 * 获得快递存放以及出入库数据
	 * 
	 * @return
	 
	 */
}
