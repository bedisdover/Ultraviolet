package LEMS.businesslogic.orderbl.stub;

import LEMS.businesslogicservice.orderblservice.AddOrderService;

public class AddOrderService_Stub implements AddOrderService {

	public void addOrder(long id) {
		System.out.println("添加订单成功！");
	}

}
