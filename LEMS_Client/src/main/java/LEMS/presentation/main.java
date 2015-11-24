package LEMS.presentation;

import LEMS.presentation.userui.ManagerUi;
import LEMS.presentation.orderui.OrderManageUi;

public class main {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
//		StartUi jPanelStart = new StartUi(mainFrame);
//		mainFrame.setContentPane(jPanelStart);
//		JPanelLogin jPanelLogin = new JPanelLogin(mainFrame);
//		mainFrame.setContentPane(jPanelLogin);
//		ManagerUi managerUi = new ManagerUi(mainFrame);
//		mainFrame.setContentPane(managerUi);
		OrderManageUi orderManagerUi = new OrderManageUi(mainFrame);
		mainFrame.setContentPane(orderManagerUi);
	}

}
