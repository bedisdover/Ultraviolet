package LEMS.businesslogicservice.orderblservice;

import LEMS.vo.ordervo.Express;
import LEMS.vo.ordervo.GoodsVO;
import LEMS.vo.ordervo.ReceiverVO;
import LEMS.vo.ordervo.SenderVO;

/**
 * @author 宋益明
 * 
 * 新建订单接口
 */
public interface OrderService {
	/**
	 * 添加寄件人
	 * 
	 * @param sender 寄件人
	 */
	public void addSender(SenderVO sender);
	/**
	 * 添加收件人
	 * 
	 * @param receiver
	 */
	public void addReceiver(ReceiverVO receiver);
	/**
	 * 添加货物信息
	 * 
	 * @param goods 货物信息
	 */
	public void addGoodsInfo(GoodsVO goods);
	/**
	 * 选择快递类型
	 * 
	 * @param type 快递类型
	 */
	public void chooseType(Express type);
	/**
	 * 生成订单条形码
	 * 
	 * @return 订单条形码
	 */
	public long createID();
	/**
	 * 计算货物运费
	 * 
	 * @return 运费
	 */
	public double getMoney();
	/**
	 * 计算总运费
	 * 
	 * @return 总运费
	 */
	public double getTotal();
	/**
	 * 获得预估时间
	 * 
	 * @return 预估时间
	 */
	public String getTime();
	/**
	 * 技术订单管理任务
	 */
	public void endOrder();
}
