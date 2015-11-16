package LEMS.vo.storevo;

import LEMS.po.storepo.Destination;
import LEMS.po.storepo.LoadFormat;

public class OutboundOrderVO {
	String id;
	String outDate;
	Destination destination;
	LoadFormat loadFormat;	//装运形式
	long transferNum;	//中转单编号或汽运编号
	ArrayList<String> operation;
	
	public OutboundOrderVO(String identity,String d,Destination des,LoadFormat lf,long num,ArrayList<String> o){
		id=identity;
		outDate=d;
		destination=des;
		loadFormat=lf;
		transferNum=num;
		operation=o;
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
	public ArrayList<String> getOperation(){
		return operation;
	}
}
