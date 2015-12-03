package LEMS.presentation;

import LEMS.presentation.orderui.LoadUi;
import LEMS.presentation.orderui.ReceiptRecordUi;
import LEMS.presentation.userui.BusinessClerkUi;

public class mainSongYiming {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		BusinessClerkUi businessClerkUi = new BusinessClerkUi(mainFrame, null);
		mainFrame.setContentPane(businessClerkUi);
//		ReceiptRecordUi receiptRecordUi = new ReceiptRecordUi(mainFrame);
//		mainFrame.setContentPane(receiptRecordUi);
		mainFrame.setVisible(true);
	}

}
