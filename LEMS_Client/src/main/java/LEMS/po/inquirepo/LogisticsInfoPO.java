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

	public String getId() {
		return id;
	}

	public ArrayList<String> getTrace() {
		return trace;
	}

	public String getInstitution() {
		return institution;
	}
}
