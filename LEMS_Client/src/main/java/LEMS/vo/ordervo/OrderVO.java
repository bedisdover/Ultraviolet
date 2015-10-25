package LEMS.vo.ordervo;

/**
 * @author 宋益明
 * 
 * 订单值对象
 */
public class OrderVO {
	/**
	 * 寄件人
	 */
	private SenderVO sender;
	/**
	 * 收件人
	 */
	private ReceiverVO receiver;
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
	private long amount;
	/**
	 * 预估时间
	 */
	private String time;
	
	public OrderVO(SenderVO sender, ReceiverVO receiver, GoodsVO goodsInfo, Express expressType, long amount,
			String time) {
		this.sender = sender;
		this.receiver = receiver;
		this.goodsInfo = goodsInfo;
		this.expressType = expressType;
		this.amount = amount;
		this.time = time;
	}

	public SenderVO getSender() {
		return sender;
	}

	public ReceiverVO getReceiver() {
		return receiver;
	}

	public GoodsVO getGoodsInfo() {
		return goodsInfo;
	}

	public Express getExpressType() {
		return expressType;
	}

	public long getAmount() {
		return amount;
	}

	public String getTime() {
		return time;
	}
}
