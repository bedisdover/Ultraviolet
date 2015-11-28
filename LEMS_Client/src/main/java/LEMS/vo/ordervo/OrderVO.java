package LEMS.vo.ordervo;

import java.util.List;

import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.OrderPO;
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
	private List<String> logistics;
	
	//TODO 极有可能不用的构造函数
//	public OrderVO(SenderVO sender, ReceiverVO receiver, GoodsVO goodsInfo, Express expressType, long amount,
//			String time, String id) {
//		this.sender = sender;
//		this.receiver = receiver;
//		this.goodsInfo = goodsInfo;
//		this.expressType = expressType;
//		this.amount = amount;
//		this.time = time;
//		this.id = id;
//	}

	/**
	 * 将订单值对象转换为持久化对象
	 * 
	 * @return 订单持久化对象
	 */
	public OrderPO transferToPO() {
		OrderPO orderPO = new OrderPO();
		
		orderPO.setId(id);
		orderPO.setExpressType(expressType);
		orderPO.setPackageType(packageType);
		orderPO.setAmount(amount);
		orderPO.setTime(time);
		orderPO.setLogistics(logistics);
		
		orderPO.setSenderName(sender.getName());
		orderPO.setSenderPhone(sender.getPhone());
		orderPO.setSenderAddress(sender.getAddress());
		
		orderPO.setReceiverName(receiver.getName());
		orderPO.setReceiverPhone(receiver.getPhone());
		orderPO.setReceiverAddress(receiver.getAddress());

		orderPO.setName(goodsInfo.getName());
		orderPO.setQuantity(goodsInfo.getQuantity());
		orderPO.setWeight(goodsInfo.getWeight());
		orderPO.setVolumn(goodsInfo.getVolumn());
		
		return orderPO;
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

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getLogistics() {
		return logistics;
	}

	public void setLogistics(List<String> logistics) {
		this.logistics = logistics;
	} 
}
