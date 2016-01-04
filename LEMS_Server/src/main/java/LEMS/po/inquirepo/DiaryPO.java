package LEMS.po.inquirepo;

import java.io.Serializable;

import LEMS.po.financepo.DocumentPO;

/**
 * @author 章承尧
 * 日志持久化对象
 */
@SuppressWarnings("serial")
public class DiaryPO extends DocumentPO implements Serializable{
	/**
	 * 日期
	 */
	String date;
	/**
	 * 对系统的操作
	 */
	String operation;
	
	
	public DiaryPO(String d,String o){
		date=d;
		operation=o;

	}
	
	public String getDate(){
		return date;
	}
	public String getOperation(){
		return operation;
	}

}
