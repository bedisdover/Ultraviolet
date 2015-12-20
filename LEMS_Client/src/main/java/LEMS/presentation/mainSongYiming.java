package LEMS.presentation;

import LEMS.presentation.orderui.LoadUi2;
import LEMS.presentation.userui.OrderManageUi;
import LEMS.presentation.userui.TransferClerkUi;

public class mainSongYiming {

	public static void main(String[] args) {
		//bc0211000001
		MainFrame mainFrame = new MainFrame();
//		BusinessClerkUi businessClerkUi = new BusinessClerkUi(mainFrame, null);
//		mainFrame.setContentPane(businessClerkUi);
//		ReceiveUi receiveUi = new ReceiveUi(mainFrame, null);
//		mainFrame.setContentPane(receiveUi);
		TransferClerkUi transferClerkUi = new TransferClerkUi(mainFrame, null);
		mainFrame.setContentPane(transferClerkUi);
//		ManagerUi managerUi = new ManagerUi(mainFrame, null);
//		mainFrame.setContentPane(managerUi);
//		FinancialStaffUi financialStaffUi = new FinancialStaffUi(mainFrame, null);
//		mainFrame.setContentPane(financialStaffUi);
//		SettlementUi settlementUi = new SettlementUi(mainFrame);
//		mainFrame.setContentPane(settlementUi);
//		SendUi sendUi = new SendUi(mainFrame, null);
//		mainFrame.setContentPane(sendUi);
//		CourierUi courierUi = new CourierUi(mainFrame);
//		mainFrame.setContentPane(courierUi);
//		LoadUi loadUi = new LoadUi(mainFrame, null);
//		mainFrame.setContentPane(loadUi);
//		VehicleLoadUi vehicleLoadUi = new VehicleLoadUi(mainFrame, null);
//		mainFrame.setContentPane(vehicleLoadUi);
//		TransferUi transferUi = new TransferUi(mainFrame, null);
//		mainFrame.setContentPane(transferUi);
//		OrderManageUi orderManageUi = new OrderManageUi(mainFrame, null);
//		mainFrame.setContentPane(orderManageUi);
//		LoadUi2 loadUi2 = new LoadUi2(mainFrame, null);
//		mainFrame.setContentPane(loadUi2);
		mainFrame.setVisible(true);
		
		
//		AddOrder addOrder = new AddOrder();
//		OrderPO orderPO = addOrder.findOrder("1234567890");
//		System.out.println(orderPO.getAmount());
//		System.out.println("done");
	}

}
