package LEMS.presentation;

import LEMS.presentation.orderui.LoadUi;
import LEMS.presentation.orderui.ReceiptRecordUi;
import LEMS.presentation.userui.BusinessClerkUi;
import LEMS.presentation.userui.ManagerUi;
import LEMS.presentation.userui.TransferClerkUi;

public class mainSongYiming {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
//		BusinessClerkUi businessClerkUi = new BusinessClerkUi(mainFrame, null);
//		mainFrame.setContentPane(businessClerkUi);
		TransferClerkUi transferClerkUi = new TransferClerkUi(mainFrame, null);
		mainFrame.setContentPane(transferClerkUi);
//		ManagerUi managerUi = new ManagerUi(mainFrame, null);
//		mainFrame.setContentPane(managerUi);
		mainFrame.setVisible(true);
	}

}
