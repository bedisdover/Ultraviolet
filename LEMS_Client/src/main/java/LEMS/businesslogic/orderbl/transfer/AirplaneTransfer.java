package LEMS.businesslogic.orderbl.transfer;

import LEMS.businesslogic.orderbl.Distance;

/**
 * @author 宋益明
 * 
 * 负责航运功能的具体实现
 */
public class AirplaneTransfer implements Passage {
	
	private static final double PRICE = 20;
	private static final double WEIGHT = 50;
	
	@Override
	public double calculateMessage(String departure, String destination) {
		double distance = new Distance().getDistance(departure, destination);
		return PRICE * WEIGHT * distance;
	}
}
