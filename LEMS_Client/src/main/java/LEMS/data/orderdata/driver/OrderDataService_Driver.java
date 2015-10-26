package LEMS.data.orderdata.driver;

import java.rmi.RemoteException;

import LEMS.data.orderdata.stub.OrderDataService_Stub;
import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * Order包DataService驱动程序
 */
public class OrderDataService_Driver {
	public void drive(OrderDataService_Stub orderDataService_Stub) {
		try {
			orderDataService_Stub.init();
			OrderPO order = orderDataService_Stub.find(123456);
			orderDataService_Stub.insert(order);
			orderDataService_Stub.update(order);
			orderDataService_Stub.delete(order);
			orderDataService_Stub.finish();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
