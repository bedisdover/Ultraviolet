package LEMS.vo.financevo;

/**
 * @author 宋益明
 * 
 * 所有单据的基类
 */
public class DocumentVO {
	/**
	 * 单据生成日期
	 */
	private String date;
	/**
	 * 单据编号
	 */
	private String id;
	//TODO 默认单据状态为待审批
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
