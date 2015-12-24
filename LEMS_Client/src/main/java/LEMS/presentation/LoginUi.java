package LEMS.presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import LEMS.businesslogic.userbl.UserLogin;
import LEMS.po.userpo.UserRole;
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
	JButton but1 = new JButton("登录");
	JButton but2 = new JButton("返回");
	JLabel labName = new JLabel("账号：");
	JLabel labPassword = new JLabel("密码：");
	JTextField textName = new JTextField();
	JPasswordField textPassword = new JPasswordField();


	public LoginUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(null);
		mainFrame.setDragable(this);
		labName.setBounds(313, 249, 193, 56);
		labPassword.setBounds(313, 378, 193, 56);

		textName.setBounds(482, 249, 251, 56);
		textPassword.setBounds(482, 378, 251, 56);

		but1.setBounds(280, 543, 150, 45);
		but2.setBounds(655, 543, 150, 45);

		Font fnt = new Font("Serief", Font.BOLD, 24);
		labName.setFont(fnt);
		labPassword.setFont(fnt);
		textName.setFont(fnt);
		textPassword.setFont(fnt);


		this.add(but1);
		this.add(but2);
		this.add(labName);
		this.add(labPassword);
		this.add(textName);
		this.add(textPassword);

		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		im = Toolkit.getDefaultToolkit().getImage("01.jpg");

		// 点击登陆按钮
		but1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				final String name = textName.getText();
				@SuppressWarnings("deprecation")
				final String password = textPassword.getText();
				UserLogin ul = new UserLogin();
				UserVO userVO = null;
				userVO=ul.login(name, password);
//				switch (role) {
				//TODO 更改选项，添加提示“网络连接”
//				case "管理员":
//					userVO = ul.login(name, password, UserRole.Manager);
//					break;
//				case "总经理":
//					userVO = ul.login(name, password, UserRole.GeneralManager);
//					break;
//				case "仓库管理人员":
//					userVO = ul.login(name, password, UserRole.StoreManager);
//					break;
//				case "财务人员":
//					userVO = ul.login(name, password, UserRole.FinanceClerk);
//					break;
//				case "快递员":
//					userVO = ul.login(name, password, UserRole.Courier);
//					break;
//				case "营业厅业务员":
//					userVO = ul.login(name, password, UserRole.BusinessClerk);
//					break;
//				case "中转中心业务员":
//					userVO = ul.login(name, password, UserRole.TransferClerk);
//					break;
//				default:
//					break;
//				}
				
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
						mainFrame.setContentPane(new CourierUi(mainFrame));
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

			}
		});
		// 点击返回按钮
		but2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				mainFrame.setContentPane(new StartUi(mainFrame));
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}