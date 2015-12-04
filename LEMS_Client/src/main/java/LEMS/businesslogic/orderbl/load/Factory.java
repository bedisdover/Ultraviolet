package LEMS.businesslogic.orderbl.load;

import LEMS.po.orderpo.TransportType;

public class Factory {
	/**
	 * 根据运输类型建立不同的类
	 * 
	 * @param type 运输类型
	 */
	public Load createLoad(TransportType type) {
		
		Load load = null;
		
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
		}
		
		return load;
	}
}
