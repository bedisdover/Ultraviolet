package LEMS.presentation;

import LEMS.presentation.orderui.LoadUi;
import LEMS.presentation.orderui.ReceiptRecordUi;

public class mainSongYiming {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
//		LoadUi loadUi = new LoadUi(mainFrame);
//		mainFrame.setContentPane(loadUi);
		ReceiptRecordUi receiptRecordUi = new ReceiptRecordUi(mainFrame);
		mainFrame.setContentPane(receiptRecordUi);
		mainFrame.setVisible(true);
	}

}
