package LEMS.businesslogic.orderbl.transfer;

/**
 * @author 宋益明
 * 
 * 负责实现运费计算任务（中转）
 * 具体交由AirplaneLoad、LandwayLoad、RailwayLoad三个类实现
 * 分别负责 航运、陆运、铁运 三项
 */
public interface Passage {
	/**
	 * 计算运费
	 * 
	 * @param departure 出发地
	 * @param destination 目的地
	 * @return 运费
	 */
	public double calculateMessage(String departure, String destination);
}
