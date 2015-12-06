package LEMS.presentation.informationui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;

/**
 * @author 周梦佳 司机信息管理界面
 */
public class DriverManageUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X = 85;
	private static final int LOCATION_LABEL_Y = 120;
	private static final int LOCATION_TEXT_X = 175;
	private static final int LOCATION_TEXT_Y = 125;
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
	private JButton inquire;
	private JLabel labelId;
	private JLabel labelName;
	private JLabel labelTime;
	private JLabel labelSex;
	private JLabel labelCard;
	private JLabel labelMobile;
	private JLabel labelBirthTime;
	private JLabel labelYear;
	private JLabel labelMonth;
	private JLabel labelDay;
	private JTextField textId;
	private JTextField textName;
	private JTextField textTime;
	private JTextField textCard;
	private JTextField textMobile;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textDay;
	private JComboBox<String> comboBox;// sex

	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式

	public DriverManageUi(final MainFrame mainFrame) {
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
		title = new JLabel("司机信息管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		inquire=new JButton("查找");
		labelId = new JLabel("司机编号:");
		labelName = new JLabel("姓名:");
		labelTime = new JLabel("行驶证期限:");
		labelSex = new JLabel("性别:");
		labelCard = new JLabel("身份证号：");
		labelMobile = new JLabel("手机号:");
		labelBirthTime = new JLabel("出生日期:");
		labelYear=new JLabel("年");
		labelMonth=new JLabel("月");
		labelDay=new JLabel("日");
		textId = new JTextField();
		textName = new JTextField();
		textTime = new JTextField();
		textCard = new JTextField();
		textMobile = new JTextField();
		textYear= new JTextField();
		textMonth= new JTextField();
		textDay= new JTextField();
		comboBox = new JComboBox<String>();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 27, 230, 39);
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelName.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 55, BOUND_X, BOUND_Y);
		labelTime.setBounds(LOCATION_LABEL_X - 7, LOCATION_LABEL_Y + 110, BOUND_X, BOUND_Y);
		labelSex.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 165, BOUND_X, BOUND_Y);
		labelCard.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 220, BOUND_X, BOUND_Y);
		labelMobile.setBounds(LOCATION_LABEL_X + 7, LOCATION_LABEL_Y + 275, BOUND_X, BOUND_Y);
		labelBirthTime.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 330, BOUND_X, BOUND_Y);
		labelYear.setBounds(LOCATION_LABEL_X+132, LOCATION_LABEL_Y + 330, BOUND_X-100, BOUND_Y);
		labelMonth.setBounds(LOCATION_LABEL_X+175, LOCATION_LABEL_Y + 330, BOUND_X-100, BOUND_Y);
		labelDay.setBounds(LOCATION_LABEL_X+217, LOCATION_LABEL_Y + 330, BOUND_X-100, BOUND_Y);
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y - 6);
		textName.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 55, BOUND_X, BOUND_Y - 6);
		textTime.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 110, BOUND_X, BOUND_Y - 6);
		textCard.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 220, BOUND_X, BOUND_Y - 6);
		textMobile.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 275, BOUND_X, BOUND_Y - 6);
		textYear.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 330, BOUND_X-90, BOUND_Y - 6);
		textMonth.setBounds(LOCATION_TEXT_X+58, LOCATION_TEXT_Y + 330, BOUND_X-105, BOUND_Y - 6);
		textDay.setBounds(LOCATION_TEXT_X+101, LOCATION_TEXT_Y + 330, BOUND_X-105, BOUND_Y - 6);
		comboBox.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 165, BOUND_X, BOUND_Y - 5);
		comboBox.addItem("男");
		comboBox.addItem("女");
		OK.setBounds(LOCATION_LABEL_X + 5, LOCATION_LABEL_Y + 385, BOUND_X - 40, BOUND_Y + 10);
		cancel.setBounds(LOCATION_LABEL_X + 125, LOCATION_LABEL_Y + 385, BOUND_X - 40, BOUND_Y + 10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120,40);
		update.setBounds(550, 590, 120, 40);
		inquire.setBounds(750, 590, 120, 40);

		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelName.setFont(fnt);
		labelSex.setFont(fnt);
		labelTime.setFont(fnt);
		labelCard.setFont(fnt);
		labelMobile.setFont(fnt);
		labelBirthTime.setFont(fnt);
		labelYear.setFont(fnt);
		labelMonth.setFont(fnt);
		labelDay.setFont(fnt);
		textId.setFont(fnt);
		textName.setFont(fnt);
		textTime.setFont(fnt);
		textCard.setFont(fnt);
		textMobile.setFont(fnt);
		textYear.setFont(fnt);
		textMonth.setFont(fnt);
		textDay.setFont(fnt);
		comboBox.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		inquire.setFont(fnt2);

		this.add(title);
		this.add(labelId);
		this.add(labelName);
		this.add(labelSex);
		this.add(labelTime);
		this.add(labelCard);
		this.add(labelMobile);
		this.add(labelBirthTime);
		this.add(labelYear);
		this.add(labelMonth);
		this.add(labelDay);
		this.add(textId);
		this.add(textName);
		this.add(textTime);
		this.add(textMobile);
		this.add(textCard);
		this.add(textYear);
		this.add(textMonth);
		this.add(textDay);
		this.add(comboBox);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(inquire);

		String[] columnNames = { "司机编号", "姓名", "行驶证期限", "性别", "身份证号", "手机号" };
		int[] list = { 40, 96, 14, 30, 20, 362, 105, 594, 460 };

		Table table = new Table();
		add(table.drawTable(columnNames, list));

	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {

		textId.setEditable(state);
		textName.setEditable(state);
		textTime.setEditable(state);
		textCard.setEditable(state);
		textMobile.setEditable(state);
		textYear.setEditable(state);
		textMonth.setEditable(state);
		textDay.setEditable(state);
		comboBox.setEditable(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textName.setText(null);
		textTime.setText(null);
		textMobile.setText(null);
		textCard.setText(null);
		textYear.setText(null);
		textMonth.setText(null);
		textDay.setText(null);
		comboBox.setSelectedIndex(0);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				// TODO 返回按钮的具体实现
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 返回按钮的具体实现
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 返回按钮的具体实现
			}
		});
		inquire.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				// TODO 返回按钮的具体实现
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
				// TODO 确定按钮的具体实现
				empty();
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				empty();
				setTestState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(70, 105, 250, 460, false); // 输入框外框
		this.repaint();
	}

}
