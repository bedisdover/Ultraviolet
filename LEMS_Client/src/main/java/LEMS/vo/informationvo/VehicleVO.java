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
	String image;
	
	public VehicleVO(){
		
	}
	public VehicleVO(String id, String plateNumber, String workTime, String image) {
		this.id = id;
		this.plateNumber = plateNumber;
		this.workTime = workTime;
		this.image = image;
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

	public String getImage() {
		return image;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setPlateNumber(String pn){
		this.plateNumber=pn;
	}
	public void setWorkTime(String w){
		this.workTime=w;
	}
	public void setImage(String im){
		this.image=im;
	}
}
