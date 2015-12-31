package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋益明
 * 
 * 服务城市范围
 */
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static List<String> cityList = new ArrayList<String>();
	
	static {
		cityList.add("北京");
		cityList.add("上海");
		cityList.add("南京");
		cityList.add("广州");
	}
	
	/**
	 * 添加新城市
	 * 
	 * @param city
	 * @param distance
	 */
	public static void addCity(String city, ArrayList<Double> distance) {
		cityList.add(city);
	}
	
	/**
	 * 判断城市是否在服务范围内
	 * 
	 * @param city 城市
	 * @return 若在城市范围内，返回true，否则返回false
	 */
	public static boolean legalCity(String city) {
		if (cityList.contains(city)) {
			return true;
		}
		
		return false;
	}
}
