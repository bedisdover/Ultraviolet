package LEMS.businesslogic.financebl.stub;

import LEMS.businesslogicservice.financeblservice.PriceService;
import LEMS.vo.ordervo.Express;

/**
 * @author 宋益明
 * 
 * 制定价格任务桩程序
 */
public class PriceService_Stub implements PriceService {

	public double getPrice(Express type) {
		double price = 0.0;
		
		switch (type) {
		case economy:
			price = 10;
			break;
		case standard:
			price = 15;
			break;
		case special:
			price = 25;
			break;
		default:
			break;	
		}
		
		return price;
	}

	public void pricing(Express type, double price) {
		System.out.println("类型："+ type + "\t价格：" + price +"\n更改成功！");
	}

}
