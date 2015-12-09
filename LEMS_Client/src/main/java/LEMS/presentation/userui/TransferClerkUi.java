package LEMS.presentation.userui;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import LEMS.presentation.MainFrame;
import LEMS.presentation.orderui.LoadUi;
import LEMS.presentation.orderui.ReceiveUi;
import LEMS.presentation.orderui.TransferUi;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳 中转中心业务员界面 中转接收 装运管理
 */
public class TransferClerkUi extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTabbedPane tabbedPane;
	private TransferUi transferUi;
	private LoadUi loadUi;
	private ReceiveUi receiveUi;

	public TransferClerkUi(final MainFrame mainFrame, UserVO user) {
		transferUi = new TransferUi(mainFrame, user);
		loadUi = new LoadUi(mainFrame);
		receiveUi = new ReceiveUi(mainFrame, user);

		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);

		this.init();
		this.initComponents();
	}

	private void init() {
		tabbedPane = new JTabbedPane();
		ImageIcon image1 = new ImageIcon("source\\tabbedpanel\\中转接收.png");
		ImageIcon image2 = new ImageIcon("source\\tabbedpanel\\装运管理.png");
		ImageIcon image3 = new ImageIcon("source\\tabbedpanel\\接收.png");

		// tabbedPane.addTab(title, icon, component, tip);
		// 添加由 title 和/或 icon 表示的 component 和 tip，其中任意一个都可以为 null。

		tabbedPane.addTab(null, image1, transferUi, "中转接收");
		tabbedPane.addTab(null, image2, loadUi, "装运管理");
		tabbedPane.addTab(null, image3, receiveUi, "接收");
	}

	private void initComponents() {
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		this.add(tabbedPane);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
