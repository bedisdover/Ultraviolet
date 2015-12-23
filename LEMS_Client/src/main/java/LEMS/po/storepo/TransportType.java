package LEMS.po.storepo;

import java.io.Serializable;

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
	
	public static TransportType getType(String type) {
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
}
