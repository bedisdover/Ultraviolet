package LEMS.po.informationpo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InstitutionPO implements Serializable{
	String id;
	String location;
	InstitutionPO(String id,String location){
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
