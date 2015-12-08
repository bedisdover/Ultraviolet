package LEMS.presentation;

import java.util.ArrayList;

import LEMS.businesslogic.orderbl.AddOrder;
import LEMS.presentation.orderui.LoadUi;
import LEMS.presentation.orderui.ReceiptRecordUi;
import LEMS.presentation.orderui.ReceiveUi;
import LEMS.presentation.userui.BusinessClerkUi;
import LEMS.presentation.userui.ManagerUi;
import LEMS.presentation.userui.TransferClerkUi;

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
//		mainFrame.setVisible(true);
		
		AddOrder addOrder = new AddOrder();
		addOrder.findOrder("1234567890");
		System.out.println("done");
	}

}
