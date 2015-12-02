package LEMS.presentation.orderui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.storeui.DateChooser;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * @author 周梦佳
 * 接收界面
 */
@SuppressWarnings("serial")
public class ReceiveUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=110;
	private static final int LOCATION_LABEL_Y=150;
	private static final int LOCATION_TEXT_X=220;
	private static final int LOCATION_TEXT_Y=155;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	
	private JLabel labelDate;
	private JLabel labelId;
	private JLabel labelDeparture;
	private JLabel labelStatus;
	
	private JTextField textId;
	
	private JComboBox<String> comboBox1;//departure
	private JComboBox<String> comboBox2;//status
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
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

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("接收");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
	
		labelDate = new JLabel("到达日期:");
		labelId = new JLabel("订单编号:");
		labelDeparture = new JLabel("出发地:");
		labelStatus = new JLabel("货物到达状态：");
		
		textId = new JTextField();
		
		comboBox1 = new JComboBox<String>();
		comboBox2 = new JComboBox<String>();
		
		DateChooser dc= new DateChooser(this,LOCATION_TEXT_X,LOCATION_TEXT_Y);
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(450, 27, 230, 39);
		
		labelDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+80, BOUND_X, BOUND_Y);
		labelDeparture.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+160, BOUND_X, BOUND_Y);
		labelStatus.setBounds(LOCATION_LABEL_X-15, LOCATION_LABEL_Y+240, BOUND_X, BOUND_Y);
		
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+80, BOUND_X, BOUND_Y-6);
		
		comboBox1.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+160, BOUND_X, BOUND_Y-5);
		comboBox1.addItem("");
		comboBox1.addItem("北京");
		comboBox1.addItem("上海");
		comboBox1.addItem("广州");
		comboBox1.addItem("南京");
		
		comboBox2.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+240, BOUND_X, BOUND_Y-5);
		comboBox2.addItem("");
		comboBox2.addItem("到达");
		comboBox2.addItem("丢失");
		
		
		OK.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+335, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+135, LOCATION_LABEL_Y+335, BOUND_X-40, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);

		
		title.setFont(fnt1);
		labelDate.setFont(fnt);
		labelId.setFont(fnt);
		labelDeparture.setFont(fnt);
		labelStatus.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		
		textId.setFont(fnt2);
		

		this.add(title);
		this.add(labelDate);
		this.add(labelId);
		this.add(labelDeparture);
		this.add(labelStatus);
		this.add(textId);
		this.add(comboBox1);
		this.add(comboBox2);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		setTestState(true);

		String[] columnNames = { "到达日期", "订单编号", "出发地","货物到达状态"};  
		int[] list={40,128,14,30,20,410,125,530,480};

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

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		
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
		g.draw3DRect(75, 125, 305, 480, false);  //输入框外框
		this.repaint();
	}



	

	





	
}
