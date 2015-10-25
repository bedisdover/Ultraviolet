package LEMS.vo.ordervo;

/**
 * @author 宋益明
 *
 * 寄件人值对象
 */
public class SenderVO {
	/**
	 * 寄件人姓名
	 */
	private String name;
	/**
	 * 寄件人电话
	 */
	private String phone;
	/**
	 * 寄件人地址
	 */
	private String address;
	
	public SenderVO(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
}
