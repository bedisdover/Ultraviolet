package LEMS.presentation;

import LEMS.presentation.userui.BusinessClerkUi;
import LEMS.presentation.userui.FinancialStaffUi;
import LEMS.presentation.userui.GeneralManagerUi;
import LEMS.presentation.userui.ManagerUi;
import LEMS.presentation.userui.TransferClerkUi;
import LEMS.vo.uservo.UserVO;

public class mainSuyanzi {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		UserVO user = null;
//		ManagerUi a = new ManagerUi(mainFrame,user);
//		FinancialStaffUi a = new FinancialStaffUi(mainFrame,user);
//		GeneralManagerUi a = new GeneralManagerUi(mainFrame,user);
//		TransferClerkUi a = new TransferClerkUi(mainFrame,user);
		ManagerUi a = new ManagerUi(mainFrame,user);
		mainFrame.setContentPane(a);
	}

}
