package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.AddOrderService_Stub;

public class AddOrderService_Driver {
	
	public void drive(AddOrderService_Stub addOrderService_Stub) {
		addOrderService_Stub.addOrder(123456);
	}
}
