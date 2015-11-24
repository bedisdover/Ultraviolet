package LEMS.businesslogic.inquirebl.inquirelogisticsinfo;

import java.util.ArrayList;

public class MockOrderTrace {
	
	ArrayList<String> trace=new ArrayList<String>();
	public ArrayList<String> getTrace(){
		trace.add("到达中转站");
		trace.add("派送中");
		return trace;
	}
	
	
}
