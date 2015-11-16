package LEMS.businesslogic.storebl;

import java.util.ArrayList;

import LEMS.po.storepo.Destination;
import LEMS.po.storepo.LoadFormat;

public class MockStoreOutboundOrder extends StoreOutboundOrder {
	String id;
	String outDate;
	Destination destination;
	LoadFormat loadFormat;	//装运形式
	long transferNum;	//中转单编号或汽运编号
	ArrayList<String> operation2;
	
	public MockStoreOutboundOrder(String identity,String d,Destination des,LoadFormat lf,long num){
		id=identity;
		outDate=d;
		destination=des;
		loadFormat=lf;
		transferNum=num;
		
	}
	
	public MockStoreOutboundOrder(String identity,String d,Destination des,LoadFormat lf,long num,ArrayList<String> o){
		id=identity;
		outDate=d;
		destination=des;
		loadFormat=lf;
		transferNum=num;
		operation2=o;
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
	
	ArrayList<String> operation=new ArrayList<String>();
	public void StoreOutboundOrder(String id, String outDate, Destination destination, LoadFormat loadFormat, long transferNum){
		operation.add(id);
		operation.add("add an id.");
		operation.add(outDate);
		operation.add("add outDate.");
		operation.add(destination.name());
		operation.add("add destination.");
		operation.add(loadFormat.name());
		operation.add("add a loadFormat.");
		operation.add(String.valueOf(transferNum));
		operation.add("add a transferNum.");


	}
	public ArrayList<String> generateOperation(){
		return operation;
	}
}
