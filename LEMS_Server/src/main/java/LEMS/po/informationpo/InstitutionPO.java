package LEMS.po.informationpo;

import java.io.Serializable;

/**
 * @author 苏琰梓
 *	机构信息持久化对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class InstitutionPO implements Serializable{
	String id;
	String location;
	public InstitutionPO(String id,String location){
		/*
		 * 机构编号
		 */
		this.id = id;
		/*
		 * 机构所在地
		 */
		this.location = location;
	}
	
	public String getID(){
		return id;
	}
	
	public String getLocation(){
		return location;
	}
}
