package LEMS.presentation;

import LEMS.presentation.orderui.OrderManageUi;

public class mainSongYiming {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		OrderManageUi orderManageUi = new OrderManageUi(mainFrame);
		
		mainFrame.setContentPane(orderManageUi);
		mainFrame.setVisible(true);
	}

}
