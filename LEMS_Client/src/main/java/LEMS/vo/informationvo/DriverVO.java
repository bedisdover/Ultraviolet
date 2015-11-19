package LEMS.vo.informationvo;

import java.io.Serializable;

import LEMS.po.informationpo.Gender;

/**
 * @author 苏琰梓
 * 司机信息值对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class DriverVO implements Serializable{
	/*
	 * 司机编号
	 */
	String id;
	/*
	 * 司机姓名
	 */
	private String name;
	/*
	 * 司机出生日期
	 */
	private String dateOfBirth;
	/*
	 * 司机身份证号
	 */
	private String IDcardNumber;
	/*
	 * 司机手机号码
	 */
	private String phoneNumber;
	/*
	 * 司机行驶证期限
	 */
	private String drivingPeriod;
	/*
	 * 司机性别
	 */
	private Gender gender;
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setIDcardNumber(String iDcardNumber) {
		IDcardNumber = iDcardNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDrivingPeriod(String drivingPeriod) {
		this.drivingPeriod = drivingPeriod;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	
	public DriverVO(String id,String name,String dateOfBirth,String IDcardNumber,String phoneNumber,String drivingPeriod,Gender gender){
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.IDcardNumber = IDcardNumber;
		this.phoneNumber = phoneNumber;
		this.drivingPeriod = drivingPeriod;
		this.gender = gender;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getIDcardNumber() {
		return IDcardNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getDrivingPeriod() {
		return drivingPeriod;
	}

	public Gender getGender() {
		return gender;
	}
	
}


