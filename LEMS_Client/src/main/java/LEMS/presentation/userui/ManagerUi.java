package LEMS.presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓 管理员界面 2015年11月18日
 */
public class ManagerUi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton butOut;
	private JButton butAdd;
	private JButton butDel;
	private JButton butFind;
	private JButton butChange;
	private JButton OK;
	private JButton cancel;

	private JLabel labelID;
	private JTextField textID;
	private JLabel labelPassword;
	private JTextField textPassword;
	private JLabel labelName;
	private JTextField textName;
	private JLabel labelStatue;
	private JLabel labelInstitutionID;
	private JTextField textInstitutionID;
	private JLabel labelLocation;
	private JTextField textLocation;

	private JComboBox<String> comboBox;

	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);
	
	private UserVO user;
	public ManagerUi(final MainFrame mainFrame,UserVO uvo) {
		user=uvo;
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 设置输入框不可编辑
		this.setTestState(false);
		// 添加事件监听器
		this.addListener();

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("用户管理");
		butOut = new JButton("登出");
		butAdd = new JButton("新增");
		butDel = new JButton("删除");
		butFind = new JButton("查询");
		butChange = new JButton("修改");
		OK = new JButton("确定");
		cancel = new JButton("取消");

		labelID = new JLabel("用户ID:");
		textID = new JTextField();
		labelPassword = new JLabel("密码:");
		textPassword = new JTextField();
		labelName = new JLabel("用户姓名:");
		textName = new JTextField();
		labelInstitutionID = new JLabel("所在机构编号:");
		textInstitutionID = new JTextField();
		labelLocation = new JLabel("机构所在地:");
		textLocation = new JTextField();
		labelStatue = new JLabel("身份:");

		comboBox = new JComboBox<String>();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(449, 37, 148, 39);
		title.setFont(fnt1);
		labelID.setBounds(86, 140, 131, 30);
		textID.setBounds(206, 144, 144, 24);
		labelPassword.setBounds(96, 210, 131, 30);
		textPassword.setBounds(206, 213, 144, 24);
		labelName.setBounds(81, 279, 131, 30);
		textName.setBounds(206, 282, 144, 24);
		labelStatue.setBounds(81, 348, 131, 30);
		labelInstitutionID.setBounds(75, 417, 131, 30);
		textInstitutionID.setBounds(206, 420, 144, 24);
		labelLocation.setBounds(75, 486, 131, 30);
		textLocation.setBounds(206, 489, 144, 24);

		comboBox.setBounds(206, 351, 144, 24);
		comboBox.addItem("管理员");
		comboBox.addItem("总经理");
		comboBox.addItem("财务人员");
		comboBox.addItem("快递员");
		comboBox.addItem("营业厅业务员");
		comboBox.addItem("中转中心业务员");
		comboBox.addItem("仓库管理人员");

		OK.setBounds(86, 533, 120, 40);
		cancel.setBounds(230, 533, 120, 40);
		butOut.setBounds(52, 36, 120, 40);
		butAdd.setBounds(114, 632, 120, 40);
		butDel.setBounds(336, 632, 120, 40);
		butFind.setBounds(557, 632, 120, 40);
		butChange.setBounds(779, 632, 120, 40);

		this.add(title);
		this.add(labelID);
		this.add(textID);
		this.add(labelPassword);
		this.add(textPassword);
		this.add(labelName);
		this.add(textName);
		this.add(labelStatue);
		this.add(comboBox);
		this.add(labelInstitutionID);
		this.add(textInstitutionID);
		this.add(labelLocation);
		this.add(textLocation);
		this.add(OK);
		this.add(cancel);
		this.add(butOut);
		this.add(butAdd);
		this.add(butDel);
		this.add(butFind);
		this.add(butChange);

		JPanel jPanel = new JPanel();
		jPanel.setForeground(Color.RED);
		jPanel.setLayout(new GridLayout(20, 4));
		jPanel.setBounds(384, 126, 561, 465);
		JTextField tabulation[] = new JTextField[80];
		Font fnt2 = new Font("Courier", Font.PLAIN, 20);
		for (int i = 0; i < 80; i++) {
			tabulation[i] = new JTextField();
			tabulation[i].setSize(200, 200);
			tabulation[i].setEnabled(false);
			tabulation[i].setDisabledTextColor(Color.BLACK);
			tabulation[i].setFont(fnt2);
			// 居中
			tabulation[i].setHorizontalAlignment(JTextField.CENTER);
			jPanel.add(tabulation[i]);
		}
		tabulation[0].setText("用户名");
		tabulation[1].setText("密码");
		tabulation[2].setText("用户身份");
		tabulation[3].setText("用户姓名");
		this.add(jPanel);


	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {
		textID.setEditable(state);
		textPassword.setEditable(state);
		textName.setEditable(state);
		textInstitutionID.setEditable(state);
		textLocation.setEditable(state);

		comboBox.setEnabled(state);

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textID.setText(null);
		textPassword.setText(null);
		textName.setText(null);
		textInstitutionID.setText(null);
		textLocation.setText(null);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		butOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});

		butAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 设置输入框可编辑
				setTestState(true);
			}
		});
		butDel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});
		butFind.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});
		butChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 确定按钮的具体实现
				// 清空输入框
				empty();
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 清空输入框
				empty();
				// 设置输入框不可编辑
				setTestState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(63, 126, 306, 465, false);
		this.repaint();
	}
}
