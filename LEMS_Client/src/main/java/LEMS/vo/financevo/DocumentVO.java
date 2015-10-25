package LEMS.vo.financevo;

/**
 * @author 宋益明
 * 
 * 所有单据的基类
 */
public abstract class DocumentVO {
	/**
	 * 单据生成日期
	 */
	private String date;
	/**
	 * 单据编号
	 */
	private long id;

	public String getDate() {
		return date;
	}

	public long getId() {
		return id;
	}
}
