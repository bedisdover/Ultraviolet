package LEMS.businesslogicservice.financeblservice;

import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

/**
 * @author 宋益明
 * 
 * 制定价格任务接口
 */
public interface PriceService {
	/**
	 * 获取指定类型快递的价格
	 * 
	 * @param type 快递类型
	 * @return 快递价格
	 */
	public double getPrice(Express type);
	
	/**
	 * 获取制定包装类型的价格
	 * 
	 * @param type 包装类型
	 * @return 包装价格
	 */
	public double getPrice(Packing type);
	
	/**
	 * 制定快递价格
	 * 
	 * @param type 快递类型
	 * @param price 价格
	 */
	public void pricing(Express type, double price);
	
	/**
	 * 制定包装价格
	 * 
	 * @param type 包装类型
	 * @param price 价格
	 */
	public void pricing(Packing type, double price);
}
