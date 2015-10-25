package LEMS.po.informationpo;

import java.awt.Image;
import java.io.Serializable;

@SuppressWarnings("serial")
public class VehiclePO implements Serializable{
	/*
	 * 车辆编号
	 */
	long id;
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
	
	VehiclePO(long id,String plateNumber,String workTime,Image i){
		this.id = id;
		this.plateNumber = plateNumber;
		this.workTime = workTime;
		this.i = i;
	}
	
	public long getId() {
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
