package LEMS.po.orderpo;

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
	Landway//汽车
, YetToKnow
}
