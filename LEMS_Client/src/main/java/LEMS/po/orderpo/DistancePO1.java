package LEMS.po.orderpo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 宋益明
 * 
 *         用于获得各城市间距离
 */
public class DistancePO1 {

	//TODO 忽然发现总经理居然还可以制定城市间距离，我也是醉了
	
	/**
	 * 同一城市各营业厅距离
	 */
	public static double SAME_CITY = 30.0;
	
	/**
	 * 存储距离常量
	 */
	static Map<String, Double> distance;

	static {
		distance = new HashMap<String, Double>();
		distance.put("北京上海", 1064.7);
		distance.put("上海北京", 1064.7);
		distance.put("北京广州", 1888.8);
		distance.put("广州北京", 1888.8);
		distance.put("北京南京", 900.0);
		distance.put("南京北京", 900.0);
		distance.put("上海广州", 1213.0);
		distance.put("广州上海", 1213.0);
		distance.put("上海南京", 266.0);
		distance.put("南京上海", 266.0);
		distance.put("广州南京", 1132.0);
		distance.put("南京广州", 1132.0);
	}

	/**
	 * 返回城市间距离
	 * 
	 * @param former
	 *            出发地
	 * @param latter
	 *            到达地
	 * @return 距离
	 */
	public static double getDistance(String former, String latter) {
		
		if (former.equals(latter)) {
			return SAME_CITY;
		}
		
		return distance.get(former + latter);
	}
}
