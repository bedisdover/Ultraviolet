package LEMS.vo.ordervo;

import LEMS.po.storepo.TransportType;

/**
 * @author 宋益明
 * 
 * 中转单值对象
 * 包括：	中转日期、到达地、运输方式
 * 		航班号（飞机）或车次号（火车、汽车）、
 * 		货柜号（飞机）或车厢号（火车）或押运员（汽车）、
 * 		监装员
 */
public class TransferVO {
	
	/**
	 * 中转日期
	 */
	private String date;
	
	/**
	 * 到达地
	 */
	private String destination;
	
	/**
	 * 运输方式
	 */
	private TransportType type;
	
	/**
	 * 航班号（或车次号）
	 */
	private String flight;
	
	/**
	 * 货柜号（或车厢号、或押运员）
	 */
	private String container;
	
	/**
	 * 监装员
	 */
	private String superVision;

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String getFlight() {
		return flight;
	}

	public String getContainer() {
		return container;
	}

	public String getSuperVision() {
		return superVision;
	}

	public TransportType getType() {
		return type;
	}
	
	public void setType(TransportType type) {
		this.type = type;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public void setSuperVision(String superVision) {
		this.superVision = superVision;
	}
}