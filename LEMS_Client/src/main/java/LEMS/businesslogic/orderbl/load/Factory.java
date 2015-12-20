package LEMS.businesslogic.orderbl.load;

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
			load = new AirplaneLoad();
			break;
		case Railway:
			load = new RailwayLoad();
			break;
		case Landway:
			load = new LandwayLoad();
			break;
		default:
			break;
		}
		return load;
	}
}
