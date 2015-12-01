package LEMS.po.orderpo;

import java.util.HashMap;

/**
 * @author 宋益明
 * 
 * 用于获得各城市间距离（非静态数据）
 */
public class DistancePO {

	//TODO 忽然发现总经理居然还可以制定城市间距离，我也是醉了
	
	private HashMap<String, Double> cityDistance;
	
	public DistancePO() {
		cityDistance = new HashMap<String, Double>();
	}
	
//	/**
//	 * 存储距离常量
//	 */
//	static Map<String, Double> distance;

//	static {
//		distance = new HashMap<String, Double>();
//		distance.put("北京上海", 1064.7);
//		distance.put("上海北京", 1064.7);
//		distance.put("北京广州", 1888.8);
//		distance.put("广州北京", 1888.8);
//		distance.put("北京南京", 900.0);
//		distance.put("南京北京", 900.0);
//		distance.put("上海广州", 1213.0);
//		distance.put("广州上海", 1213.0);
//		distance.put("上海南京", 266.0);
//		distance.put("南京上海", 266.0);
//		distance.put("广州南京", 1132.0);
//		distance.put("南京广州", 1132.0);
//	}

	/**
	 * 返回城市间距离
	 * 
	 * @param former
	 *            出发地
	 * @param latter
	 *            到达地
	 * @return 距离
	 */
	public double getDistance(String former, String latter) {
		return cityDistance.get(transfer(former, latter));
	}
	
	/**
	 * 更新城市间距离
	 * 
	 * @param former 出发地
	 * @param latter 目的地
	 * @param value 距离
	 */
	public void setDistance(String former, String latter, double value) {
		cityDistance.put(transfer(former, latter), value);
	}
	
	/**
	 * 将出发地与目的地转化为可识别字符串
	 * 
	 * @param former 出发地
	 * @param latter 目的地
	 * @return 可识别字符串（地址表中存储的字符串）
	 */
	private String transfer(String former, String latter) {
		String temp = "";
		
		if (former.equals(latter)) {
			//同一城市
			temp = "sameCity";
		} else if (cityDistance.containsKey(former + latter)) {
			temp = former + latter;
		} else {
			temp = latter + former;
		}
		
		return temp;
	}

	public HashMap<String, Double> getCityDistance() {
		return cityDistance;
	}

	public void setCityDistance(HashMap<String, Double> cityDistance) {
		this.cityDistance = cityDistance;
	}
}
