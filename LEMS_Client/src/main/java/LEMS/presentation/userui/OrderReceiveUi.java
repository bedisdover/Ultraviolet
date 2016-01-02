package LEMS.presentation.userui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraComboBox;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳 接收界面
 */
public class OrderReceiveUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X = 95;
	private static final int LOCATION_LABEL_Y = 145;
	private static final int LOCATION_TEXT_X = 205;
	private static final int LOCATION_TEXT_Y = 150;
	private static final int BOUND_X = 130;
	private static final int BOUND_Y = 30;

	private MainFrame mainFrame;
	private UserVO user;
	private JLabel title;
	private UltraButton exit;
	private UltraButton OK;
	private UltraButton cancel;
	private UltraButton add;
	private UltraButton delete;
	private UltraButton update;
	private UltraButton finish;
	private JLabel labelDate;
	private JLabel labelID;
	private JLabel labelName;
	private JLabel labelStatus;
	private UltraTextField textID;
	private UltraTextField textName;

	private UltraComboBox comboBoxStatus;// status

	private DateChooser dc;
	private Table table;

	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式

	/**
	 * 标记是否在修改状态（按下修改按钮）
	 */
	private boolean isUpdate = false;

	public OrderReceiveUi(final MainFrame mainFrame, UserVO userVO) {
		this.mainFrame = mainFrame;
		user = userVO;
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
	}

	/**
	 * 初始化
	 */
	private void init() {

		title = new JLabel("接收订单");
		exit = new UltraButton("返回");
		OK = new UltraButton("确定");
		cancel = new UltraButton("取消");
		add = new UltraButton("新增");
		delete = new UltraButton("删除");
		update = new UltraButton("修改");
		finish = new UltraButton("生成");
		labelDate = new JLabel("送达日期：");
		labelID = new JLabel("快递单号：");
		labelName = new JLabel("收件人姓名：");
		labelStatus = new JLabel("货物到达状态：");
		textID = new UltraTextField();
		textName = new UltraTextField();
		comboBoxStatus = new UltraComboBox();
		dc = new DateChooser(this, LOCATION_TEXT_X, LOCATION_TEXT_Y);
	}

	/**
	 * 初始化各组件
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		title.setBounds(449, 20, 148, 39);
		title.setFont(fnt1);

		labelDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelID.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 90, BOUND_X, BOUND_Y);
		labelName.setBounds(LOCATION_LABEL_X - 5, LOCATION_LABEL_Y + 170, BOUND_X, BOUND_Y);
		labelStatus.setBounds(LOCATION_LABEL_X - 15, LOCATION_LABEL_Y + 260, BOUND_X, BOUND_Y);
		textID.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 90, BOUND_X, BOUND_Y - 5);
		textName.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 170, BOUND_X, BOUND_Y - 5);
		comboBoxStatus.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 260, BOUND_X, BOUND_Y - 5);
		comboBoxStatus.addItem("完整");
		comboBoxStatus.addItem("损坏");
		comboBoxStatus.addItem("丢失");
		OK.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 330, BOUND_X - 40, BOUND_Y + 10);
		cancel.setBounds(LOCATION_LABEL_X + 135, LOCATION_LABEL_Y + 330, BOUND_X - 40, BOUND_Y + 10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120, 40);
		update.setBounds(550, 590, 120, 40);
		finish.setBounds(750, 590, 120, 40);

		title.setFont(fnt1);
		labelDate.setFont(fnt);
		labelID.setFont(fnt);
		labelName.setFont(fnt);
		labelStatus.setFont(fnt);

		this.add(title);
		this.add(labelDate);
		this.add(labelID);
		this.add(labelName);
		this.add(labelStatus);
		this.add(textID);
		this.add(textName);
		this.add(comboBoxStatus);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(finish);

		String[] columnNames = { "序号", "到达日期", "收件人姓名", "货物到达状态" };
		int[] list = { 40, 135, 14, 30, 20, 388, 125, 558, 430 };

		table = new Table();
		add(table.drawTable(columnNames, list));

		JLayeredPane j = new JLayeredPane();
		j.setLayer(textName, 2, 0);
	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTextState(boolean state) {
		textID.setEditable(state);
		textName.setEditable(state);
		comboBoxStatus.setEnabled(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
		dc.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textName.setText(null);
		comboBoxStatus.setSelectedIndex(0);
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
				table.removeLine(table.getSelectedRow());
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (table.getValueAt(table.getSelectedRow()) != null) {
					isUpdate = true;
					updateOperation();
				}
			}
		});
		finish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finishOperation();
			}
		});
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi loginUi = new LoginUi(mainFrame);
				mainFrame.setContentPane(loginUi);
			}
		});
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!isEmpty()) {
					OKOperation();
					isUpdate = false;
				}
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				empty();
				setTextState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.drawRect(60, 125, 305, 190 + 15 + 225); // 输入框外框
		this.repaint();
	}

	/**
	 * 确认按钮按下后的操作
	 */
	private void OKOperation() {
//		try {
			String[] values = { textID.getText(), textName.getText(), comboBoxStatus.getSelectedItem() + "" };
			if (isUpdate) {
				table.setValueAt(table.getSelectedRow(), values);
			} else {
				table.setValueAt(table.numOfEmpty(), values);
			}
			
//			new Deliver().endDeliver(textID.getText(), textName.getText());
			
			textName.setText(null);
//		} catch (RemoteException e) {
//			JOptionPane.showMessageDialog(mainFrame, "请检查网络连接！", "Error", JOptionPane.ERROR_MESSAGE);
//		}
	}

	/**
	 * 完成按钮按下后的操作
	 */
	private void finishOperation() {
		this.setTextState(false);
		this.empty();
	}

	/**
	 * 修改按钮按下的操作
	 */
	private void updateOperation() {
		ArrayList<String> values = table.getValueAt(table.getSelectedRow());
		textID.setText(values.get(1));
		textName.setText(values.get(2));
		comboBoxStatus.setSelectedItem(values.get(3));
	}

	/**
	 * 判断输入是否为空
	 */
	private boolean isEmpty() {
		if (textName.getText() == null) {
			JOptionPane.showMessageDialog(mainFrame, "收件人姓名为空！", "Error", JOptionPane.ERROR_MESSAGE);
			return true;
		}

		return false;
	}
}