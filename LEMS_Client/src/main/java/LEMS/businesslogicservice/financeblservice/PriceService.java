package LEMS.businesslogicservice.financeblservice;

import LEMS.vo.ordervo.Express;

/**
 * @author 宋益明
 * 
 * 制定价格任务接口
 */
public interface PriceService {
	/**
	 * 获取制定类型快递的价格
	 * 
	 * @param type 快递类型
	 * @return 快递价格
	 */
	public double getPrice(Express type);
	public void pricing(double price);
	//TODO 添加指定具体价格
}
