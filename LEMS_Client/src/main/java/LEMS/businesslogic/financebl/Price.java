package LEMS.businesslogic.financebl;

import LEMS.businesslogicservice.financeblservice.PriceService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;

/**
 * @author 宋益明
 * 
 * 制定价格任务
 */
public class Price implements PriceService {

	public Price() {

	}
	
	public double getPrice(Express type) {
		return PricePO.getPrice(type);
	}

	public void pricing(Express type, double price) {
		//更新价格
		PricePO.pricing(type, price);
	}
}
