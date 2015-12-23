package LEMS.businesslogic.orderbl.transfer;

import LEMS.businesslogic.orderbl.Distance;

/**
 * @author 宋益明
 * 
 * 负责汽运功能的具体实现
 */
public class LandwayTransfer implements Passage {
	
	private static final double PRICE = 2;
	private static final double WEIGHT = 10;
	
	@Override
	public double calculateMessage(String departure, String destination) {
		double distance = new Distance().getDistance(departure, destination);
		return PRICE * WEIGHT * distance;
	}
}
