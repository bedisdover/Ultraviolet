package LEMS.po.storepo;

public class GoodsPO {
	String id;
	String inDate;
	String outDate;
	Destination destination;
	Area area;
	int row;		//排
	int stand;		//架
	int position;	//位
	TransportType transportType;
	long transferNum;
	
	public GoodsPO(String i,Area ar,int r,int s,int p){
		id=i;
		area=ar;
		row=r;
		stand=s;
		position=p;
	}
	
	public GoodsPO(String i,String inD,String outD,Destination des,Area ar,int r,int s,int p,TransportType tt,long trans){
		id=i;
		inDate=inD;
		outDate=outD;
		destination=des;
		area=ar;
		row=r;
		stand=s;
		position=p;
		transportType=tt;
		transferNum=trans;
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

	public long getTransferNum() {
		return transferNum;
	}

	public void setTransferNum(long transferNum) {
		this.transferNum = transferNum;
	}
	
}
