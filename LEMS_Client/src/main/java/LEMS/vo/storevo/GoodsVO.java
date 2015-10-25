package LEMS.vo.storevo;

import LEMS.po.storepo.Area;

public class GoodsVO {
	long id;
	Area area;
	int row;		//排
	int stand;		//架
	int position;	//位
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
