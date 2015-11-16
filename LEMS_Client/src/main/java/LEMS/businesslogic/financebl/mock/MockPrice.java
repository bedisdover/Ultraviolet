package LEMS.businesslogic.financebl.mock;

import java.util.HashMap;

import LEMS.po.financepo.PricePO;
import LEMS.vo.ordervo.Express;

public class MockPrice {
	
	public double getPrice(Express type) {
		double price = 0;
		
		switch (type) {
		case economy:
			price = 15;
			break;
		case standard:
			price = 20;
			break;
		case special:
			price = 25;
			break;
		}
		
		return price;
	}
	
	public void pricing(Express type, double price) {
		//价格列表
		HashMap<Express, Double> priceList = PricePO.getPrice();
		
		switch (type) {
		case economy:
			priceList.put(Express.economy, price);
			break;
		case standard:
			priceList.put(Express.standard, price);
			break;
		case special:
			priceList.put(Express.special, price);
		}
	}
}
