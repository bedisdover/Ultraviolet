package LEMS.po.orderpo.transfer;

/**
 * @author 宋益明
 *
 * 汽运单持久化对象
 */
public class LandwayLoadPO extends TransferNotePO {
	private static final long serialVersionUID = 1L;

	/**
	 * 车次号
	 */
	private String carNum;
	
	/**
	 * 押运员
	 */
	private String superCargo;

	public String getCarNum() {
		return carNum;
	}

	public String getSuperCargo() {
		return superCargo;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public void setSuperCargo(String superCargo) {
		this.superCargo = superCargo;
	}
}
