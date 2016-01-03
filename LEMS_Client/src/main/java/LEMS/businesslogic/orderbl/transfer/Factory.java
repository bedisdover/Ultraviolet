package LEMS.businesslogic.orderbl.transfer;

import LEMS.po.storepo.TransportType;

public class Factory {

	public static Factory factory;

	static {
		factory = new Factory();
	}

	private Factory() {
	}

	/**
	 * 根据运输类型建立不同的类
	 * 
	 * @param type
	 *            运输类型
	 */
	public static Passage createPassage(TransportType type) {

		Passage transfer = null;

		switch (type) {
		case Airplane:
			transfer = new AirplaneTransfer();
			break;
		case Railway:
			transfer = new RailwayTransfer();
			break;
		case Landway:
			transfer = new LandwayTransfer();
			break;
		default:
			break;
		}
		return transfer;
	}
}
