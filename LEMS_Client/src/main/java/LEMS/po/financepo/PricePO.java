package LEMS.po.financepo;

import java.util.HashMap;

import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

/**
 * @author 宋益明
 *
 * 价格持久化对象
 */
public class PricePO {
	/**
	 * 用于记录不同快递类型价格
	 */
	private static HashMap<Express, Double> expressPrice;
	/**
	 * 用于记录不同包装类型价格
	 */
	private static HashMap<Packing, Double> packagePrice;
	
	private PricePO() {
		expressPrice = new HashMap<Express, Double>();
		packagePrice = new HashMap<Packing, Double>();
		
		init();
	}
	
	/**
	 * 初始化价格持久化对象
	 */
	private void init() {
		//TODO 测试用初始化
		expressPrice.put(Express.economy, 18.0);
		expressPrice.put(Express.standard, 23.0);
		expressPrice.put(Express.special, 25.0);
		
		packagePrice.put(Packing.Carton, 5.0);
		packagePrice.put(Packing.Wooden, 10.0);
		packagePrice.put(Packing.Bag, 1.0);
		packagePrice.put(Packing.Other, 0.0);
	}
	
	public void pricing(Express type, double price) {
		expressPrice.put(type, price);
		
	}

	public void pricing(Packing type, double price) {
		packagePrice.put(type, price);
	}
	
	public static double getPrice(Express type) {
		return expressPrice.get(type);
	}
	
	public static double getPrice(Packing type) {
		return packagePrice.get(type);
	}

	public void setExpressPrice(HashMap<Express, Double> expressPrice) {
		PricePO.expressPrice = expressPrice;
	}

	public void setPackagePrice(HashMap<Packing, Double> packagePrice) {
		PricePO.packagePrice = packagePrice;
	}
}
