package LEMS.vo.inquirevo;

import java.util.ArrayList;

/**
 * @author 章承尧
 * Diary的值对象
 */
public class DiaryVO {
	/**
	 * 日期
	 */
	String date;
	/**
	 * 对系统的主要操作
	 */
	ArrayList<String> operation;
	
	
	public DiaryVO(String d,ArrayList<String> o){
		date=d;
		operation=o;
	}
	
	public String getDate(){
		return date;
	}
	public ArrayList<String> getOperation(){
		return operation;
	}
	
}
