package LEMS.businesslogic.orderbl.transfer;

import LEMS.po.orderpo.OrderPO;
import LEMS.po.storepo.TransportType;
import LEMS.po.userpo.UserPO;
import LEMS.vo.uservo.UserVO;

public class TransferController {

	private Transfer transfer;

	private UserVO user;

	public TransferController(UserVO user, TransportType type) {
		this.user = user;
	}
	
	public void setDeparture(String departure) {
		
	}
	
	public void setDestination(String destination) {
		
	}
	
	public void setSuperVision(UserPO superVision) {
		
	}
	
	
	public void addOrder(OrderPO order) {

	}

	public void createLoadNote() {

	}
}
