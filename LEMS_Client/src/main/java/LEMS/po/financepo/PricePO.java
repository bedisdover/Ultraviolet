package LEMS.po.financepo;

import java.util.HashMap;

import LEMS.vo.ordervo.Express;

/**
 * @author 宋益明
 *
 * 价格持久化对象
 */
public class PricePO {
	//TODO 静态数据类型
	/**
	 * 用于存储价格
	 *
	 */
	private static HashMap<Express, Double> price;
	
	//TODO 单例化，确保程序中值存在一个对象
	private PricePO() {
		price = new HashMap<Express, Double>();
		init();
	}
	
	/**
	 * 初始化价格持久化对象
	 */
	private static void init() {
		price.put(Express.economy, 15.0);
		price.put(Express.standard, 20.0);
		price.put(Express.special, 25.0);
	}

	public static HashMap<Express, Double> getPrice() {
		return price;
	}
}
