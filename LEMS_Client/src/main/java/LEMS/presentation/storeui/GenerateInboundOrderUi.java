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
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
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

		title.setBounds(340, 37, 230, 39);
		
		labelId.setBounds(40, 160, 131, 30);
		labelInDate.setBounds(40, 220, 131, 30);
		labelDestination.setBounds(45, 280, 131, 30);
		labelArea.setBounds(40, 340, 131, 30);
		labelRow.setBounds(55, 400, 131, 30);
		labelStand.setBounds(55, 460, 131, 30);
		labelPosition.setBounds(55, 520, 131, 30);
		
		textId.setBounds(113, 165, 130, 24);
		textInDate.setBounds(113, 225, 130, 24);
		textRow.setBounds(113, 405, 130, 24);
		textStand.setBounds(113, 465, 130, 24);
		textPosition.setBounds(113, 525, 130, 24);
		
		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelInDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelArea.setFont(fnt);
		labelRow.setFont(fnt);
		labelStand.setFont(fnt);
		labelPosition.setFont(fnt);
		
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		
		comboBox1.setBounds(113, 285, 130, 25);
		comboBox1.addItem("");
		comboBox1.addItem("北京");
		comboBox1.addItem("上海");
		comboBox1.addItem("广州");
		comboBox1.addItem("南京");
		
		comboBox2.setBounds(113, 345, 130, 25);
		comboBox2.addItem("");
		comboBox2.addItem("航运区");
		comboBox2.addItem("铁运区");
		comboBox2.addItem("汽运区");
		comboBox2.addItem("机动区");
		
		OK.setBounds(40, 590, 90, 40);
		cancel.setBounds(160, 590, 90, 40);
		exit.setBounds(47, 70, 100, 40);

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
	
		

		String[] columnNames = { "快递单号", "入库日期", "目的地", "存放区域", "排号","架号","位号" };  
		int[] list={40,81,14,30,20,285,136,588,520};

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
		g.draw3DRect(25, 136, 240, 520, false);  //输入框外框
		this.repaint();
	}


}
