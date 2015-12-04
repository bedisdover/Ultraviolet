package LEMS.po.orderpo;

import LEMS.po.inquirepo.LogisticsInfoPO;
import LEMS.po.userpo.UserPO;

/**
 * @author 宋益明
 * 
 * 订单持久化对象
 */
public class OrderPO {
	
	/**
	 * 寄件人姓名
	 */
	private String senderName;
	/**
	 * 寄件人电话
	 */
	private String senderPhone;
	/**
	 * 寄件人地址
	 */
	private String senderAddress;
	
	/**
	 * 收件人姓名 
	 */
	private String receiverName;
	/**
	 * 收件人电话
	 */
	private String receiverPhone;
	/**
	 * 收件人地址
	 */
	private String receiverAddress;
	
	/**
	 * 货物名称
	 */
	private String name;
	/**
	 * 货物数量
	 */
	private int quantity;
	/**
	 * 货物质量
	 */
	private double weight;
	/**
	 * 货物体积
	 */
	private double volumn;

	/**
	 * 快递类型
	 */
	private Express expressType;
	/**
	 * 包装类型
	 */
	private Packing packageType;
	/**
	 * 订单金额
	 */
	private double amount;
	/**
	 * 预估时间
	 */
	private String time;
	/**
	 * 订单ID
	 */
	private String id;
	/**
	 * 实际收件人
	 */
	private String receiver;

	/**
	 * 物流信息
	 */
	private LogisticsInfoPO logisticsInfoPO;
	
	/**
	 * 揽件员
	 */
	private UserPO collector;
	/**
	 * 派件员
	 */
	private UserPO deliver;
	
	public OrderPO() {
		super();
	}
	
	//TODO 测试用，根据ID直接得到order
	public OrderPO(String id) {
		this.id = id;
	}
	
//	public OrderPO(CustomerVO sender, CustomerVO receiver, GoodsVO goodsInfo, Express expressType, long amount,
//			String time, String id) {
//		this.sender = sender;
//		this.receiver = receiver;
//		this.goodsInfo = goodsInfo;
//		this.expressType = expressType;
//		this.amount = amount;
//		this.time = time;
//		this.id = id;
//	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public String getName() {
		return name;
	}

	public String getReceiver() {
		return receiver;
	}
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolumn() {
		return volumn;
	}

	public Express getExpressType() {
		return expressType;
	}

	public double getAmount() {
		return amount;
	}

	public String getTime() {
		return time;
	}

	public String getId() {
		return id;
	}

	public UserPO getCollector() {
		return collector;
	}
	
	public UserPO getDeliver() {
		return deliver;
	}
	
	public void setCollector(UserPO collector) {
		this.collector = collector;
	}
	
	public void setDeliver(UserPO deliver) {
		this.deliver = deliver;
	}
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}

	public void setExpressType(Express expressType) {
		this.expressType = expressType;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Packing getPackageType() {
		return packageType;
	}

	public void setPackageType(Packing packageType) {
		this.packageType = packageType;
	}

	public LogisticsInfoPO getLogisticsInfoPO() {
		return logisticsInfoPO;
	}

	public void setLogisticsInfoPO(LogisticsInfoPO logisticsInfoPO) {
		this.logisticsInfoPO = logisticsInfoPO;
	}
}

