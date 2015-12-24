package LEMS.po.financepo;

import java.io.Serializable;

/**
 * @author 宋益明
 *
 * 单据的持久化对象基类
 */
public class DocumentPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 单据生成日期
	 */
	private String date;
	/**
	 * 单据编号
	 */
	private String id;
	/**
	 * 单据状态
	 */
	private DocumentState state;

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public DocumentState getState() {
		return state;
	}

	public void setState(DocumentState state) {
		this.state = state;
	}

}
