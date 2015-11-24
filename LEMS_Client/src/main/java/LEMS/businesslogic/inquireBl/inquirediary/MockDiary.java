package LEMS.businesslogic.inquirebl.inquirediary;

import java.util.ArrayList;

public class MockDiary extends Diary {
	
	ArrayList<String> operation=new ArrayList<String>();
	public MockDiary(String date){
		operation.add(date);
		operation.add("add an account.");
	}
	public ArrayList<String> getOperation(){
		return operation;
	}
}
