package LEMS.vo.ordervo;

/**
 * @author 宋益明
 * 
 * 货物到达单值对象
 */
public class ArrivalVO {
	/**
	 * 货物到达日期
	 */
	private String date;
	/**
	 * 到达单编号
	 */
	private String id;
	/**
	 * 出发地
	 */
	private String depature;
	
	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public String getDepature() {
		return depature;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setDepature(String depature) {
		this.depature = depature;
	}
}
