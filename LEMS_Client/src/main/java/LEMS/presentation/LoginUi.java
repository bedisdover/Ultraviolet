package LEMS.presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import LEMS.businesslogic.userbl.UserLogin;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.inquireui.LogisticsInfoUi;
import LEMS.presentation.userui.BusinessClerkUi;
import LEMS.presentation.userui.CourierUi;
//import LEMS.presentation.userui.CourierUi;
import LEMS.presentation.userui.FinancialStaffUi;
import LEMS.presentation.userui.GeneralManagerUi;
import LEMS.presentation.userui.ManagerUi;
import LEMS.presentation.userui.StoreManagerUi;
import LEMS.presentation.userui.TransferClerkUi;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓 登陆界面 2015年11月18日
 */
public class LoginUi extends JPanel {
	private static final long serialVersionUID = 1L;
	
	MainFrame mainFrame;
	Image im;
	JButton but1 = new JButton("登  录");
	JButton but2 = new JButton("查询物流信息");
	JButton but3 = new JButton("关于我们");
	JLabel labName = new JLabel("账号：");
	JLabel labPassword = new JLabel("密码：");
	JTextField textName = new JTextField();
	JPasswordField textPassword = new JPasswordField();
	JLabel Return = new JLabel(new ImageIcon("Close.png"));

	public LoginUi(final MainFrame mainFrame) {
		Icon i = new ImageIcon("Return.png");
		this.mainFrame = mainFrame;
		this.setLayout(null);
		mainFrame.setDragable(this);
		labName.setBounds(313, 239, 193, 56);
		labPassword.setBounds(313, 348, 193, 56);

		Return.setBounds(920, 10, 100, 100);
		
		textName.setBounds(482, 239, 251, 56);
		textPassword.setBounds(482, 348, 251, 56);

		but1.setBounds(620, 443, 150, 45);
		but2.setBounds(785, 563, 150, 45);
		but3.setBounds(785, 643, 150, 45);

		Font fnt = new Font("Serief", Font.BOLD, 24);
		labName.setFont(fnt);
		labPassword.setFont(fnt);
		textName.setFont(fnt);
		textPassword.setFont(fnt);


		this.add(but1);
		this.add(but2);
		this.add(but3);
		this.add(labName);
		this.add(labPassword);
		this.add(textName);
		this.add(textPassword);
		this.add(Return);

		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		im = Toolkit.getDefaultToolkit().getImage("backGround.png");

		// 点击登陆按钮
		but1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				final String name = textName.getText();
				@SuppressWarnings("deprecation")
				final String password = textPassword.getText();
				UserLogin ul = new UserLogin();
				UserVO userVO = null;
				try {
					userVO=ul.login(name, password);
					if (userVO == null) {
						JOptionPane.showMessageDialog(LoginUi.this, "账号或密码错误！");
					} else {
						switch (userVO.getRole()) {
						// 登录后跳转到管理员界面
						case Manager:
							mainFrame.setContentPane(new ManagerUi(mainFrame,userVO));
							repaint();
							break;
						//登录后跳转到仓库管理员界面
						case StoreManager:
							mainFrame.setContentPane(new StoreManagerUi(mainFrame,userVO));
							repaint();
							break;
						//登录后跳转到总经理界面
						case GeneralManager:
							mainFrame.setContentPane(new GeneralManagerUi(mainFrame,userVO));
							repaint();
							break;
						//登录后跳转到财务人员界面
						case FinanceClerk:
							mainFrame.setContentPane(new FinancialStaffUi(mainFrame,userVO));
							repaint();
							break;
						//登录后跳转到快递员界面
						case Courier:
							mainFrame.setContentPane(new CourierUi(mainFrame,userVO));
							repaint();
							break;
						//登录后跳转到营业厅业务员界面
						case BusinessClerk:
							mainFrame.setContentPane(new BusinessClerkUi(mainFrame,userVO));
							repaint();
							break;
						//登录后跳转到中转中心员界面
						case TransferClerk:
							mainFrame.setContentPane(new TransferClerkUi(mainFrame,userVO));
							repaint();
							break;
						default:
							break;
						}

					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(LoginUi.this, "请检查网络连接！");
				}
			
			}
		});
		// 点击查询物流信息按钮
		but2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LogisticsInfoUi(mainFrame));
				mainFrame.setVisible(true);
			}
		});
		// 点击关于我们按钮
		but3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				mainFrame.setContentPane(new StartUi(mainFrame));
			}
		});
		Return.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}