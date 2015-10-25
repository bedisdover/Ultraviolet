package LEMS.vo.informationvo;

import java.awt.Image;
import java.io.Serializable;

/**
 * @author 苏琰梓
 * 车辆信息值对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class VehicleVO implements Serializable{
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
	
	public VehicleVO(long id,String plateNumber,String workTime,Image i){
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