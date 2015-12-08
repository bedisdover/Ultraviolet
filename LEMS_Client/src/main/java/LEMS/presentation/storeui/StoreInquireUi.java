package LEMS.presentation.storeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.storebl.StoreManagement;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.vo.storevo.GoodsVO;

/**
 * 
 * @author 周梦佳 3库存查看 设定一个时间段，查看此时间段内的出/入库数量/金额，存储位置，库存数量要有合计
 */
public class StoreInquireUi extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int LOCATION_X = 240;
	private static final int LOCATION_Y = 213;
	private static final int BOUND_X = 131;
	private static final int BOUND_Y = 30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JLabel labelInboundNum;
	private JLabel labelOutboundNum;
	private JLabel labelMoney;
	private JLabel labelStoreNum;
	private JLabel labelAirlineNum;
	private JLabel labelTrainlineNum;
	private JLabel labelBuslineNum;
	private JLabel labelMotolineNum;
	private JTextField textInboundNum;
	private JTextField textOutboundNum;
	private JTextField textMoney;
	private JTextField textStoreNum;
	private JTextField textAirlineNum;
	private JTextField textTrainlineNum;
	private JTextField textBuslineNum;
	private JTextField textMotolineNum;
	private JLabel startTime;
	private JLabel endTime;
	private DateChooser dateChooserStart;
	private DateChooser dateChooserEnd;

	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 17);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式

	public StoreInquireUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 设置输入框不可编辑
		// this.setTestState(false);
		// 添加事件监听器
		// this.addListener();

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("库存查看");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		startTime = new JLabel("开始时间：");
		endTime = new JLabel("结束时间：");
		labelInboundNum = new JLabel("入库数量：");
		labelOutboundNum = new JLabel("出库数量：");
		labelMoney = new JLabel("金额：");
		labelStoreNum = new JLabel("库存数量：");
		labelAirlineNum = new JLabel("航运区数量：");
		labelTrainlineNum = new JLabel("铁运区数量：");
		labelBuslineNum = new JLabel("汽运区数量：");
		labelMotolineNum = new JLabel("机动区数量：");
		textInboundNum = new JTextField();
		textOutboundNum = new JTextField();
		textMoney = new JTextField();
		textStoreNum = new JTextField();
		textAirlineNum = new JTextField();
		textTrainlineNum = new JTextField();
		textBuslineNum = new JTextField();
		textMotolineNum = new JTextField();
		dateChooserStart = new DateChooser(this, 353, 106);
		dateChooserEnd = new DateChooser(this, 593, 106);

	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(440, 37, 230, 39);
		startTime.setBounds(270, 100, BOUND_X, BOUND_Y);
		endTime.setBounds(510, 100, BOUND_X, BOUND_Y);
		labelInboundNum.setBounds(LOCATION_X, LOCATION_Y, BOUND_X, BOUND_Y);
		labelOutboundNum.setBounds(LOCATION_X, LOCATION_Y + 40, BOUND_X, BOUND_Y);
		labelMoney.setBounds(LOCATION_X + 25, LOCATION_Y + 80, BOUND_X, BOUND_Y);
		labelStoreNum.setBounds(LOCATION_X, LOCATION_Y + 120, BOUND_X, BOUND_Y);
		labelAirlineNum.setBounds(LOCATION_X+270, LOCATION_Y, BOUND_X, BOUND_Y);
		labelTrainlineNum.setBounds(LOCATION_X+270, LOCATION_Y+40, BOUND_X, BOUND_Y);
		labelBuslineNum.setBounds(LOCATION_X+270, LOCATION_Y+80, BOUND_X, BOUND_Y);
		labelMotolineNum.setBounds(LOCATION_X+270, LOCATION_Y+120, BOUND_X, BOUND_Y);
		
		textInboundNum.setBounds(LOCATION_X + 100, LOCATION_Y + 5, BOUND_X, BOUND_Y - 5);
		textOutboundNum.setBounds(LOCATION_X + 100, LOCATION_Y + 45, BOUND_X, BOUND_Y - 5);
		textMoney.setBounds(LOCATION_X + 100, LOCATION_Y + 85, BOUND_X, BOUND_Y - 5);
		textStoreNum.setBounds(LOCATION_X + 100, LOCATION_Y + 125, BOUND_X, BOUND_Y - 5);
		textAirlineNum.setBounds(LOCATION_X + 390, LOCATION_Y + 5, BOUND_X, BOUND_Y - 5);
		textTrainlineNum.setBounds(LOCATION_X + 390, LOCATION_Y + 45, BOUND_X, BOUND_Y - 5);
		textBuslineNum.setBounds(LOCATION_X + 390, LOCATION_Y + 85, BOUND_X, BOUND_Y - 5);
		textMotolineNum.setBounds(LOCATION_X + 390, LOCATION_Y + 125, BOUND_X, BOUND_Y - 5);
	
		OK.setBounds(390, 145, BOUND_X - 41, BOUND_Y + 10);
		cancel.setBounds(510, 145, BOUND_X - 41, BOUND_Y + 10);
		exit.setBounds(90, 60, 100, 40);

		title.setFont(fnt1);
		startTime.setFont(fnt);
		endTime.setFont(fnt);
		labelInboundNum.setFont(fnt);
		labelOutboundNum.setFont(fnt);
		labelMoney.setFont(fnt);
		labelStoreNum.setFont(fnt);
		labelAirlineNum.setFont(fnt);
		labelBuslineNum.setFont(fnt);
		labelMotolineNum.setFont(fnt);
		labelTrainlineNum.setFont(fnt);
		textInboundNum.setFont(fnt);
		textOutboundNum.setFont(fnt);
		textMoney.setFont(fnt);
		textStoreNum.setFont(fnt);
		textAirlineNum.setFont(fnt);
		textBuslineNum.setFont(fnt);
		textMotolineNum.setFont(fnt);
		textTrainlineNum.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		textInboundNum.setEditable(false);
		textOutboundNum.setEditable(false);
		textMoney.setEditable(false);
		textStoreNum.setEditable(false);
		textAirlineNum.setEditable(false);
		textBuslineNum.setEditable(false);
		textMotolineNum.setEditable(false);
		textTrainlineNum.setEditable(false);
		//设置jtextfield透明色
		textInboundNum.setOpaque(false);
		textOutboundNum.setOpaque(false);
		textMoney.setOpaque(false);
		textStoreNum.setOpaque(false);
		textAirlineNum.setOpaque(false);
		textBuslineNum.setOpaque(false);
		textMotolineNum.setOpaque(false);
		textTrainlineNum.setOpaque(false);
		
