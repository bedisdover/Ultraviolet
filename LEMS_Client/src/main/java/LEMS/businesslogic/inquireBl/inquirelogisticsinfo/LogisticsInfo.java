package LEMS.businesslogic.inquirebl.inquirelogisticsinfo;

import java.util.ArrayList;

public class LogisticsInfo {
	
	String id;
	ArrayList<String> trace;
	public LogisticsInfo(String id){
		this.id=id;
	}
	
	public ArrayList<String> getLogisticsInfo(){
		MockOrderTrace t=new MockOrderTrace();
		trace=t.getTrace();
		return trace;
	}
}
