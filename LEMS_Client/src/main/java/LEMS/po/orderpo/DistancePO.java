package LEMS.po.orderpo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author 宋益明
 * 
 *         用于获得各城市间距离（非静态数据） 使用前必须初始化
 */
@SuppressWarnings("serial")
public class DistancePO implements Serializable {

	private HashMap<String, Double> cityDistance;

	public DistancePO() {
		cityDistance = new HashMap<String, Double>();
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
	public double getDistance(String former, String latter) {
		return cityDistance.get(transfer(former, latter));
	}

	/**
	 * 更新城市间距离
	 * 
	 * @param former
	 *            出发地
	 * @param latter
	 *            目的地
	 * @param value
	 *            距离
	 */
	public void setDistance(String former, String latter, double value) {
		cityDistance.put(transfer(former, latter), value);
	}

	/**
	 * 将出发地与目的地转化为可识别字符串
	 * 
	 * @param former
	 *            出发地
	 * @param latter
	 *            目的地
	 * @return 可识别字符串（地址表中存储的字符串）
	 */
	private String transfer(String former, String latter) {
		former = former.substring(0, 2);
		latter = latter.substring(0, 2);
		
		String temp = "";

		if (former.equals(latter)) {
			// 同一城市
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
