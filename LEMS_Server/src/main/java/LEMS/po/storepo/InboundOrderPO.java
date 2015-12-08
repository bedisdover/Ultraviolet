package LEMS.po.storepo;
import java.io.Serializable;
/**
 * @author 周梦佳
 * 入库单持久化对象
 */
@SuppressWarnings("serial")
public class InboundOrderPO implements Serializable {
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
	
	public InboundOrderPO(String identity,String d,Destination des,Area ar,int r,int s,int pos){
		id=identity;
		inDate=d;
		destination=des;
		area=ar;
		row=r;
		stand=s;
		position=pos;
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
}
