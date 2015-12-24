package LEMS.vo.inquirevo;

import java.util.ArrayList;

/**
 * @author 章承尧 LogisticsInfo的值对象
 */
public class LogisticsInfoVO {
	/**
	 * 订单编号
	 */
	private String id;
	/**
	 * 快递的物流轨迹
	 */
	private ArrayList<String> trace;
	/**
	 * 机构名称（用于获得各种单据中的出发地）
	 */
	private String institution;

	public LogisticsInfoVO(String i, ArrayList<String> t) {
		id = i;
		trace = t;
	}
	
	public LogisticsInfoVO(){
		trace = new ArrayList<String>();
	}
	
	/**
	 * @return String
	 * 返回该物流信息对应的订单号
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 返回最新物流信息（列表中最后一条）
	 * 
	 * @return 物流信息
	 */
	public String getLast() {
		return trace.get(trace.size() - 1);
	}

	/**
	 * 返回历史轨迹
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getTrace() {
		return trace;
	}
	
	public String getInstitution() {
		return institution;
	}
	
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	public void setTrace(String logistics) {
		trace.add(logistics);
	}
}
