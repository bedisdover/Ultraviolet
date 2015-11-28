package LEMS.po.informationpo;

import java.awt.Image;
import java.io.Serializable;

/**
 * @author 苏琰梓 车辆信息持久化对象 2015年10月25日
 */
@SuppressWarnings("serial")
public class VehiclePO implements Serializable {
	/*
	 * 车辆编号
	 */
	String id;
	/*
	 * 车牌号
	 */
	String plateNumber;
	/*
	 * 服役时间
	 */
	String workTime;
	/*
	 * 车辆图片
	 */
	Image i;

	public VehiclePO(String id, String plateNumber, String workTime, Image i) {
		this.id = id;
		this.plateNumber = plateNumber;
		this.workTime = workTime;
		this.i = i;
	}

	public String getId() {
		return id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public String getWorkTime() {
		return workTime;
	}

	public Image getI() {
		return i;
	}

}
