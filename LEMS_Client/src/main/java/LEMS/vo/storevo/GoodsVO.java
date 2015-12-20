package LEMS.vo.storevo;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.TransportType;
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
 * 入库日期
 */
	String inDate;
	/**
	 * 出库日期
	 */
	String outDate;
	/**
	 * 目的地
	 */
	Destination destination;
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
	/**
	 * 装运形式
	 */
	TransportType transportType;
	/**
	 * 中转单或汽运编号
	 */
	String transferNum;
	/**
	 * 运费
	 */
	double money;
	public GoodsVO(String i,Area ar,int r,int s,int p){
		id=i;
		area=ar;
		row=r;
		stand=s;
		position=p;
	}
	
	public GoodsVO(String i,String inD,String oD,Destination des,Area ar,int r ,int s, int pos,TransportType tt,String tn,double mon){
		id=i;
		inDate=inD;
		outDate=oD;
		destination=des;
		area=ar;
		row=r;
		stand=s;
		position=pos;
		transportType=tt;
		transferNum=tn;
		money=mon;
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

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
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

	public TransportType getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}

	public String getTransferNum() {
		return transferNum;
	}

	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
