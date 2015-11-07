package LEMS.po.informationpo;

import java.io.Serializable;

/**
 * @author 苏琰梓
 * 司机信息持久化对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class DriverPO implements Serializable{
	/*
	 * 司机编号
	 */
	long id;
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
	
	public DriverPO(long id,String name,String dateOfBirth,String IDcardNumber,String phoneNumber,String drivingPeriod,Gender gender){
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.IDcardNumber = IDcardNumber;
		this.phoneNumber = phoneNumber;
		this.drivingPeriod = drivingPeriod;
		this.gender = gender;
	}
	
	public long getId() {
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

