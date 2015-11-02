package LEMS.vo.storevo;

import LEMS.po.storepo.Area;

public class GoodsVO {
	String id;
	Area area;
	int row;		//排
	int stand;		//架
	int position;	//位
	
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
