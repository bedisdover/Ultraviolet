package LEMS.vo.inquirevo;

import java.util.ArrayList;

/**
 * @author 章承尧
 * LogisticsInfo的值对象
 */
public class LogisticsInfoVO {
	/**
	 * 订单编号
	 */
	long id;
	/**
	 * 快递的物流轨迹
	 */
	ArrayList<String> trace;
	
	public LogisticsInfoVO(long i,ArrayList<String> t){
		id=i;
		trace=t;
	}
	public long getId(){
		return id;
	}
	public ArrayList<String> getTrace(){
		return trace;
	}
}
