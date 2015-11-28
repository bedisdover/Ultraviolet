package LEMS.po.financepo;

import java.util.HashMap;

import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

/**
 * @author 宋益明
 *
 * 价格持久化对象
 * 单例化静态对象PricePO
 * 调用者LEMS.businesslogic.financebl.Price
 * 调用者LEMS.businesslogic.orderbl.Order
 */
public class PricePO {
	
	/**
	 * 全局静态变量
	 */
	public static PricePO pricePO;
	/**
	 * 用于记录不同快递类型价格
	 */
	private static HashMap<Express, Double> expressPrice;
	/**
	 * 用于记录不同包装类型价格
	 */
	private static HashMap<Packing, Double> packagePrice;
	
	private PricePO() {
	}
	
	static {
		//TODO 测试用初始化
		pricePO = new PricePO();
		
		expressPrice = new HashMap<Express, Double>();
		packagePrice = new HashMap<Packing, Double>();
		
//		expressPrice.put(Express.economy, 0.0);
//		expressPrice.put(Express.standard, 23.0);
//		expressPrice.put(Express.special, 25.0);
//		
//		packagePrice.put(Packing.Carton, 5.0);
//		packagePrice.put(Packing.Wooden, 10.0);
//		packagePrice.put(Packing.Bag, 1.0);
//		packagePrice.put(Packing.Other, 0.0);
	}
	
	public static void pricing(Express type, double price) {
		expressPrice.put(type, price);
		
	}

	public static void pricing(Packing type, double price) {
		packagePrice.put(type, price);
	}
	
	public static double getPrice(Express type) {
		return expressPrice.get(type);
	}
	
	public static double getPrice(Packing type) {
		return packagePrice.get(type);
	}

	public static void setExpressPrice(HashMap<Express, Double> expressPrice) {
		PricePO.expressPrice = expressPrice;
	}

	public static void setPackagePrice(HashMap<Packing, Double> packagePrice) {
		PricePO.packagePrice = packagePrice;
	}
}
