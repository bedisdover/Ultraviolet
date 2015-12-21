package LEMS.businesslogic.orderbl.controller;

import java.util.Date;

import LEMS.businesslogic.orderbl.transfer.Factory;
import LEMS.businesslogic.orderbl.transfer.Transfer;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.transfer.LoadNotePO;
import LEMS.po.storepo.TransportType;
import LEMS.po.userpo.UserPO;
import LEMS.vo.uservo.UserVO;

public class LoadController extends Controller {

	private Transfer load;

	private UserVO user;

	public LoadController(UserVO user, TransportType type) {
		this.user = user;

		load = new Factory().createLoad(type);
	}
	
	public void setDeparture(String departure) {
		
	}
	
	public void setDestination(String destination) {
		
	}
	
	public void setSuperVision(UserPO superVision) {
		
	}
	
	
	public void addOrder(OrderPO order) {
		load.addOrder(order.getId());
	}

	public void createLoadNote() {

	}
}
