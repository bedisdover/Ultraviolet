package LEMS.presentation.orderui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.Transfer;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.method.DateChooser;
import LEMS.vo.ordervo.TransferVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳
 * 中转接收界面
 */
public class TransferUi extends JPanel {


	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=70;
	private static final int LOCATION_LABEL_Y=140;
	private static final int LOCATION_TEXT_X=178;
	private static final int LOCATION_TEXT_Y=145;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton add;
	private JButton delete;
	private JButton update;
	private JButton inquire;
	private JLabel labelTransferID;
	private JLabel labelDate;
	private JLabel labelId;
	private JLabel labelDeparture;
	private JLabel labelStatus;
	
	private JTextField textTransferID;
	private JTextField textId;
	
	private JComboBox<String> comboBox1;//departure
	private JComboBox<String> comboBox2;//status
	
	private DateChooser dc;
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	private Transfer transfer;
	
	private TransferVO transferVO;
	
	public TransferUi(final MainFrame mainFrame, UserVO user) {
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

		transferVO = new TransferVO();
		transfer = new Transfer(user, transferVO);
	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("中转接收");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		inquire=new JButton("查找");
		labelTransferID = new JLabel("中转单编号:");
		labelDate = new JLabel("到达日期:");
		labelId = new JLabel("订单条形码:");
		labelDeparture = new JLabel("出发地:");
		labelStatus = new JLabel("货物到达状态：");
		
		textTransferID = new JTextField();
		textId = new JTextField();
		
		comboBox1 = new JComboBox<String>();
		comboBox2 = new JComboBox<String>();
		
		dc = new DateChooser(this, LOCATION_TEXT_X, LOCATION_TEXT_Y+70);
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 27, 230, 39);
		labelTransferID.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelDate.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+70, BOUND_X, BOUND_Y);
		labelDeparture.setBounds(LOCATION_LABEL_X+23, LOCATION_LABEL_Y+140, BOUND_X, BOUND_Y);
		labelId.setBounds(LOCATION_LABEL_X+9, LOCATION_LABEL_Y+210, BOUND_X, BOUND_Y);
		labelStatus.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+280, BOUND_X, BOUND_Y);
		textTransferID.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+210, BOUND_X, BOUND_Y-5);
		comboBox1.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+140, BOUND_X, BOUND_Y-6);
		comboBox1.addItem("北京");
		comboBox1.addItem("上海");
		comboBox1.addItem("广州");
		comboBox1.addItem("南京");
		comboBox2.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+280, BOUND_X, BOUND_Y-5);
		comboBox2.addItem("完整");
		comboBox2.addItem("损坏");
		comboBox2.addItem("丢失");
		
		OK.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+355, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+135, LOCATION_LABEL_Y+355, BOUND_X-40, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120,40);
		update.setBounds(550, 590, 120, 40);
		inquire.setBounds(750, 590, 120, 40);

		title.setFont(fnt1);
		labelTransferID.setFont(fnt);
		labelDate.setFont(fnt);
		labelId.setFont(fnt);
		labelDeparture.setFont(fnt);
		labelStatus.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		inquire.setFont(fnt2);
		textId.setFont(fnt);
		textTransferID.setFont(fnt);
		comboBox1.setFont(fnt);
		comboBox2.setFont(fnt);
		
		this.add(title);
		this.add(labelTransferID);
		this.add(labelDate);
		this.add(labelId);
		this.add(labelDeparture);
		this.add(labelStatus);
		this.add(textId);
		this.add(textTransferID);
		this.add(comboBox1);
		this.add(comboBox2);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(inquire);

		String[] columnNames = { "中转中心编号", "到达日期", "中转单编号", "出发地", "货物到达状态"};  
		int[] list={40,116,14,30,20,355,125,598,435};

	    Table table=new Table();
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
		textTransferID.setEditable(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
		//日期不可编辑
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textTransferID.setText(null);
		comboBox1.setSelectedIndex(0);
		comboBox2.setSelectedIndex(0);
		//日期
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
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi l=new LoginUi(mainFrame);
				mainFrame.setContentPane(l);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(50, 125, 280, 435, false);  //输入框外框
		this.repaint();
	}



	

	




}
