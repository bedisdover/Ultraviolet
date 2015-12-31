package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import LEMS.businesslogic.orderbl.Distance;

import java.util.Map.Entry;

/**
 * @author 宋益明
 * 
 * 服务城市范围
 */
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//TODO 存储到数据库
	public static List<String> cityList = new ArrayList<String>();
	
	static {
		cityList.add("北京");
		cityList.add("上海");
		cityList.add("南京");
		cityList.add("广州");
	}
	
	/**
	 * 添加新城市，需要给定与其他所有城市间的距离
	 * 
	 * @param city 城市名称
	 * @param distance 与其他所有城市之间的距离
	 */
	public static void addCity(String city, HashMap<String, Double> distance) {
		cityList.add(city);

		Distance d = new Distance();
		
		Set<Entry<String, Double>> temp = distance.entrySet();
		
		for (Entry<String, Double> e : temp) {
			d.setDistance(e.getKey(), city, e.getValue());
		}
	}
	
	/**
	 * 判断城市是否在服务范围内
	 * 
	 * @param address 目的地
	 * @return 若在城市范围内，返回true，否则返回false
	 */
	public static boolean legalCity(String address) {
		if (address.length() < 3) {
			return false;
		}
		
		for (String city : cityList) {
			if (address.startsWith(city)) {
				return true;
			}
		}
		
		return false;
	}
}
