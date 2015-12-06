package LEMS.presentation.orderui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.Receipt;
import LEMS.businesslogic.utility.DateFormate;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.storeui.DateChooser;
import LEMS.vo.ordervo.ArrivalVO;
/**
 * @author 周梦佳
 * 接收界面
 */
public class ReceiveUi extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=95;
	private static final int LOCATION_LABEL_Y=155;
	private static final int LOCATION_TEXT_X=205;
	private static final int LOCATION_TEXT_Y=160;
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
	private JLabel labelDate;
	private JLabel labelId;
	private JLabel labelDeparture;
	private JLabel labelStatus;
	private JTextField textId;

	private JComboBox<String> comboBoxDeparture;//departure
	private JComboBox<String> comboBoxStatus;//status
	DateChooser dc;
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式

	private Receipt receipt;
	
	/**
	 * 到达单值对象
	 */
	private ArrivalVO arrivalVO;
	
	public ReceiveUi(final MainFrame mainFrame) {
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

		arrivalVO = new ArrivalVO();
		//TODO User对象
		receipt = new Receipt(null, arrivalVO);
	}

	/**
	 * 初始化
	 */
	private void init() {
	
		title = new JLabel("接收");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		inquire=new JButton("生成");
		labelDate = new JLabel("到达日期:");
		labelId = new JLabel("订单编号:");
		labelDeparture = new JLabel("出发地:");
		labelStatus = new JLabel("货物到达状态：");
		textId = new JTextField();
		comboBoxDeparture = new JComboBox<String>();
		comboBoxStatus = new JComboBox<String>();
		dc= new DateChooser(this,LOCATION_TEXT_X,LOCATION_TEXT_Y);
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(450, 27, 230, 39);
		
		labelDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelDeparture.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+60, BOUND_X, BOUND_Y);
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+170, BOUND_X, BOUND_Y);
		labelStatus.setBounds(LOCATION_LABEL_X-15, LOCATION_LABEL_Y+240, BOUND_X, BOUND_Y);
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+170, BOUND_X, BOUND_Y-5);
		comboBoxDeparture.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+60, BOUND_X, BOUND_Y-6);
		comboBoxDeparture.addItem("北京");
		comboBoxDeparture.addItem("上海");
		comboBoxDeparture.addItem("广州");
		comboBoxDeparture.addItem("南京");
		comboBoxStatus.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+240, BOUND_X, BOUND_Y-5);
		comboBoxStatus.addItem("完整");
		comboBoxStatus.addItem("损坏");
		comboBoxStatus.addItem("丢失");
		OK.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+330, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+135, LOCATION_LABEL_Y+330, BOUND_X-40, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120,40);
		update.setBounds(550, 590, 120, 40);
		inquire.setBounds(750, 590, 120, 40);

		title.setFont(fnt1);
		labelDate.setFont(fnt);
		labelId.setFont(fnt);
		labelDeparture.setFont(fnt);
		labelStatus.setFont(fnt);
		textId.setFont(fnt);
		comboBoxDeparture.setFont(fnt);
		comboBoxStatus.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		inquire.setFont(fnt2);
		
		this.add(title);
		this.add(labelDate);
		this.add(labelId);
		this.add(labelDeparture);
		this.add(labelStatus);
		
		this.add(textId);
		this.add(comboBoxDeparture);
		this.add(comboBoxStatus);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(inquire);

		String[] columnNames = { "序号","到达日期", "订单编号", "出发地","货物到达状态"};  
		int[] list={40,108,14,30,20,388,125,558,430};

	    Table table=new Table();
		add(table.drawTable(columnNames, list));
		
		JLayeredPane j=new JLayeredPane();
		j.setLayer(textId, 2, 0);
	    	
	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {

		textId.setEditable(state);
		comboBoxDeparture.setEditable(state);
		comboBoxStatus.setEditable(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		comboBoxDeparture.setSelectedIndex(0);
		comboBoxStatus.setSelectedIndex(0);
		//TODO 日期不能设置
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
				OKOperation();
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
		g.drawRect(60, 125, 305, 155);  //输入框外框
		g.drawRect(60, 300, 305, 250);  //输入框外框
		this.repaint();
	}

	/**
	 * 确认按钮按下后的操作
	 */
	private void OKOperation() {
		this.empty();
		
		//TODO 日期
		arrivalVO.setDate(DateFormate.DATE_FORMAT.format(new Date()));
		arrivalVO.setDepature((String) comboBoxDeparture.getSelectedItem());
		receipt.addOrder(textId.getText());
		//生成到达单
		receipt.createArrivalNote();
	}
}
