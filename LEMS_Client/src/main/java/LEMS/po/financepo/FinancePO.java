package LEMS.po.financepo;

/**
 * @author 宋益明
 *
 * Finance包中PO类的基类
 */
public class FinancePO {
	/**
	 * 创建日期
	 */
	private String date;
	/**
	 * 单据ID
	 */
	private String id;
	/**
	 * 单据状态
	 */
	private DocumentState state;
	
	public FinancePO(String date, String id, DocumentState state) {
		this.date = date;
		this.id = id;
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public DocumentState getState() {
		return state;
	}
}
