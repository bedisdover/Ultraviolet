package LEMS.businesslogic.orderbl.load;

/**
 * @author 宋益明
 * 
 * 负责航运功能的具体实现
 */
public class AirplaneLoad extends Load {

	@Override
	public double calculateMessage(double distance) {
		double sum = sumWeight(orders);
		return sum * distance * 20;
	}

}
