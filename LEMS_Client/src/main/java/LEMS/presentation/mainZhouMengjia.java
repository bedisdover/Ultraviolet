package LEMS.presentation;

import LEMS.presentation.userui.BusinessClerkUi;

public class mainZhouMengjia {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		BusinessClerkUi s=new BusinessClerkUi(mainFrame, null);
		//TransferClerkUi s=new TransferClerkUi(mainFrame,null);
		//StoreManagerUi s=new StoreManagerUi(mainFrame,null);
		//ManagerUi s=new ManagerUi(mainFrame,null);
		mainFrame.setContentPane(s);
	}

}
