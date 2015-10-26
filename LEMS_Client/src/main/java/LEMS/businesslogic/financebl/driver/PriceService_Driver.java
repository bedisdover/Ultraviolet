package LEMS.businesslogic.financebl.driver;

import LEMS.businesslogic.financebl.stub.PriceService_Stub;
import LEMS.vo.ordervo.Express;

/**
 * @author 宋益明
 * 
 * 制定价格任务驱动程序
 */
public class PriceService_Driver {

	public void drive(PriceService_Stub priceService) {
		System.out.println("类型：economy\t价格："+priceService.getPrice(Express.economy));
		System.out.println("类型：standard\t价格："+priceService.getPrice(Express.standard));
		System.out.println("类型：special\t价格："+priceService.getPrice(Express.special));
		System.out.println();
		priceService.pricing(Express.economy, 18.5);
		priceService.pricing(Express.standard, 23.2);
		priceService.pricing(Express.special, 34.8);
		System.out.println();
	}
}
