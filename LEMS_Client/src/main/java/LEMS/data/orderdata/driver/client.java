package LEMS.data.orderdata.driver;

import LEMS.data.orderdata.stub.OrderDataService_Stub;

/**
 * @author 宋益明
 * 
 * 运行OrderDataService驱动程序
 */
public class client {
	
	public static void main(String[] args) {
		OrderDataService_Driver orderDataService_Driver = new OrderDataService_Driver();
		orderDataService_Driver.drive(new OrderDataService_Stub());
	}
}
