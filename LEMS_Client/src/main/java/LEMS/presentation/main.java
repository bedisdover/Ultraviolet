package ui;

public class main {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		JPanelStart jPanelStart = new JPanelStart(mainFrame);
		mainFrame.setContentPane(jPanelStart);
//		JPanelLogin jPanelLogin = new JPanelLogin(mainFrame);
//		mainFrame.setContentPane(jPanelLogin);
	}

}
