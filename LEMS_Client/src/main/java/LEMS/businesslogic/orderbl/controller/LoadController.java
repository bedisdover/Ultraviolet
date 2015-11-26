package LEMS.businesslogic.orderbl.controller;

import LEMS.businesslogic.orderbl.Load;
import LEMS.po.orderpo.OrderPO;

public class LoadController extends Controller {

	/**
	 * 
	 */
	private Load load;
	
	public LoadController() {
		// TODO Auto-generated constructor stub
		load = new Load();
	}
	
	public void addOrder(OrderPO order) {
		load.addOrder(order.getId());
	}
	
}
