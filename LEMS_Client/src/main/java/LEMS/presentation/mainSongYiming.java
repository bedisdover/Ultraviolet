package LEMS.presentation;

import LEMS.presentation.orderui.LoadUi;
import LEMS.presentation.orderui.ReceiptRecordUi;
import LEMS.presentation.userui.BusinessClerkUi;
import LEMS.presentation.userui.TransferClerkUi;

public class mainSongYiming {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
//		BusinessClerkUi businessClerkUi = new BusinessClerkUi(mainFrame, null);
//		mainFrame.setContentPane(businessClerkUi);
//		ReceiptRecordUi receiptRecordUi = new ReceiptRecordUi(mainFrame);
//		mainFrame.setContentPane(receiptRecordUi);
		TransferClerkUi transferClerkUi = new TransferClerkUi(mainFrame, null);
		mainFrame.setContentPane(transferClerkUi);
		mainFrame.setVisible(true);
	}

}
