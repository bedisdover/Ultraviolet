package LEMS.vo.informationvo;

import java.io.Serializable;

/**
 * @author 苏琰梓
 *	机构信息值对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class InstitutionVO implements Serializable{
	/*
	 * 机构编号
	 */
	String id;
	
	/*
	 * 机构所在地
	 */
	String location;
	public InstitutionVO(){
		
	}
	public InstitutionVO(String id,String location){
		this.id = id;
		this.location = location;
	}
	
	public String getID(){
		return id;
	}
	
	public String getLocation(){
		return location;
	}
	public void setID(String id){
		this.id=id;
	}
	public void setLocation(String l){
		this.location=l;
	}
}

