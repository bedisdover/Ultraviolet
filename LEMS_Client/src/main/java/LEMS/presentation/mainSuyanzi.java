package LEMS.presentation;

import LEMS.presentation.userui.ManagerUi;
import LEMS.vo.uservo.UserVO;

public class mainSuyanzi {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		UserVO user = null;
		ManagerUi a = new ManagerUi(mainFrame,user);
		mainFrame.setContentPane(a);
	}

}
