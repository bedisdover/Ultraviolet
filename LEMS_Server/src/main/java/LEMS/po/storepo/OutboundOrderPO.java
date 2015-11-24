package LEMS.po.storepo;

import LEMS.vo.ordervo.TransportType;

public class OutboundOrderPO {
	long id;
	String outDate;
	Destination destination;
	TransportType transportType;	//装运形式
	long transferNum;	//中转单编号或汽运编号
	
	public OutboundOrderPO(long identity,String d,Destination des,TransportType tt,long num){
		id=identity;
		outDate=d;
		destination=des;
		transportType=tt;
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
	public TransportType  getTransportType() {
		return  transportType;
	}
	public void setTransportType(TransportType transportType) {
		this. transportType =  transportType;
	}
	public long getTransferNum() {
		return transferNum;
	}
	public void setTransferNum(long transferNum) {
		this.transferNum = transferNum;
	}
	
}
