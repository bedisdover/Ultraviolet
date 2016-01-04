package LEMS.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LEMS.businesslogic.userbl.UserLogin;
import LEMS.presentation.inquireui.LogisticsInfoUi;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraPasswordField;
import LEMS.presentation.ultraSwing.UltraTextField;
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
	UltraButton but1 = new UltraButton("登录");
	UltraButton but2 = new UltraButton("查询物流信息");
	JLabel labName = new JLabel("账号：");
	JLabel labPassword = new JLabel("密码：");
	UltraTextField textName = new UltraTextField();
	UltraPasswordField textPassword = new UltraPasswordField();
	JLabel Return = new JLabel(new ImageIcon("source/Close.png"));
	JLabel account = new JLabel(new ImageIcon("source/account.png"));
	JLabel password = new JLabel(new ImageIcon("source/password.png"));

	public LoginUi(final MainFrame mainFrame) {
		Icon i = new ImageIcon("source/Return.png");
		this.mainFrame = mainFrame;
		this.setLayout(null);
		mainFrame.setDragable(this);
		labName.setBounds(415, 182, 193, 56);
		labPassword.setBounds(415, 279, 193, 56);

		Return.setBounds(960, 10, 30, 30);
		
		account.setBounds(400, 239, 40, 40);
		password.setBounds(400, 348, 40, 200);
		textName.setBounds(504, 185, 200, 50);
		textPassword.setBounds(504, 282, 200, 50);
	
		textName.setBackground(new Color(240, 240, 240));
		textPassword.setBackground(new Color(240,240,240));
		
		but1.setBounds(740, 165, 240, 100);
		but2.setBounds(740, 260, 240, 100);

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
		this.add(Return);
		this.add(account);
		this.add(password);

		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		im = Toolkit.getDefaultToolkit().getImage("source/backGround.png");

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