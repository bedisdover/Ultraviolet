package LEMS.dataservice.financedataservice;

import java.rmi.RemoteException;

import LEMS.po.financepo.PricePO;

/**
 * @author 宋益明
 * 
 * 价格数据接口
 */
public interface PriceDataService {
	
	/**
	 * 获得价格持久化对象
	 * 
	 * @return 价格持久化对象
	 */
	public PricePO getPrice() throws RemoteException;
	
	/**
	 * 存储更改后的价格
	 * 
	 * @param pricePO 价格持久化对象
	 */
	public void pricing(PricePO pricePO) throws RemoteException;
}
