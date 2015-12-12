package LEMS.presentation;

import LEMS.presentation.inquireui.LogisticsInfoUi;
import LEMS.presentation.userui.CourierUi;
import LEMS.vo.uservo.UserVO;

public class mainSuyanzi {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		UserVO user = null;
//		ManagerUi a = new ManagerUi(mainFrame,user);
//		FinancialStaffUi a = new FinancialStaffUi(mainFrame,user);
//		AccountManageUi a = new AccountManageUi(mainFrame,user);
//		TransferClerkUi a = new TransferClerkUi(mainFrame,user);
		CourierUi a = new CourierUi(mainFrame);
		mainFrame.setContentPane(a);
	}

}
