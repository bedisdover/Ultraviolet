package LEMS.po.storepo;


import java.io.Serializable;

import LEMS.po.orderpo.TransportType;

/**
 * @author 周梦佳
 * 出库单持久化对象
 */
@SuppressWarnings("serial")
public class OutboundOrderPO implements Serializable {
	/**
	 * 快递单号
	 */
	String id;
	/**
	 * 出库日期
	 */
	String outDate;
	/**
	 * 目的地
	 */
	Destination destination;
	/**
	 * 装运形式
	 */
	TransportType transportType;	
	/**
	 * 中转单编号或汽运编号
	 */
	String transferNum;
	
	public OutboundOrderPO(String identity,String d,Destination des,TransportType tt,String num){
		id=identity;
		outDate=d;
		destination=des;
		transportType=tt;
		transferNum=num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public TransportType getTransportType() {
		return transportType;
	}
	public void setTransportType(TransportType loadFormat) {
		this.transportType = loadFormat;
	}
	public String getTransferNum() {
		return transferNum;
	}
	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}
	
}
