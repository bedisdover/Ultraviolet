package LEMS.vo.informationvo;

import java.io.Serializable;

import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.userpo.UserRole;

/**
 * @author 苏琰梓
 * 人员信息值对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class StaffVO implements Serializable{
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
	UserRole role;
	public StaffVO(String id,String password,UserRole role,InstitutionPO institution){
		this.id = id;
		this.institution = institution;
		this.password=password;
		this.role=role;
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
	public UserRole getRole(){
		return role;
	}
}
