package LEMS.presentation;

import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.storeui.StoreCheckUi;
import LEMS.vo.uservo.UserVO;

public class mainSuyanzi {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
//		UserVO user = null;
		InstitutionPO i = new InstitutionPO("234234234","zhutou");
		UserVO user = new UserVO("123123123123","susu",UserRole.StoreManager,"suyanzi",i);
//		ManagerUi a = new ManagerUi(mainFrame,user);
//		FinancialStaffUi a = new FinancialStaffUi(mainFrame,user);
//		GeneralManagerUi a = new GeneralManagerUi(mainFrame,user);
//		AccountManageUi a = new AccountManageUi(mainFrame,user);
//		TransferClerkUi a = new TransferClerkUi(mainFrame,user);
//		ExamDocumentUi a = new ExamDocumentUi(mainFrame,user);
//		SettingPriceUi a = new SettingPriceUi(mainFrame,user);
//		CourierUi a = new CourierUi(mainFrame,user);
//		ExamDocumentUi a = new ExamDocumentUi(mainFrame,user);
//		StatisticsReportUi a = new StatisticsReportUi(mainFrame,user);
//		AccountManageUi a = new AccountManageUi(mainFrame,user);
		StoreCheckUi a=new StoreCheckUi(mainFrame,user);
		
		mainFrame.setContentPane(a);
	}

}
