package LEMS.businesslogic.financebl.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import LEMS.businesslogic.financebl.mock.MockPrice;
import LEMS.po.financepo.PricePO;
import LEMS.vo.ordervo.Express;

public class PriceTest {

	MockPrice mockPrice = new MockPrice();
	
	@Test
	public void testGetPrice(Express type) {
		switch (type) {
		case economy:
			assertEquals(15.0, mockPrice.getPrice(type), 0.0);
			break;
		case standard:
			assertEquals(20.0, mockPrice.getPrice(type), 0.0);
			break;
		case special:
			assertEquals(25.0, mockPrice.getPrice(type), 0.0);
			break;
		}
	}
	
	@Test
	public void testPricing(Express type, double price) {
		HashMap<Express, Double> priceList = PricePO.getPrice();
		mockPrice.pricing(type, price);
		assertEquals(price, priceList.get(type), 0.0);
	}
}
