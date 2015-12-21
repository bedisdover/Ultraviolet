package LEMS.businesslogic.orderbl.transfer;

import LEMS.po.storepo.TransportType;

public class Factory {
	/**
	 * 根据运输类型建立不同的类
	 * 
	 * @param type 运输类型
	 */
	public Passage createLoad(TransportType type) {
		
		Passage load = null;
		
		switch (type) {
		case Airplane:
			load = new AirplaneTransfer();
			break;
		case Railway:
			load = new RailwayTransfer();
			break;
		case Landway:
			load = new LandwayTransfer();
			break;
		default:
			break;
		}
		return load;
	}
}
