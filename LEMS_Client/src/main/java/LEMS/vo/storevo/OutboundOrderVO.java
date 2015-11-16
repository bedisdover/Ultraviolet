package LEMS.vo.storevo;

import java.util.ArrayList;

import LEMS.po.storepo.Destination;
import LEMS.po.storepo.LoadFormat;
/**
 * @author 周梦佳
 * OutboundOrder的值对象
 */
public class OutboundOrderVO {
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
	/**
	 * 操作
	 */
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
