package LEMS.presentation.financeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.financebl.Settlement;
import LEMS.po.orderpo.IncomePO;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓
 * 
 *         结算管理界面
 */
public class SettlementUi extends JPanel {
	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;
	private UserVO user;

	private UltraButton but1;
	private UltraButton but2;
	private Table table;
	private JLabel title;
	private Font font;
	private UltraButton butOut;
	private JLabel userId;
	private JLabel userRole;

	private DateChooser dc;
	private UltraTextField textField;
	private JLabel labelDate;
	private JLabel label;

	private Settlement settlement;
	private JLabel labelTotal;
	private UltraTextField textTotal;
	
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式

	public SettlementUi(final MainFrame mainFrame, UserVO uvo) {
		this.mainFrame = mainFrame;
		this.user = uvo;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 添加事件监听器
		this.addListener();

		settlement = new Settlement();
	}

	public void init() {
		but1 = new UltraButton("查看收款信息");
		but2 = new UltraButton("添加到收款单");
		title = new JLabel("结算管理");
		font = new Font("宋体", Font.PLAIN, 26);
		butOut = new UltraButton("返回");
		userId = new JLabel(" 账号： " + user.getId());
		userId.setLocation(788, 25);
		userId.setSize(180, 25);
		userRole = new JLabel("身份： " + UserRole.transfer(user.getRole()));
		userRole.setLocation(788, 54);
		userRole.setSize(180, 25);

		dc = new DateChooser(this, 150, 180);
	}

	public void initComponents() {
		but1.setBounds(95, 415, 170, 50);
		but2.setBounds(95, 495, 170, 50);
		title.setBounds(454, 26, 249, 45);
		title.setFont(font);
		butOut.setBounds(52, 36, 120, 40);

		this.add(but1);
		this.add(but2);
		this.add(title);
		this.add(butOut);
		this.add(userId);
		this.add(userRole);

		String[] columnNames = { "序号", "收款日期", "收款单位", "收款人", "收款金额" };
		int[] list = { 40, 125, 14, 30, 20, 330, 120, 643, 497 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));

		labelDate = new JLabel("日期：");
		labelDate.setBounds(74, 180, 54, 15);
		labelDate.setFont(fnt);
		add(labelDate);

		label = new JLabel("营业厅：");
		label.setBounds(74, 260, 65, 25);
		label.setFont(fnt);
		add(label);

		textField = new UltraTextField();
		textField.setBounds(143, 260, 142, 21);
		add(textField);
		textField.setColumns(10);
		
		labelTotal = new JLabel("总金额：");
		labelTotal.setBounds(74, 340, 65, 15);
		labelTotal.setFont(fnt);
		add(labelTotal);
		
		textTotal = new UltraTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(143, 340, 142, 21);
		add(textTotal);
		textTotal.setColumns(10);
		
	}

	public void addListener() {
		// “查看收款信息”按钮增加监听
		but1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				findOperation();
			}
		});
		// “添加到收款单”按钮增加监听
		but2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (table.numOfEmpty() != 0) {
					addOperation();
				}
			}
		});

		butOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});
	}

	private void findOperation() {
		ArrayList<IncomePO> incomes = settlement.getIncomeByDateAndIns(dc.getTime(), textField.getText());
		
		System.out.println(incomes);
		if (incomes.isEmpty()) {
			JOptionPane.showMessageDialog(mainFrame, "暂无收款信息！", "error", JOptionPane.ERROR_MESSAGE);
		}
		
		String [] values = {};
		for (IncomePO incomePO : incomes) {
			//TODO 添加非编号
			values[0] = incomePO.getDate();
			values[1] = textField.getText();
			values[2] = incomePO.getCollector();
			values[3] = incomePO.getAmount() + "";
			table.setValueAt(table.numOfEmpty(), values);
			
			if (textTotal.getText().equals("")) {
				textTotal.setText(incomePO.getAmount() + "");
			} else {
				textTotal.setText(Double.parseDouble(textTotal.getText())
							+ incomePO.getAmount() + "");
			}
		}
	}

	private void addOperation() {
		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(50, 135, 255, 430, false); // 输入框外框
		this.repaint();
	}
}
