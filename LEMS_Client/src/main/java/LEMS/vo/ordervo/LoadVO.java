package LEMS.vo.ordervo;

import java.util.ArrayList;

public class LoadVO {
	/**
	 * 装运日期
	 */
	private String date;
	/**
	 * 装运编号
	 */
	private long id;
	/**
	 * 订单列表
	 */
	private ArrayList<Long> orders;
	/**
	 * 目的地
	 */
	private String destination;
	//TODO 添加车辆代号、运输方式
}
