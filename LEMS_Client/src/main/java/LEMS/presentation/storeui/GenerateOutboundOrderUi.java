package LEMS.presentation.storeui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;

/**
 * 
 * @author 周梦佳
 *生成出库单界面
 */
public class GenerateOutboundOrderUi extends JPanel{


	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;

	private JLabel labelId;
	private JTextField textId;
	private JLabel labelOutDate;
	private JTextField textOutDate;
	private JLabel labelDestination;
	private JLabel labelTransportType;
	private JLabel labelTransferNum1;
	private JLabel labelTransferNum2;
	private JTextField textTransferNum;
	


	private JComboBox<String> comboBox1;//destination
	private JComboBox<String> comboBox2;//transportType
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	public GenerateOutboundOrderUi(final MainFrame mainFrame) {
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
		title = new JLabel("仓库管理（出库）");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		labelId = new JLabel("快递单号:");
		textId = new JTextField();
		labelOutDate = new JLabel("出库日期:");
		textOutDate = new JTextField();
		labelDestination = new JLabel("目的地:");
		labelTransportType = new JLabel("装运形式:");
		labelTransferNum1 = new JLabel("中转单编号");
		labelTransferNum2 = new JLabel("或汽运编号:");
		textTransferNum = new JTextField();
	

		comboBox1 = new JComboBox<String>();
		comboBox2 = new JComboBox<String>();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(340, 37, 230, 39);
		
		labelId.setBounds(50, 180, 131, 30);
		labelOutDate.setBounds(50, 250, 131, 30);
		labelDestination.setBounds(55, 320, 131, 30);
		labelTransportType.setBounds(50, 390, 131, 30);
		labelTransferNum1.setBounds(46, 450, 161, 30);
		labelTransferNum2.setBounds(46, 470, 161, 30);
		
		textId.setBounds(130, 185, 130, 24);
		textOutDate.setBounds(130, 255, 130, 24);
		textTransferNum.setBounds(130, 465, 130, 24);
		
		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelOutDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelTransportType.setFont(fnt);
		labelTransferNum1.setFont(fnt);
		labelTransferNum2.setFont(fnt);
		
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		
		comboBox1.setBounds(130, 325, 130, 25);
		comboBox1.addItem("");
		comboBox1.addItem("北京");
		comboBox1.addItem("上海");
		comboBox1.addItem("广州");
		comboBox1.addItem("南京");
		
		comboBox2.setBounds(130, 395, 130, 25);
		comboBox2.addItem("");
		comboBox2.addItem("飞机");
		comboBox2.addItem("火车");
		comboBox2.addItem("汽车");
		
		OK.setBounds(50, 550, 90, 40);
		cancel.setBounds(170, 550, 90, 40);
		exit.setBounds(47, 70, 100, 40);
	
		this.add(title);
		this.add(labelId);
		this.add(textId);
		this.add(labelOutDate);
		this.add(textOutDate);
		this.add(labelDestination);
		this.add(labelTransportType);
		this.add(labelTransferNum1);
		this.add(labelTransferNum2);
		this.add(textTransferNum);
	
		this.add(comboBox1);
		this.add(comboBox2);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		
		
	String[] columnNames = { "快递单号", "出库日期", "目的地", "装运形式", "中转单/汽运编号" };  
	int[] list={40,110,14,30,20,290,145,570,480};

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
		textOutDate.setEditable(state);
		textTransferNum.setEditable(state);
		
		comboBox1.setEnabled(state);
		comboBox2.setEnabled(state);

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textOutDate.setText(null);
		textTransferNum.setText(null);
		comboBox1.setToolTipText(null);
		comboBox2.setToolTipText(null);
		
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
		g.draw3DRect(35, 145, 240, 480, false);  //输入框外框
		this.repaint();
	}




}
