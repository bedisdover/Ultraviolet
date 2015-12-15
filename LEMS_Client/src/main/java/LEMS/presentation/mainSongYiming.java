package LEMS.presentation;

import LEMS.presentation.orderui.ReceiveUi;
import LEMS.presentation.orderui.VehicleLoadUi;
import LEMS.presentation.userui.BusinessClerkUi;

public class mainSongYiming {

	public static void main(String[] args) {
		//bc0211000001
		MainFrame mainFrame = new MainFrame();
//		BusinessClerkUi businessClerkUi = new BusinessClerkUi(mainFrame, null);
//		mainFrame.setContentPane(businessClerkUi);
//		ReceiveUi receiveUi = new ReceiveUi(mainFrame, null);
//		mainFrame.setContentPane(receiveUi);
//		TransferClerkUi transferClerkUi = new TransferClerkUi(mainFrame, null);
//		mainFrame.setContentPane(transferClerkUi);
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
		VehicleLoadUi vehicleLoadUi = new VehicleLoadUi(mainFrame, null);
		mainFrame.setContentPane(vehicleLoadUi);
		mainFrame.setVisible(true);
		
		
//		AddOrder addOrder = new AddOrder();
//		OrderPO orderPO = addOrder.findOrder("1234567890");
//		System.out.println(orderPO.getAmount());
//		System.out.println("done");
	}

}
