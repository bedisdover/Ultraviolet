package LEMS.presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import LEMS.businesslogic.userbl.UserLogin;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.userui.ManagerUi;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓 登陆界面 2015年11月18日
 */
public class LoginUi extends JPanel {

	MainFrame mainFrame;
	Image im;
	JButton but1 = new JButton("登陆");
	JButton but2 = new JButton("返回");
	JLabel labName = new JLabel("账号：");
	JLabel labPassword = new JLabel("密码：");
	JTextField textName = new JTextField();
	JPasswordField textPassword = new JPasswordField();
	JComboBox<String> comboBox = new JComboBox<String>();

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

		comboBox.setBounds(470, 480, 116, 32);
		comboBox.addItem("管理员");
		comboBox.addItem("总经理");
		comboBox.addItem("财务人员");
		comboBox.addItem("快递员");
		comboBox.addItem("营业厅业务员");
		comboBox.addItem("中转中心业务员");
		comboBox.addItem("仓库管理人员");

		this.add(comboBox);
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
				String role = (String) comboBox.getSelectedItem();
				UserLogin ul = new UserLogin();
				UserVO userVO = null;
				switch (role) {
				case "管理员":
					userVO = ul.login(name, password, UserRole.Manager);
					break;
				case "总经理":
					userVO = ul.login(name, password, UserRole.GeneralManager);
					break;
				case "仓库管理人员":
					userVO = ul.login(name, password, UserRole.StoreManager);
					break;
				case "财务人员":
					userVO = ul.login(name, password, UserRole.FinanceClerk);
					break;
				case "快递员":
					userVO = ul.login(name, password, UserRole.Courier);
					break;
				case "营业厅业务员":
					userVO = ul.login(name, password, UserRole.BusinessClerk);
					break;
				case "中转中心业务员":
					userVO = ul.login(name, password, UserRole.TransferClerk);
					break;
				default:
					break;
				}
				if (userVO == null) {
					System.out.println("fail");
				} else {
					switch (userVO.getRole()) {
					// 暂定点击登陆后跳转到管理员界面
					case Manager:
						mainFrame.setContentPane(new ManagerUi(mainFrame));
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
