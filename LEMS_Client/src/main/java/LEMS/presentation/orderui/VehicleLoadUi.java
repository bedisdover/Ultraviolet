package LEMS.presentation.orderui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 周梦佳
 * 装运管理界面
 */
@SuppressWarnings("serial")
public class VehicleLoadUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=55;
	private static final int LOCATION_LABEL_Y=110;
	private static final int LOCATION_TEXT_X=145;
	private static final int LOCATION_TEXT_Y=115;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	

	private JLabel labelId;
	private JLabel labelDate;
	private JLabel labelDeparture;
	private JLabel labelDestination;
	private JLabel labelAirline;
	private JLabel labelStand;
	private JLabel labelGuard;
	private JLabel labelAllID;
	private JLabel labelMoney;
	
	private JTextField textId;
	private JTextField textDate;
	private JTextField textAirline;
	private JTextField textStand;
	private JTextField textGuard;
	private JTextField textAllID;
	private JTextField textMoney;
	
	private JComboBox<String> comboBox1;//departure
	private JComboBox<String> comboBox2;//destination
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	public VehicleLoadUi(final MainFrame mainFrame) {
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
		title = new JLabel("装运管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		
		labelId = new JLabel("中转单编号:");
		labelDate = new JLabel("装车日期:");
		labelDeparture = new JLabel("出发地:");
		labelDestination = new JLabel("目的地:");
		labelAirline = new JLabel("航班号：");
		labelStand = new JLabel("货柜号:");
		labelGuard = new JLabel("监装员:");
		labelAllID = new JLabel("本次装箱所有托运单号:");
		labelMoney = new JLabel("运费:");
		
		textId = new JTextField();
		textDate = new JTextField();
		textAirline = new JTextField();
		textStand = new JTextField();
		textGuard = new JTextField();
		textAllID = new JTextField();
		textMoney = new JTextField();
		comboBox1 = new JComboBox<String>();
		comboBox2 = new JComboBox<String>();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 27, 230, 39);
		
		
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelDate.setBounds(LOCATION_LABEL_X+8, LOCATION_LABEL_Y+48, BOUND_X, BOUND_Y);
		labelDeparture.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+96, BOUND_X, BOUND_Y);
		labelDestination.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+144, BOUND_X, BOUND_Y);
		labelAirline.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+192, BOUND_X, BOUND_Y);
		labelStand.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+240, BOUND_X, BOUND_Y);
		labelGuard.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+288, BOUND_X, BOUND_Y);
		labelAllID.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+333, BOUND_X+40, BOUND_Y);
		labelMoney.setBounds(LOCATION_LABEL_X+23, LOCATION_LABEL_Y+435, BOUND_X, BOUND_Y);
		
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textDate.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+48, BOUND_X, BOUND_Y-6);
		textAirline.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+192, BOUND_X, BOUND_Y-6);
		textStand.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+240, BOUND_X, BOUND_Y-6);
		textGuard.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+288, BOUND_X, BOUND_Y-6);
		textAllID.setBounds(LOCATION_TEXT_X-87, LOCATION_TEXT_Y+360, BOUND_X+85, BOUND_Y+25);
		textMoney.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+435, BOUND_X, BOUND_Y-6);
		
		comboBox1.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+96, BOUND_X, BOUND_Y-5);
		comboBox1.addItem("");
		comboBox1.addItem("北京");
		comboBox1.addItem("上海");
		comboBox1.addItem("广州");
		comboBox1.addItem("南京");
		
		comboBox2.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+144, BOUND_X, BOUND_Y-5);
		comboBox2.addItem("");
		comboBox2.addItem("北京");
		comboBox2.addItem("上海");
		comboBox2.addItem("广州");
		comboBox2.addItem("南京");
		
		OK.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+485, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+125, LOCATION_LABEL_Y+485, BOUND_X-40, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);

		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelDeparture.setFont(fnt);
		labelAirline.setFont(fnt);
		labelStand.setFont(fnt);
		labelGuard.setFont(fnt);
		labelAllID.setFont(fnt);
		labelMoney.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		
		this.add(title);
		this.add(labelId);
		this.add(labelDate);
		this.add(labelDestination);
		this.add(labelDeparture);
		this.add(labelAirline);
		this.add(labelStand);
		this.add(labelGuard);
		this.add(labelAllID);
		this.add(labelMoney);
		
		this.add(textId);
		this.add(textDate);
		this.add(textAirline);
		this.add(textGuard);
		this.add(textStand);
		this.add(textAllID);
		this.add(textMoney);
		this.add(comboBox1);
		this.add(comboBox2);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		setTestState(true);

		String[] columnNames = { "中转单编号", "装车日期", "出发地", "目的地", "航班号","所有托运单号","运费" };  
		int[] list={40,91,14,30,20,315,105,655,547};

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
		textDate.setEditable(state);
		textAirline.setEditable(state);
		textStand.setEditable(state);
		textGuard.setEditable(state);
		textAllID.setEnabled(state);
		textMoney.setEnabled(state);

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textDate.setText(null);
		textAirline.setText(null);
		textGuard.setText(null);
		textGuard.setText(null);
		textStand.setText(null);
		textMoney.setText(null);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		
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
		g.draw3DRect(40, 105, 250, 547, false);  //输入框外框
		this.repaint();
	}



	

	

}
