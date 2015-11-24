package LEMS.businesslogic.financebl.mock;

import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;

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
		PricePO.pricing(type, price);
	}
}
