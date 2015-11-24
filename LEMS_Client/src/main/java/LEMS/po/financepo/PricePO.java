package LEMS.po.financepo;

import java.util.HashMap;

import LEMS.po.orderpo.Express;

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
	private static HashMap<Express, Double> priceList;
	
	//TODO 单例化，确保程序中只存在一个对象
	private PricePO() {
		priceList = new HashMap<Express, Double>();
		init();
	}
	
	//TODO 测试用初始化
	/**
	 * 初始化价格持久化对象
	 */
	private static void init() {
		priceList.put(Express.economy, 18.0);
		priceList.put(Express.standard, 23.0);
		priceList.put(Express.special, 25.0);
	}
	
	public static void pricing(Express type, double price) {
		priceList.put(type, price);
	}

	public static double getPrice(Express type) {
		return priceList.get(type);
	}
}
