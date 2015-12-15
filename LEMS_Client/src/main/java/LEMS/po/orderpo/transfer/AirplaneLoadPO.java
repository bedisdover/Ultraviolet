package LEMS.po.orderpo.transfer;

/**
 * @author 宋益明
 * 
 * 航运单持久化对象
 */
public class AirplaneLoadPO extends TransferNotePO {
	private static final long serialVersionUID = 1L;

	/**
	 * 航班号
	 */
	private String flight;
	
	/**
	 * 货柜号
	 */
	private String container;

	public String getFlight() {
		return flight;
	}

	public String getContainer() {
		return container;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public void setContainer(String container) {
		this.container = container;
	}
}
