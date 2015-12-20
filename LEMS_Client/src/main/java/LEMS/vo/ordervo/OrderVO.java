package LEMS.vo.ordervo;

import LEMS.po.inquirepo.LogisticsInfoPO;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

/**
 * @author 宋益明
 * 
 * 订单值对象
 */
public class OrderVO {
	/**
	 * 寄件人
	 */
	private CustomerVO sender;
	/**
	 * 收件人
	 */
	private CustomerVO receiver;
	/**
	 * 货物信息
	 */
	private GoodsVO goodsInfo;
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
	 * 物流信息
	 */
	private LogisticsInfoPO logistics;

	public CustomerVO getSender() {
		return sender;
	}

	public CustomerVO getReceiver() {
		return receiver;
	}

	public GoodsVO getGoodsInfo() {
		return goodsInfo;
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

	public Packing getPackingType() {
		return packageType;
	}
	
	public void setPackingType(Packing packingType) {
		this.packageType = packingType;
	}
	
	public void setSender(CustomerVO sender) {
		this.sender = sender;
	}

	public void setReceiver(CustomerVO receiver) {
		this.receiver = receiver;
	}

	public void setGoodsInfo(GoodsVO goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public void setExpressType(Express expressType) {
		this.expressType = expressType;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LogisticsInfoPO getLogistics() {
		return logistics;
	}

	public void setLogistics(LogisticsInfoPO logistics) {
		this.logistics = logistics;
	} 
}
