package LEMS.presentation.storeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
/**
 * 
 * @author 周梦佳
 *3库存查看 设定一个时间段，查看此时间段内的出/入库数量/金额，存储位置，库存数量要有合计
 */
public class StoreInquireUi extends JPanel{
	private static final long serialVersionUID = 1L;
	private static final int LOCATION_X=360;
	private static final int LOCATION_Y=213;
	private static final int BOUND_X=131;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton excel;
	private JLabel inboundNum;
	private JLabel outboundNum;
	private JLabel money;
	private JLabel storeNum;
	private JTextField inbound;
	private JTextField outbound;
	private JTextField money1;
	private JTextField store;
	private JLabel startTime;
	private JLabel endTime;
	private DateChooser dateChooser1;
	private DateChooser dateChooser2;


	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 19);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	public StoreInquireUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 设置输入框不可编辑
	//	this.setTestState(false);
		// 添加事件监听器
	//	this.addListener();

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("库存查看");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		excel=new JButton("导出表格");
		startTime = new JLabel("开始时间：");
		endTime = new JLabel("结束时间：");
		inboundNum=new JLabel("入库数量：");
		outboundNum=new JLabel("出库数量：");
		money=new JLabel("金额：");
		storeNum=new JLabel("库存数量：");
		inbound=new JTextField();
		outbound=new JTextField();
		money1=new JTextField();
		store=new JTextField();
		
		dateChooser1=new DateChooser(this,353,106);
		dateChooser2=new DateChooser(this,593,106);

	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(440, 37, 230, 39);
		startTime.setBounds(270, 100, BOUND_X, BOUND_Y);
		endTime.setBounds(510, 100, BOUND_X, BOUND_Y);
		inboundNum.setBounds(LOCATION_X,LOCATION_Y ,BOUND_X , BOUND_Y);
		outboundNum.setBounds(LOCATION_X,LOCATION_Y+40 ,BOUND_X , BOUND_Y );
		money.setBounds(LOCATION_X+25,LOCATION_Y+80 ,BOUND_X , BOUND_Y );
		storeNum.setBounds(LOCATION_X,LOCATION_Y+120 ,BOUND_X , BOUND_Y );
		
		inbound.setBounds(LOCATION_X+100,LOCATION_Y+5 ,BOUND_X , BOUND_Y-5);
		outbound.setBounds(LOCATION_X+100,LOCATION_Y+40 ,BOUND_X , BOUND_Y-5 );
		money1.setBounds(LOCATION_X+100,LOCATION_Y+80 ,BOUND_X , BOUND_Y-5 );
		store.setBounds(LOCATION_X+100,LOCATION_Y+120 ,BOUND_X , BOUND_Y-5 );
		
		title.setFont(fnt1);
		startTime.setFont(fnt);
		endTime.setFont(fnt);
		inboundNum.setFont(fnt);
		outboundNum.setFont(fnt);
		money.setFont(fnt);
		storeNum.setFont(fnt);
		
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		excel.setFont(fnt2);
		
		OK.setBounds(390, 145,BOUND_X-41, BOUND_Y+10);
		cancel.setBounds(510, 145, BOUND_X-41, BOUND_Y+10);
		exit.setBounds(90, 60, 100, 40);
		excel.setBounds(680,320 ,BOUND_X , BOUND_Y+10);
		
		this.add(title);
		this.add(startTime);
		this.add(endTime);
		this.add(dateChooser1);
		this.add(dateChooser2);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(excel);
		this.add(inboundNum);
		this.add(outboundNum);
		this.add(money);
		this.add(storeNum);
		this.add(inbound);
		this.add(outbound);
		this.add(money1);
		this.add(store);

		
	String[] columnNames = { "快递单号", "入库日期","出库日期","目的地","存储区域","架号","排号","位号", "装运形式", "单号" };  
	int[] list={40,85,14,30,20,70,395,868,250};
	//list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
	 //* 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
	 //* 
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
		
		
		dateChooser1.setEnabled(state);
		dateChooser2.setEnabled(state);

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		
		dateChooser1.setToolTipText(null);
		dateChooser2.setToolTipText(null);
		
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 返回按钮的具体实现
			}
		});



		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 确定按钮的具体实现
				
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
//		g.draw3DRect(140, 200, 740, 200, false);  //输入框外框
		this.repaint();
	}

}
