package LEMS.po.orderpo.load;

import LEMS.po.userpo.UserPO;

/**
 * @author 宋益明
 *
 * 汽运单持久化对象
 */
public class LandwayLoadPO extends LoadNotePO {

	/**
	 * 车次号
	 */
	private String carNum;
	
	/**
	 * 押运员
	 */
	private UserPO superCargo;

	public String getCarNum() {
		return carNum;
	}

	public UserPO getSuperCargo() {
		return superCargo;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public void setSuperCargo(UserPO superCargo) {
		this.superCargo = superCargo;
	}
}
