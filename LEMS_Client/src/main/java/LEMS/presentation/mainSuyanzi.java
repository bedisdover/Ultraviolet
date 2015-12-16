package LEMS.presentation;

import LEMS.presentation.financeui.ExamDocumentUi;
import LEMS.vo.uservo.UserVO;

public class mainSuyanzi {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		UserVO user = null;
//		ManagerUi a = new ManagerUi(mainFrame,user);
//		FinancialStaffUi a = new FinancialStaffUi(mainFrame,user);
//		GeneralManagerUi a = new GeneralManagerUi(mainFrame,user);
//		AccountManageUi a = new AccountManageUi(mainFrame,user);
//		TransferClerkUi a = new TransferClerkUi(mainFrame,user);
//		CourierUi a = new CourierUi(mainFrame);
		ExamDocumentUi a = new ExamDocumentUi(mainFrame,user);
		mainFrame.setContentPane(a);
	}

}
