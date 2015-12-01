package LEMS.presentation;

import LEMS.presentation.userui.BusinessClerkUi;

public class mainZhouMengjia {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		BusinessClerkUi s=new BusinessClerkUi(mainFrame);
		mainFrame.setContentPane(s);
	}

}
