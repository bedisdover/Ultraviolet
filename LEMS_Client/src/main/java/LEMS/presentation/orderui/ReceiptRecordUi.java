package LEMS.presentation.orderui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.ReceiptRecord;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.vo.ordervo.IncomeBillVO;
import LEMS.vo.uservo.UserVO;
import javax.swing.JSeparator;

/**
 * @author 周梦佳 记录收款单界面
 */
public class ReceiptRecordUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X = 90;
	private static final int LOCATION_LABEL_Y = 130;
	private static final int LOCATION_TEXT_X = 188;
	private static final int LOCATION_TEXT_Y = 135;
	private static final int BOUND_X = 130;
	private static final int BOUND_Y = 30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton add;
	private JButton delete;
	private JButton update;
	private JButton finish;
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
//	private JTextField textDate;
	private JTextField textStaff;
	private JTextField textId;
	private JTextField textMoney;

	private JSeparator separator1;
	private JSeparator separator2;

	private DateChooser dc;
	private Table table;
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式
	
	private IncomeBillVO incomeBillVO;
	
	private ReceiptRecord receiptRecord;

	public ReceiptRecordUi(final MainFrame mainFrame, UserVO userVO) {
		this.mainFrame = mainFrame;
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
		
		incomeBillVO = new IncomeBillVO();
		receiptRecord = new ReceiptRecord(userVO, incomeBillVO);
	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("记录收款单");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		finish=new JButton("完成");
		labelDate=new JLabel("日期：");
		labelStaff=new JLabel("揽件员：");
		labelMoney = new JLabel("实收金额:");
		labelneeded = new JLabel("应收金额:");
//		textDate= new JTextField();
		textStaff= new JTextField();
		textMoney = new JTextField();
		textId = new JTextField();
		
		separator1 = new JSeparator();
		separator2 = new JSeparator();
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
//		textDate.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y - 6);
		textStaff.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+75, BOUND_X, BOUND_Y - 6);
		textId.setBounds(188, 380, BOUND_X, BOUND_Y - 6);
		textMoney.setBounds(188, 278, BOUND_X, BOUND_Y - 6);
		OK.setBounds(103, 468, BOUND_X - 40, BOUND_Y + 10);
		cancel.setBounds(225, 468, BOUND_X - 40, BOUND_Y + 10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120,40);
		update.setBounds(550, 590, 120, 40);
		finish.setBounds(750, 590, 120, 40);
		
		separator1.setBounds(90, 343, 239, 2);
		separator2.setBounds(90, 431, 234, 2);

		title.setFont(fnt1);
		labelneeded.setFont(fnt);
		labelMoney.setFont(fnt);
		labelDate.setFont(fnt);
		labelStaff.setFont(fnt);
//		textDate.setFont(fnt);
		textStaff.setFont(fnt);
		textId.setFont(fnt);
		textMoney.setFont(fnt);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		finish.setFont(fnt2);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		this.add(title);
		this.add(labelDate);
		this.add(labelStaff);
		this.add(labelneeded);
		this.add(labelMoney);
//		this.add(textDate);
		this.add(textStaff);
		this.add(textId);
		this.add(textMoney);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(finish);
		this.add(separator1);
		this.add(separator2);

		String[] columnNames = { "序号","日期","订单条形码号", "订单金额" };
		int[] list = { 40, 130, 14, 30, 20, 385, 115, 538, 430 };

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
//		textDate.setEditable(state);
		textStaff.setEditable(state);
		textId.setEditable(state);
		textMoney.setEditable(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textMoney.setText(null);
//		textDate.setText(null);
		textStaff.setText(null);
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
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 不需要的功能
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 不需要的功能
			}
		});
		finish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finishOperation();
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
				// 清空输入框
				empty();
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
		return true;
	}
	
	private void OKOperation() {
		// 清空输入框
		empty();
		
		try {
			receiptRecord.addOrder(textId.getText(), textStaff.getText());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(mainFrame, "请检查网络连接！", "Error", JOptionPane.ERROR_MESSAGE);
		}
		textMoney.setText(incomeBillVO.getAmount() + "");
	}
	
	private void finishOperation() {
		setTextState(true);
		incomeBillVO.setDate(dc.getTime());
		
		receiptRecord.createIncomeBill();
	}
}
