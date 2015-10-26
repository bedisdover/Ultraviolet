package LEMS.po.informationpo;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.informationpo.InstitutionPO;

/**
 * @author 苏琰梓
 * 人员信息持久化对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class StuffPO implements Serializable{
	/*
	 * 人员编号
	 */
	String id;
	/*
	 * 人员所在的机构信息
	 */
	InstitutionPO institution;
	
	public StuffPO(String id,InstitutionPO institution){
		this.id = id;
		this.institution = institution;
	}
	
	public String getID(){
		return id;
	}
	
	public InstitutionPO getInstitution(){
		return institution;
	}
}