//		textInboundNum.setBorder(new LineBorder(Color.DARK_GRAY));
		
	
		this.add(title);
		this.add(startTime);
		this.add(endTime);
		this.add(dateChooserStart);
		this.add(dateChooserEnd);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(labelInboundNum);
		this.add(labelOutboundNum);
		this.add(labelMoney);
		this.add(labelStoreNum);
		this.add(labelAirlineNum);
		this.add(labelBuslineNum);
		this.add(labelMotolineNum);
		this.add(labelTrainlineNum);
		this.add(textInboundNum);
		this.add(textOutboundNum);
		this.add(textMoney);
		this.add(textStoreNum);
		this.add(textAirlineNum);
		this.add(textBuslineNum);
		this.add(textMotolineNum);
		this.add(textTrainlineNum);

		String[] columnNames = { "快递单号", "入库日期", "出库日期", "目的地", "存储区域", "架号", "排号", "位号", "装运形式", "单号" };
		int[] list = { 40, 85, 14, 30, 20, 70, 395, 868, 250 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
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

		dateChooserStart.setEnabled(state);
		dateChooserEnd.setEnabled(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {

		dateChooserStart.setToolTipText(null);
		dateChooserEnd.setToolTipText(null);
		textInboundNum.setText(null);
		textOutboundNum.setText(null);
		textMoney.setText(null);
		textStoreNum.setText(null);
		textAirlineNum.setText(null);
		textBuslineNum.setText(null);
		textMotolineNum.setText(null);
		textTrainlineNum.setText(null);
	

	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi l = new LoginUi(mainFrame);
				mainFrame.setContentPane(l);
			}
		});

		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(false);
				StoreManagement sm=new StoreManagement();
				String start=dateChooserStart.getTime();
				String end=dateChooserEnd.getTime();
				
				ArrayList<GoodsVO> al=sm.inquire("", "");
				int length=al.size();
				textInboundNum.setText(al.get(length-8).getId());
				textOutboundNum.setText(al.get(length-7).getId());
				textStoreNum.setText(al.get(length-6).getId());
				textMoney.setText(al.get(length-5).getId());
				textAirlineNum.setText(al.get(length-4).getId());
				textTrainlineNum.setText(al.get(length-3).getId());
				textBuslineNum.setText(al.get(length-2).getId());
				textMotolineNum.setText(al.get(length-1).getId());
				

			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				empty();
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		// g.draw3DRect(140, 200, 740, 200, false); //输入框外框
		this.repaint();
	}

}
