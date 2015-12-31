package LEMS.vo.storevo;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.TransportType;

public class GoodsVOExcel {
	/**
	 * 快递单号
	 */
	String id;
	/**
	 * 入库日期
	 */
	String inDate;

	/**
	 * 目的地
	 */
	String destination;
	/**
	 * 存放区域
	 */
	String area;
	/**
	 * 排
	 */
	int row;
	/**
	 * 架
	 */
	int stand;
	/**
	 * 位
	 */
	int position;

	/**
	 * 运费
	 */
	double money;

	public GoodsVOExcel(String i, String iD, String des, String ar, int r, int s, int p, double mon) {
		id = i;
		inDate = iD;
		destination = des;
		area = ar;
		row = r;
		stand = s;
		position = p;
		money = mon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getStand() {
		return stand;
	}

	public void setStand(int stand) {
		this.stand = stand;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	

}
