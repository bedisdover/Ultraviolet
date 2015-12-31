package LEMS.presentation.userui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import LEMS.presentation.MainFrame;
import LEMS.presentation.orderui.ReceiveUi;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓 快递员界面（订单管理界面） 2015年12月12日
 */
public class CourierUi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame mainFrame;

	private OrderManageUi orderManageUi;
	private JTabbedPane tabbedPane;
	private ReceiveUi receiveUi;
	private UserVO user;

	public CourierUi(final MainFrame mainFrame,UserVO uvo) {
		user=uvo;
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		orderManageUi = new OrderManageUi(mainFrame,user);
		receiveUi = new ReceiveUi(mainFrame,user);
		this.init();
		this.initComponent();
	}

	private void init() {
		tabbedPane = new JTabbedPane(); 
		ImageIcon image1=new ImageIcon("source\\tabbedpanel\\订单管理.png");
		ImageIcon image2=new ImageIcon("source\\tabbedpanel\\接收订单.png");
		
		tabbedPane.addTab(null,image1,orderManageUi,"订单管理");
		tabbedPane.addTab(null,image2,receiveUi,"接收订单");

	}

	private void initComponent() {
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		this.add(tabbedPane);
	}

}
