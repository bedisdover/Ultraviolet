package LEMS.businesslogic.financebl;

import java.util.HashMap;

import LEMS.businesslogicservice.financeblservice.PriceService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;

/**
 * @author 宋益明
 * 
 * 制定价格任务
 */
public class Price implements PriceService {

	/**
	 * 价格列表
	 */
	private HashMap<Express, Double> priceList;
	
	public Price() {
		//获取价格列表
		priceList = PricePO.getPrice();
	}
	
	public double getPrice(Express type) {
		return priceList.get(type);
	}

	public void pricing(Express type, double price) {
		//更新价格
		priceList.put(type, price);
	}
}
