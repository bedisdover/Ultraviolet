package LEMS.po.informationpo;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.informationpo.InstitutionPO;

@SuppressWarnings("serial")
public class StuffPO implements Serializable{
	/*
	 * 人员编号
	 */
	String id;
	/*
	 * 人员所在的机构信息
	 */
	ArrayList<InstitutionPO> institution;
	
	StuffPO(String id,ArrayList<InstitutionPO> institution){
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
