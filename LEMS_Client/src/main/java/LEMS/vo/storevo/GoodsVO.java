package LEMS.vo.storevo;

import LEMS.po.storepo.Area;
/**
 * @author 周梦佳
 * Goods的值对象
 */
public class GoodsVO {
	/**
	 * 快递单号
	 */
	String id;
	/**
	 * 存放区域
	 */
	Area area;
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
	public GoodsVO(String i,Area ar,int r,int s,int p){
		id=i;
		area=ar;
		row=r;
		stand=s;
		position=p;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
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

}
