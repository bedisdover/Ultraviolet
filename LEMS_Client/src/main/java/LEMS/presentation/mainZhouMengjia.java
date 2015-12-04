package LEMS.presentation;

import LEMS.presentation.orderui.TransferUi;
import LEMS.presentation.userui.TransferClerkUi;

public class mainZhouMengjia {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		//BusinessClerkUi s=new BusinessClerkUi(mainFrame, null);
		TransferClerkUi s=new TransferClerkUi(mainFrame,null);
		mainFrame.setContentPane(s);
	}

}
