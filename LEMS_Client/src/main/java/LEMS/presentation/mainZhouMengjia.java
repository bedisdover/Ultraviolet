package LEMS.presentation;

import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.userui.StoreManagerUi;
import LEMS.vo.uservo.UserVO;

public class mainZhouMengjia {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		//BusinessClerkUi s=new BusinessClerkUi(mainFrame, null);
		//TransferClerkUi s=new TransferClerkUi(mainFrame,null);
		StoreManagerUi s=new StoreManagerUi(mainFrame,new UserVO("sm02100000000", "123456", UserRole.StoreManager, "米波", new InstitutionPO("", "")));
		//ManagerUi s=new ManagerUi(mainFrame,null);
		mainFrame.setContentPane(s);
	}

}
