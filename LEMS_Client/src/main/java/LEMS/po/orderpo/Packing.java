package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author 宋益明
 * 
 * 货物包装类型
 */
public enum Packing implements Serializable {
	Carton, // 纸箱
	Wooden, // 木箱
	Bag, // 快递袋
	Other// 其它
	;
	
	private static HashMap<String, Packing> typeList = new HashMap<>();
	
	static {
		typeList.put("快递袋", Packing.Bag);
		typeList.put("纸箱", Packing.Carton);
		typeList.put("木箱", Packing.Wooden);
		typeList.put("其它", Packing.Other);
	}
	
	/**
	 * 将包装类型的中文转换为对应的包装类型
	 */
	public static Packing transfer(String type) {
		return typeList.get(type);
	}
}
