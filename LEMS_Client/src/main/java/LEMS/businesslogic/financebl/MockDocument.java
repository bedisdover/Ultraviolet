package LEMS.businesslogic.financebl;

/**
 * @author 宋益明
 * 
 * 所有单据Mock对象的基类
 */
public class MockDocument {
	/**
	 * 单据ID
	 */
	String id;
	/**
	 * 单据日期
	 */
	String date;

	public MockDocument(String id, String date) {
		super();
		this.id = id;
		this.date = date;
	}
}
