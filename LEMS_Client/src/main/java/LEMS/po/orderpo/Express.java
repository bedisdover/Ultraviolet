package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author 宋益明
 * 快递类型:经济、标准、特快
 */
public enum Express implements Serializable {
	economy,//经济
	standard,//标准
	special//特快
	;
	
	private static HashMap<String, Express> typeList = new HashMap<>();
	
	static {
		typeList.put("经济", Express.economy);
		typeList.put("标准", Express.standard);
		typeList.put("特快", Express.special);
	}
	
	/**
	 * 将快递类型的中文转换为对应的快递类型
	 */
	public static Express transfer(String type) {
		return typeList.get(type);
	}
}
