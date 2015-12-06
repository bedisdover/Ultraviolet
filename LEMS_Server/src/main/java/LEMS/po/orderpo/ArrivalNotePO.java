package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.ArrayList;

import LEMS.po.financepo.DocumentState;

/**
 * @author 宋益明
 *
 * 到达单持久化对象（营业厅、中转中心）
 * 包括：
 * 		到达单编号、到达单状态、到达日期、
 * 		中转单编号、出发地、机构编号、
 * 		托运订单条形码号
 */
public class ArrivalNotePO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 到达单ID
	 */
	private String id;
	
	/**
	 * 状态
	 */
	private DocumentState state;
	
	/**
	 * 到达日期
	 */
	private String date;
	
	/**
	 * 出发地
	 */
	private String departure;
	
	/**
	 * 托运订单条形码号
	 */
	private ArrayList<OrderPO> orders;

	/**
	 * 中转单ID
	 */
	private String transferNoteId;
	
	/**
	 * 所在营业厅（中转中心）
	 */
	private String institution;

	public ArrivalNotePO() {
		state = DocumentState.waiting;
	}
	
	public String getDeparture() {
		return departure;
	}
	
	public String getId() {
		return id;
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	public DocumentState getState() {
		return state;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTransferNoteId() {
		return transferNoteId;
	}
	
	public String getInstitution() {
		return institution;
	}
	
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}
	
	public void setState(DocumentState state) {
		this.state = state;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setTransferNoteId(String transferNoteId) {
		this.transferNoteId = transferNoteId;
	}
	
	public void setInstitution(String institution) {
		this.institution = institution;
	}
}
