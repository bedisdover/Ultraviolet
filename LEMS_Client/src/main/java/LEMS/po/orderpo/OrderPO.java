package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.List;

import LEMS.vo.ordervo.CustomerVO;
import LEMS.vo.ordervo.GoodsVO;

/**
 * @author 宋益明
 * 
 * 订单持久化对象
 */
@SuppressWarnings("serial")
public class OrderPO implements Serializable {
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
	//TODO 等待处理的物流信息
	/**
	 * 物流信息
	 */
	private List<String> logistics;
	
	public OrderPO() {
		super();
	}
	
	//TODO 测试用，根据ID直接得到order
	public OrderPO(String id) {
		this.id = id;
	}
	
	public OrderPO(CustomerVO sender, CustomerVO receiver, GoodsVO goodsInfo, Express expressType, long amount,
			String time, String id) {
		this.sender = sender;
		this.receiver = receiver;
		this.goodsInfo = goodsInfo;
		this.expressType = expressType;
		this.amount = amount;
		this.time = time;
		this.id = id;
	}

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

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setId(String id) {
		this.id = id;
	}
}

