package LEMS.presentation;

import LEMS.po.userpo.UserRole;
import LEMS.presentation.financeui.SettlementUi;
import LEMS.vo.uservo.UserVO;

public class mainSongYiming {

	public static void main(String[] args) {
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
		SettlementUi settlementUi = new SettlementUi(mainFrame, new UserVO("bc0211000000", "123456", UserRole.FinanceClerk, "", null));
		mainFrame.setContentPane(settlementUi);
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
//		OrderManageUi orderManageUi = new OrderManageUi(mainFrame, new UserVO("c0210000000", "123456", UserRole.Courier, "米拉娜", new InstitutionPO("0210000", "上海市浦东新区23号")));
//		mainFrame.setContentPane(orderManageUi);
//		ExamDocumentUi examDocumentUi = new ExamDocumentUi(mainFrame, new UserVO("bc0211000000", "123456", UserRole.Manager, "", null));
//		mainFrame.setContentPane(examDocumentUi);
//		CourierUi courierUi = new CourierUi(mainFrame);
//		mainFrame.setContentPane(courierUi);
//		LoadUi2 loadUi2 = new LoadUi2(mainFrame, null);
//		mainFrame.setContentPane(loadUi2);
//		ReceiptRecordUi receiptRecordUi = new ReceiptRecordUi(mainFrame, null);
//		mainFrame.setContentPane(receiptRecordUi);
		mainFrame.setVisible(true);
		
		
//		AddOrder addOrder = new AddOrder();
//		OrderPO orderPO = addOrder.findOrder("1234567890");
//		System.out.println(orderPO.getAmount());
//		System.out.println("done");
	}

}
