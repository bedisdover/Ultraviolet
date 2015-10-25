package LEMS.po.storepo;

public class OutboundOrderPO {
	long id;
	String outDate;
	Destination destination;
	LoadFormat loadFormat;	//装运形式
	long transferNum;	//中转单编号或汽运编号
	
	public OutboundOrderPO(long identity,String d,Destination des,LoadFormat lf,long num){
		id=identity;
		outDate=d;
		destination=des;
		loadFormat=lf;
		transferNum=num;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public LoadFormat getLoadFormat() {
		return loadFormat;
	}
	public void setLoadFormat(LoadFormat loadFormat) {
		this.loadFormat = loadFormat;
	}
	public long getTransferNum() {
		return transferNum;
	}
	public void setTransferNum(long transferNum) {
		this.transferNum = transferNum;
	}
	
}
