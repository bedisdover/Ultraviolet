package LEMS.po.financepo;

import LEMS.po.financepo.DocumentState;

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
	private long id;
	/**
	 * 单据状态
	 */
	private DocumentState state;
	
	public FinancePO(String date, long id, DocumentState state) {
		this.date = date;
		this.id = id;
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public long getId() {
		return id;
	}

	public DocumentState getState() {
		return state;
	}
}
