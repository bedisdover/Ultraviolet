package LEMS.po.orderpo;

import java.io.Serializable;

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
}
