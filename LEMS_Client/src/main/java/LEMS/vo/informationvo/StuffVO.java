package LEMS.vo.informationvo;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.informationpo.InstitutionPO;

/**
 * @author 苏琰梓
 * 人员信息值对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class StuffVO implements Serializable{
	/*
	 * 人员编号
	 */
	String id;
	/*
	 * 人员所在的机构信息
	 */
	ArrayList<InstitutionPO> institution;
	
	StuffVO(String id,ArrayList<InstitutionPO> institution){
		this.id = id;
		this.institution = institution;
	}
	
	public String getID(){
		return id;
	}
	
	public ArrayList<InstitutionPO> getInstitution(){
		return institution;
	}
}
