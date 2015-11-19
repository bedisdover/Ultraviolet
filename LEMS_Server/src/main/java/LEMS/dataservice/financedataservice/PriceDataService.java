package LEMS.dataservice.financedataservice;

import LEMS.po.financepo.PricePO;

/**
 * @author 宋益明
 * 
 * 价格数据接口
 */
public interface PriceDataService {
	
	//TODO 上次不需要的接口
//	/**
//	 * 获得指定类型快递的价格
//	 * 
//	 * @param type 快递类型
//	 * @return 价格
//	 */
//	public double getPrice(Express type);
//	
//	/**
//	 * 更改指定类型快递的价格
//	 * 
//	 * @param type 快递类型
//	 * @param price 价格
//	 */
//	public void pricing(Express type, double price);
	
	/**
	 * 获得价格持久化对象
	 * 
	 * @return 价格持久化对象
	 */
	public PricePO getPrice();
}
