package LEMS.po.informationpo;

import java.io.Serializable;

import LEMS.vo.informationvo.Position;

/**
 * @author 苏琰梓
 * 人员信息持久化对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class StaffPO implements Serializable{
	/*
	 * 人员编号
	 */
	String id;
	/*
	 * 人员所在的机构信息
	 */
	InstitutionPO institution;
	/**
	 * 密码
	 */
	String password;
	/**
	 * 职位
	 */
	Position position;
	public StaffPO(String id,String password,Position position,InstitutionPO institution){
		this.id = id;
		this.institution = institution;
		this.password=password;
		this.position=position;
	}
	
	public String getID(){
		return id;
	}
	
	public InstitutionPO getInstitution(){
		return institution;
	}
	public String getPassword(){
		return password;
	}
	public Position getPosition(){
		return position;
	}
}
