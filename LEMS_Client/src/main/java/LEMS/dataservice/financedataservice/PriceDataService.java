package LEMS.dataservice.financedataservice;

import LEMS.vo.ordervo.Express;

/**
 * @author 宋益明
 * 
 * 价格数据接口
 */
public interface PriceDataService {
	
	/**
	 * 获得指定类型快递的价格
	 * 
	 * @param type 快递类型
	 * @return 价格
	 */
	public double getPrice(Express type);
	
	/**
	 * 更改指定类型快递的价格
	 * 
	 * @param type 快递类型
	 * @param price 价格
	 */
	public void pricing(Express type, double price);
}
