package LEMS.businesslogic.financebl;

import LEMS.businesslogicservice.financeblservice.PriceService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

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

	public double getPrice(Packing type) {
		return PricePO.getPrice(type);
	}

	public void pricing(Express type, double price) {
		//更新快递价格
		PricePO.pricing(type, price);
	}
	
	public void pricing(Packing type, double price) {
		//更新包装价格
		PricePO.pricing(type, price);
	}
}
