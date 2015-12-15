package LEMS.po.orderpo.transfer;

/**
 * @author 宋益明
 * 
 * 货运单持久化对象
 */
public class RailwayLoadPO extends TransferNotePO {
	private static final long serialVersionUID = 1L;

	/**
	 * 车次号
	 */
	private String trainNum;
	
	/**
	 * 车厢号
	 */
	private String carriage;

	public String getTrainNum() {
		return trainNum;
	}

	public String getCarriage() {
		return carriage;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}
}
