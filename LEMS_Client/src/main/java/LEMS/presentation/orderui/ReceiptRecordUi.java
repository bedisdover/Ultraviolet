package LEMS.presentation.orderui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.ReceiptRecord;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.ordervo.IncomeVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳 记录收款单界面
 */
public class ReceiptRecordUi extends JPanel {

	private static final long serialVersionUID = 1L;
//	private static final int LOCATION_LABEL_X = 90;
//	private static final int LOCATION_LABEL_Y = 130;
	private static final int LOCATION_TEXT_X = 188;
	private static final int LOCATION_TEXT_Y = 135;
	private static final int BOUND_X = 130;
	private static final int BOUND_Y = 30;

	private MainFrame mainFrame;
	private JLabel title;
	private UltraButton exit;
	private UltraButton OK;
	private UltraButton cancel;
	private UltraButton add;
//	private JButton delete;
//	private JButton update;
	private UltraButton finish;
	private JLabel labelDate;
	private JLabel labelStaff;
	/**
	 * 应收金额
	 */
	private JLabel labelneeded;
	/**
	 * 实收金额
	 */
	private JLabel labelMoney;
	private UltraTextField textStaff;
	private UltraTextField textNeeded;
	private UltraTextField textMoney;

	private JSeparator separator1;
	private JSeparator separator2;

	private DateChooser dc;
	private Table table;
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式
	
	private IncomeVO incomeBillVO;
	
	private ReceiptRecord receiptRecord;
	
	private UserVO user;
	private JLabel userId;
	private JLabel userRole;
	
	public ReceiptRecordUi(final MainFrame mainFrame, UserVO userVO) {
		this.mainFrame = mainFrame;
		this.user = userVO;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 设置输入框不可编辑
		this.setTextState(false);
		// 添加事件监听器
		this.addListener();
		
		incomeBillVO = new IncomeVO();
		receiptRecord = new ReceiptRecord(userVO, incomeBillVO);
	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("记录收款单");
		exit = new UltraButton("返回");
		OK = new UltraButton("确定");
		cancel = new UltraButton("取消");
		add=new UltraButton("新增");
//		delete=new JButton("删除");
//		update=new JButton("修改");
		finish=new UltraButton("完成");
		labelDate=new JLabel("日期：");
		labelStaff=new JLabel("揽件员：");
		labelMoney = new JLabel("实收金额:");
		labelneeded = new JLabel("应收金额:");
		textStaff= new UltraTextField();
		textMoney = new UltraTextField();
		textNeeded = new UltraTextField();
		
		separator1 = new JSeparator();
		separator2 = new JSeparator();
		userId = new JLabel("账号： "+user.getId());
		userId.setLocation(363, 69);
		userId.setSize(150, 25);
		userRole = new JLabel("身份： "+UserRole.transfer(user.getRole()));
		userRole.setLocation(528, 69);
		userRole.setSize(150, 25);
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {
		title.setBounds(420, 27, 230, 39);
		labelDate.setBounds(90, 132, BOUND_X, BOUND_Y);
		labelStaff.setBounds(90, 207, BOUND_X, BOUND_Y);
		labelneeded.setBounds(90, 375, BOUND_X, BOUND_Y);
		labelMoney.setBounds(90, 275, BOUND_X, BOUND_Y);
		textStaff.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+75, BOUND_X, BOUND_Y - 6);
		textNeeded.setBounds(188, 380, BOUND_X, BOUND_Y - 6);
		textMoney.setBounds(188, 278, BOUND_X, BOUND_Y - 6);
		OK.setBounds(103, 468, BOUND_X - 40, BOUND_Y + 10);
		cancel.setBounds(225, 468, BOUND_X - 40, BOUND_Y + 10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
//		delete.setBounds(350, 590, 120,40);
//		update.setBounds(550, 590, 120, 40);
		finish.setBounds(750, 590, 120, 40);
		
		separator1.setBounds(90, 343, 239, 2);
		separator2.setBounds(90, 431, 234, 2);

		title.setFont(fnt1);
		labelneeded.setFont(fnt);
		labelMoney.setFont(fnt);
		labelDate.setFont(fnt);
		labelStaff.setFont(fnt);
		this.add(title);
		this.add(labelDate);
		this.add(labelStaff);
		this.add(labelneeded);
		this.add(labelMoney);
		this.add(textStaff);
		this.add(textNeeded);
		this.add(textMoney);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
//		this.add(delete);
//		this.add(update);
		this.add(finish);
		this.add(separator1);
		this.add(separator2);
		this.add(userId);
		this.add(userRole);
		
		String[] columnNames = { "序号", "订单条形码号", "订单金额" };
		int[] list = {40, 130, 14, 30, 20, 485, 115, 408, 430};

		table = new Table();
		add(table.drawTable(columnNames, list));
		
		dc = new DateChooser(this, LOCATION_TEXT_X, LOCATION_TEXT_Y);
	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTextState(boolean state) {
		textStaff.setEditable(state);
		textNeeded.setEditable(state);
		textMoney.setEditable(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTextState(true);
			}
		});
//		delete.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				// TODO 不需要的功能
//			}
//		});
//		update.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				// TODO 不需要的功能
//			}
//		});
		finish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//若订单列表为空，操作无效
				if (table.numOfEmpty() != 0) {
					finishOperation();
				}
			}
		});
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi loginUi=new LoginUi(mainFrame);
				mainFrame.setContentPane(loginUi);
			}
		});

		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (isLegal()) {
					OKOperation();
				}
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 设置输入框不可编辑
				setTextState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(70, 115, 275, 430, false); // 输入框外框
		this.repaint();
	}
	
	/**
	 * 判断输入快递员编号是否合法 
	 */
	private boolean isLegal() {
		String stuff = textStaff.getText();
		
		if (stuff.length() != 10 || stuff.matches("\\d+")) {
			JOptionPane.showMessageDialog(mainFrame, "快递员编号输入错误！", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (stuff.startsWith(user.getId().substring(0, 7))) {
			JOptionPane.showMessageDialog(mainFrame, "快递员编号输入错误！", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void OKOperation() {
		ArrayList<OrderPO> orders = null;
		try {
			orders = receiptRecord.getOrders(textStaff.getText(), dc.getTime());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(mainFrame, "请检查网络连接！", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		String[] values = new String[2]; 
		for (OrderPO order : orders) {
			values[0] = order.getId();
			values[1] = order.getAmount() + "";
			table.setValueAt(table.numOfEmpty(), values);
			
			if (textNeeded.getText().equals("")) {
				textNeeded.setText(order.getAmount() + "");
			} else {
				textNeeded.setText(Double.parseDouble(textNeeded.getText()) + order.getAmount() + "");
			}
		}
	}
	
	private void finishOperation() {
		setTextState(false);
		incomeBillVO.setDate(dc.getTime());
		incomeBillVO.setCollector(textStaff.getText());
		incomeBillVO.setAmount(Double.parseDouble(textNeeded.getText()));
		
		receiptRecord.createIncomeBill();
	}
}
