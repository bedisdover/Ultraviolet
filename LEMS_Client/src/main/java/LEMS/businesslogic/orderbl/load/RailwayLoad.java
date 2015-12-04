package LEMS.businesslogic.orderbl.load;

/**
 * @author 宋益明
 * 
 * 负责货运功能的具体实现
 */
public class RailwayLoad extends Load {

	@Override
	public double calculateMessage(double distance) {
		double sum = sumWeight(orders);
		return sum * distance * 0.2;
	}

}
