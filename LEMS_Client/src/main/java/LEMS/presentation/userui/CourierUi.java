package LEMS.presentation.userui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import LEMS.presentation.MainFrame;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓 快递员界面（订单管理界面） 2015年12月12日
 */
public class CourierUi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OrderManageUi orderManageUi;
	private JTabbedPane tabbedPane;
	private OrderReceiveUi orderReceiveUi;

	public CourierUi(final MainFrame mainFrame, UserVO user) {
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);

		orderManageUi = new OrderManageUi(mainFrame, user);
		orderReceiveUi = new OrderReceiveUi(mainFrame, user);
		this.init();
		this.initComponent();
	}

	private void init() {
		tabbedPane = new JTabbedPane();
		ImageIcon image1 = new ImageIcon("source\\tabbedpanel\\订单管理.png");
		ImageIcon image2 = new ImageIcon("source\\tabbedpanel\\接收订单.png");

		tabbedPane.addTab(null, image1, orderManageUi, "订单管理");
		tabbedPane.addTab(null, image2, orderReceiveUi, "接收订单");
	}

	private void initComponent() {
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		this.add(tabbedPane);
	}

}
