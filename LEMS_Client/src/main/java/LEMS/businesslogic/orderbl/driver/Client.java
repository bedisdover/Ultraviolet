package LEMS.businesslogic.orderbl.driver;

import LEMS.businesslogic.orderbl.stub.AddOrderService_Stub;
import LEMS.businesslogic.orderbl.stub.LoadService_Stub;
import LEMS.businesslogic.orderbl.stub.OrderService_Stub;
import LEMS.businesslogic.orderbl.stub.ReceiptRecordService_Stub;
import LEMS.businesslogic.orderbl.stub.ReceiptService_Stub;
import LEMS.businesslogic.orderbl.stub.SendingService_Stub;
import LEMS.businesslogic.orderbl.stub.TransferService_Stub;
import LEMS.businesslogic.orderbl.stub.VehicleLoadService_Stub;

/**
 * @author 宋益明
 *
 */
public class Client {
	
	public static void main(String[] args) {
		System.out.println("装运管理任务：");
		LoadService_Driver load = new LoadService_Driver();
		load.drive(new LoadService_Stub());
		System.out.println();
		
		System.out.println("订单管理任务：");
		OrderService_Driver order = new OrderService_Driver();
		order.drive(new OrderService_Stub());
		System.out.println();
		
		System.out.println("记录收款单任务：");
		ReceiptRecordService_Driver receiptRecord = new ReceiptRecordService_Driver();
		receiptRecord.drive(new ReceiptRecordService_Stub());
		System.out.println();
		
		System.out.println("接收任务：");
		ReceiptService_Driver receipt = new ReceiptService_Driver();
		receipt.drive(new ReceiptService_Stub());
		System.out.println();
		
		System.out.println("派件任务：");
		SendingService_Driver sending = new SendingService_Driver();
		sending.drive(new SendingService_Stub());
		System.out.println();
		
		System.out.println("中转接收任务：");
		TransferService_Driver transfer = new TransferService_Driver();
		transfer.drive(new TransferService_Stub());
		System.out.println();
		
		System.out.println("添加订单任务：");
		AddOrderService_Driver addOrder = new AddOrderService_Driver();
		addOrder.drive(new AddOrderService_Stub());
		System.out.println();
		
		System.out.println("车辆装车管理：");
		VehicleLoadService_Driver vehicleLoad = new VehicleLoadService_Driver();
		vehicleLoad.drive(new VehicleLoadService_Stub());
	}
}
