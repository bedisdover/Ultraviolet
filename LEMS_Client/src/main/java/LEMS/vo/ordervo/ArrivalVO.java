package LEMS.vo.ordervo;

import java.util.ArrayList;


/**
 * @author 宋益明
 * 
 * 货物到达单值对象
 */
public class ArrivalVO {
	/**
	 * 货物到达日期
	 */
	private String date;
	/**
	 * 到达单编号
	 */
	private long id;
	/**
	 * 订单列表
	 */
	private ArrayList<Long> orders;
	
	public ArrivalVO(String date, long id, ArrayList<Long> orders) {
		this.date = date;
		this.id = id;
		this.orders = orders;
	}

	public String getDate() {
		return date;
	}

	public long getId() {
		return id;
	}

	public ArrayList<Long> getGoods() {
		return orders;
	}
}
