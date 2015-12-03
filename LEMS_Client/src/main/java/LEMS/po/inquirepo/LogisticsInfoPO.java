package LEMS.po.inquirepo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author 章承尧 物流信息持久化对象
 */
@SuppressWarnings("serial")
public class LogisticsInfoPO implements Serializable {
	/**
	 * 订单编号
	 */
	String id;
	/**
	 * 快递物流轨迹
	 */
	ArrayList<String> trace;
	/**
	 * 机构名称（用于获得各种单据中的出发地）
	 */
	private String institution;

	public LogisticsInfoPO(String i, ArrayList<String> t) {
		id = i;
		trace = t;
	}

	public LogisticsInfoPO() {

	}

	/**
	 * @return String 返回该物流信息对应的订单号
	 */
	public String getId() {
		return id;
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
	 * 
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
