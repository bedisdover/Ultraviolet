package LEMS.businesslogic.orderbl.controller;

import LEMS.businesslogic.orderbl.Load;
import LEMS.po.orderpo.OrderPO;

public class LoadController extends Controller {

	/**
	 * 
	 */
	private Load load;
	
	public LoadController() {
		load = new Load();
	}
	
	public void addOrder(OrderPO order) {
		load.addOrder(order.getId());
	}
	
	public void createLoadNote() {
		
	}
}
