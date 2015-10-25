package LEMS.vo.informationvo;

import java.io.Serializable;

/**
 * @author 苏琰梓
 *	机构信息值对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class InstitutionVO implements Serializable{
	String id;
	String location;
	InstitutionVO(String id,String location){
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

