package LEMS.po.orderpo;

import java.io.Serializable;

/**
 * @author 宋益明
 * 快递类型:经济、标准、特快
 * 若发生更改，需同时更改expressType
 */
public enum Express implements Serializable {
	economy,//经济
	standard,//标准
	special//特快
}
