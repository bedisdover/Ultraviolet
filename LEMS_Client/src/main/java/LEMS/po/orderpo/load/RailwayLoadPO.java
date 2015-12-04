package LEMS.po.orderpo.load;

/**
 * @author 宋益明
 * 
 * 货运单持久化对象
 */
public class RailwayLoadPO extends LoadNotePO {

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
