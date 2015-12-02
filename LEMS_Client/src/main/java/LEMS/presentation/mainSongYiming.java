package LEMS.presentation;

import LEMS.presentation.orderui.LoadUi;

public class mainSongYiming {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		LoadUi loadUi = new LoadUi(mainFrame);
		mainFrame.setContentPane(loadUi);
		mainFrame.setVisible(true);
	}

}
