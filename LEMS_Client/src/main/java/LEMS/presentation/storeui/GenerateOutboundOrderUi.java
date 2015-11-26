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
	private JButton inbound;
	private JButton outbound;
	

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
	
	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式

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
		inbound = new JButton("入库");
		outbound = new JButton("出库");
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

		title.setBounds(400, 37, 230, 39);
		
		labelId.setBounds(100, 190, 131, 30);
		labelOutDate.setBounds(100, 260, 131, 30);
		labelDestination.setBounds(105, 330, 131, 30);
		labelTransportType.setBounds(100, 400, 131, 30);
		labelTransferNum1.setBounds(96, 460, 161, 30);
		labelTransferNum2.setBounds(96, 480, 161, 30);
		
		textId.setBounds(200, 195, 150, 24);
		textOutDate.setBounds(200, 265, 150, 24);
		textTransferNum.setBounds(200, 475, 150, 24);
		
		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelOutDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelTransportType.setFont(fnt);
		labelTransferNum1.setFont(fnt);
		labelTransferNum2.setFont(fnt);
		
		comboBox1.setBounds(200, 333, 150, 28);
		comboBox1.addItem("");
		comboBox1.addItem("北京");
		comboBox1.addItem("上海");
		comboBox1.addItem("广州");
		comboBox1.addItem("南京");
		
		comboBox2.setBounds(200, 403, 150, 28);
		comboBox2.addItem("");
		comboBox2.addItem("飞机");
		comboBox2.addItem("火车");
		comboBox2.addItem("汽车");
		
		OK.setBounds(100, 550, 100, 40);
		cancel.setBounds(240, 550, 100, 40);
		exit.setBounds(52, 36, 100, 40);
		inbound.setBounds(300, 100, 100, 40);
		outbound.setBounds(600, 100, 100, 40);
	
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
		this.add(inbound);
		this.add(outbound);
		
		
	String[] columnNames = { "快递单号", "出库日期", "目的地", "装运形式", "中转单或汽运编号" };  
	int[] list={40,116,14,30,20,384,166,600,465};

		Table table=new Table();
		add(table.drawTable(columnNames, list));
	
		
		
		
		
		
	    }
	
	
	
	public class Jxxk extends JFrame  
	{  
	    private JTabbedPane tabbedPane;  
	    private JLabel label1,label2,label3;  
	    private JPanel panel1,panel2,panel3;  
	  
	    public Jxxk()  
	    {  
	        super("选项卡窗口"); setSize(400,300);  
	  
	        Container c = getContentPane();  
	        tabbedPane=new JTabbedPane();   //创建选项卡面板对象  
	        //创建标签  
	        label1=new JLabel("第一个标签的面板",SwingConstants.CENTER);  
	        label2=new JLabel("第二个标签的面板",SwingConstants.CENTER);  
	        label3=new JLabel("第三个标签的面板",SwingConstants.CENTER);  
	        //创建面板  
	        panel1=new JPanel();  
	        panel2=new JPanel();  
	        panel3=new JPanel();  
	  
	        panel1.add(label1);  
	        panel2.add(label2);  
	        panel3.add(label3);  
	  
	        panel1.setBackground(Color.yellow);  
	        panel2.setBackground(Color.blue);  
	        panel3.setBackground(Color.green);  
	        //将标签面板加入到选项卡面板对象上  
	        tabbedPane.addTab("标签1",null,panel1,"First panel");  
	        tabbedPane.addTab("标签2",null,panel2,"Second panel");  
	        tabbedPane.addTab("标签3",null,panel3,"Third panel");  
	  
	        c.add(tabbedPane);  
	        c.setBackground(Color.white);  
	  
	      
	    }  
	      
	   
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
		inbound.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new GenerateInboundOrderUi(mainFrame));
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
		g.draw3DRect(63, 166, 306, 460, false);  //输入框外框
		this.repaint();
	}




}
