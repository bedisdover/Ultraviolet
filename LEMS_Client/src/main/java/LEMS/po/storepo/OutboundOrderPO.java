package LEMS.po.storepo;

import java.io.Serializable;
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
	LoadFormat loadFormat;	
	/**
	 * 中转单编号或汽运编号
	 */
	long transferNum;
	
	public OutboundOrderPO(String identity,String d,Destination des,LoadFormat lf,long num){
		id=identity;
		outDate=d;
		destination=des;
		loadFormat=lf;
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
