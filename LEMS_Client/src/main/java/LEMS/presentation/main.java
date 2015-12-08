package LEMS.presentation;


/**
 * @author 苏琰梓
 *
 */
public class main {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		StartUi jPanelStart = new StartUi(mainFrame);
		mainFrame.setContentPane(jPanelStart);
	}

}
