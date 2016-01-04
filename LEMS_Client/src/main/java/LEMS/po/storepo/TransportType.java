package LEMS.po.storepo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author 宋益明
 * 
 * 运输方式
 * 包括飞机、火车、汽车
 */
public enum TransportType implements Serializable {
	Airplane,//飞机
	Railway,//火车
	Landway,//汽车
	YetToKnow
	;
	
	private static HashMap<TransportType, String> typeList;
	
	static {
		typeList = new HashMap<>();
		
		typeList.put(TransportType.Airplane, "飞机");
		typeList.put(TransportType.Railway, "火车");
		typeList.put(TransportType.Landway, "汽车");
		typeList.put(TransportType.YetToKnow, "");
	}
	
	public static TransportType transfer(String type) {
		switch (type) {
		case "飞机":
			return Airplane;
		case "火车":
			return Railway;
		case "汽车":
			return Landway;
		default:
			break;
		}
		
		return YetToKnow;
	}
	
	public static String Transfer(TransportType type) {
		return typeList.get(type);
	}
}
