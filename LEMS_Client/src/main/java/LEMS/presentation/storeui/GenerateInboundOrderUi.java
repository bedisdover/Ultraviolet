package LEMS.presentation.storeui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;

/**
 * 
 * @author 周梦佳
 *生成入库单界面
 */
public class GenerateInboundOrderUi extends JPanel{

	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton inbound;
	private JButton outbound;
	

	private JLabel labelId;
	private JTextField textId;
	private JLabel labelInDate;
	private JTextField textInDate;
	private JLabel labelDestination;
	private JLabel labelArea;
	private JLabel labelRow;
	private JTextField textRow;
	private JLabel labelStand;
	private JTextField textStand;
	private JLabel labelPosition;
	private JTextField textPosition;

	private JComboBox<String> comboBox1;//destination
	private JComboBox<String> comboBox2;//area
	
	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式

	public GenerateInboundOrderUi(final MainFrame mainFrame) {
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
		title = new JLabel("仓库管理（入库）");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		inbound = new JButton("入库");
		outbound = new JButton("出库");
		labelId = new JLabel("快递单号:");
		textId = new JTextField();
		labelInDate = new JLabel("入库日期:");
		textInDate = new JTextField();
		labelDestination = new JLabel("目的地:");
		labelArea = new JLabel("存放区域:");
		labelRow = new JLabel("排号:");
		textRow = new JTextField();
		labelStand = new JLabel("架号:");
		textStand = new JTextField();
		labelPosition = new JLabel("位号:");
		textPosition = new JTextField();
		comboBox1 = new JComboBox<String>();
		comboBox2 = new JComboBox<String>();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(400, 37, 230, 39);
		
		labelId.setBounds(80, 180, 131, 30);
		labelInDate.setBounds(80, 240, 131, 30);
		labelDestination.setBounds(85, 300, 131, 30);
		labelArea.setBounds(80, 360, 131, 30);
		labelRow.setBounds(95, 420, 131, 30);
		labelStand.setBounds(95, 480, 131, 30);
		labelPosition.setBounds(95, 540, 131, 30);
		
		textId.setBounds(160, 185, 150, 24);
		textInDate.setBounds(160, 245, 150, 24);
		textRow.setBounds(160, 425, 150, 24);
		textStand.setBounds(160, 485, 150, 24);
		textPosition.setBounds(160, 545, 150, 24);
		
		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelInDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelArea.setFont(fnt);
		labelRow.setFont(fnt);
		labelStand.setFont(fnt);
		labelPosition.setFont(fnt);
		
		comboBox1.setBounds(160, 303, 150, 28);
		comboBox1.addItem("");
		comboBox1.addItem("北京");
		comboBox1.addItem("上海");
		comboBox1.addItem("广州");
		comboBox1.addItem("南京");
		
		comboBox2.setBounds(160, 363, 150, 28);
		comboBox2.addItem("");
		comboBox2.addItem("航运区");
		comboBox2.addItem("铁运区");
		comboBox2.addItem("汽运区");
		comboBox2.addItem("机动区");
		
		OK.setBounds(80, 600, 100, 40);
		cancel.setBounds(220, 600, 100, 40);
		exit.setBounds(52, 36, 100, 40);
		inbound.setBounds(300, 100, 100, 40);
		outbound.setBounds(600, 100, 100, 40);
	
		this.add(title);
		this.add(labelId);
		this.add(textId);
		this.add(labelInDate);
		this.add(textInDate);
		this.add(labelDestination);
		this.add(labelArea);
		this.add(labelRow);
		this.add(textRow);
		this.add(labelStand);
		this.add(textStand);
		this.add(labelPosition);
		this.add(textPosition);
		this.add(comboBox1);
		this.add(comboBox2);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(inbound);
		this.add(outbound);
		

		String[] columnNames = { "快递单号", "入库日期", "目的地", "存放区域", "排号","架号","位号" };  
		int[] list={40,87,14,30,20,355,156,630,500};

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
		textInDate.setEditable(state);
	
	
		textRow.setEditable(state);
		textStand.setEditable(state);
		textPosition.setEditable(state);
	
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
		textInDate.setText(null);
		
		textRow.setText(null);
		textStand.setText(null);
		textPosition.setText(null);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		outbound.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new GenerateOutboundOrderUi(mainFrame));
			}
		});



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
		g.draw3DRect(51, 156, 290, 500, false);  //输入框外框
		this.repaint();
	}


}
