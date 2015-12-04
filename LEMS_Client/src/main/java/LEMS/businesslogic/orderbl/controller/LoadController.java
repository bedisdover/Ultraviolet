package LEMS.businesslogic.orderbl.controller;

import LEMS.businesslogic.orderbl.load.Load;
import LEMS.po.orderpo.LoadNotePO;
import LEMS.po.orderpo.OrderPO;

public class LoadController extends Controller {

	private Load load;
	
	private LoadNotePO loadNotePO;
	
	public LoadController() {
		//TODO 根据运输类型建立不同的类
		//load = new Load();
		loadNotePO = new LoadNotePO();
	}
	
	public void addOrder(OrderPO order) {
		load.addOrder(order.getId());
	}
	
	public void createLoadNote() {
		
	}
}
