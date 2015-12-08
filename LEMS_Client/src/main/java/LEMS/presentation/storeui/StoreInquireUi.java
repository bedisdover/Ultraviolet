package LEMS.presentation.storeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JLabel hourStart;
	private JLabel minuteStart;
	private JLabel secondStart;
	private JLabel hourEnd;
	private JLabel minuteEnd;
	private JLabel secondEnd;
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

	private JComboBox<Integer> sHour;
	private JComboBox<Integer> sMin;
	private JComboBox<Integer> sSec;
	private JComboBox<Integer> eHour;
	private JComboBox<Integer> eMin;
	private JComboBox<Integer> eSec;

	Table table;
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
		hourStart=new JLabel("小时");
		minuteStart=new JLabel("分钟");
		secondStart=new JLabel("秒");
		hourEnd=new JLabel("小时");
		minuteEnd=new JLabel("分钟");
		secondEnd=new JLabel("秒");
		textInboundNum = new JTextField();
		textOutboundNum = new JTextField();
		textMoney = new JTextField();
		textStoreNum = new JTextField();
		textAirlineNum = new JTextField();
		textTrainlineNum = new JTextField();
		textBuslineNum = new JTextField();
		textMotolineNum = new JTextField();
		dateChooserStart = new DateChooser(this, 343, 86);
		dateChooserEnd = new DateChooser(this, 343, 136);

		sHour = new JComboBox<Integer>();
		sMin = new JComboBox<Integer>();
		sSec = new JComboBox<Integer>();
		eHour = new JComboBox<Integer>();
		eMin = new JComboBox<Integer>();
		eSec = new JComboBox<Integer>();

	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(440, 37, 230, 39);
		startTime.setBounds(260, 80, BOUND_X, BOUND_Y);
		endTime.setBounds(260, 130, BOUND_X, BOUND_Y);
		labelInboundNum.setBounds(LOCATION_X, LOCATION_Y+20, BOUND_X, BOUND_Y);
		labelOutboundNum.setBounds(LOCATION_X, LOCATION_Y + 55, BOUND_X, BOUND_Y);
		labelMoney.setBounds(LOCATION_X + 25, LOCATION_Y + 90, BOUND_X, BOUND_Y);
		labelStoreNum.setBounds(LOCATION_X, LOCATION_Y + 125, BOUND_X, BOUND_Y);
		labelAirlineNum.setBounds(LOCATION_X + 270, LOCATION_Y+20, BOUND_X, BOUND_Y);
		labelTrainlineNum.setBounds(LOCATION_X + 270, LOCATION_Y + 55, BOUND_X, BOUND_Y);
		labelBuslineNum.setBounds(LOCATION_X + 270, LOCATION_Y + 90, BOUND_X, BOUND_Y);
		labelMotolineNum.setBounds(LOCATION_X + 270, LOCATION_Y + 125, BOUND_X, BOUND_Y);
		hourStart.setBounds(LOCATION_X+300, LOCATION_Y-128, BOUND_X-85, BOUND_Y-5);
		minuteStart.setBounds(LOCATION_X+390, LOCATION_Y-128, BOUND_X-85, BOUND_Y-5);
		secondStart.setBounds(LOCATION_X+480, LOCATION_Y-128, BOUND_X-85, BOUND_Y-5);
		hourEnd.setBounds(LOCATION_X+300, LOCATION_Y-78, BOUND_X-85, BOUND_Y-5);
		minuteEnd.setBounds(LOCATION_X+390, LOCATION_Y-78, BOUND_X-85, BOUND_Y-5);
		secondEnd.setBounds(LOCATION_X+480, LOCATION_Y-78, BOUND_X-85, BOUND_Y-5);
		textInboundNum.setBounds(LOCATION_X + 100, LOCATION_Y + 25, BOUND_X, BOUND_Y - 5);
		textOutboundNum.setBounds(LOCATION_X + 100, LOCATION_Y + 60, BOUND_X, BOUND_Y - 5);
		textMoney.setBounds(LOCATION_X + 100, LOCATION_Y + 95, BOUND_X, BOUND_Y - 5);
		textStoreNum.setBounds(LOCATION_X + 100, LOCATION_Y + 130, BOUND_X, BOUND_Y - 5);
		textAirlineNum.setBounds(LOCATION_X + 390, LOCATION_Y + 25, BOUND_X, BOUND_Y - 5);
		textTrainlineNum.setBounds(LOCATION_X + 390, LOCATION_Y + 60, BOUND_X, BOUND_Y - 5);
		textBuslineNum.setBounds(LOCATION_X + 390, LOCATION_Y + 95, BOUND_X, BOUND_Y - 5);
		textMotolineNum.setBounds(LOCATION_X + 390, LOCATION_Y + 130, BOUND_X, BOUND_Y - 5);
		sHour.setBounds(LOCATION_X+250, LOCATION_Y-128, BOUND_X-85, BOUND_Y-5);
		sMin.setBounds(LOCATION_X+340, LOCATION_Y-128, BOUND_X-85, BOUND_Y-5);
		sSec.setBounds(LOCATION_X+430, LOCATION_Y-128, BOUND_X-85, BOUND_Y-5);
		eHour.setBounds(LOCATION_X+250, LOCATION_Y-78, BOUND_X-85, BOUND_Y-5);
		eMin.setBounds(LOCATION_X+340, LOCATION_Y-78, BOUND_X-85, BOUND_Y-5);
		eSec.setBounds(LOCATION_X+430, LOCATION_Y-78, BOUND_X-85, BOUND_Y-5);
		for (int i = 0; i < 24; i++) {
			eHour.addItem(i);
			sHour.addItem(i);
		}
		for (int j = 0; j < 60; j++) {
			sMin.addItem(j);
			sSec.addItem(j);
			eMin.addItem(j);
			eSec.addItem(j);
		}

		OK.setBounds(390, 175, BOUND_X - 41, BOUND_Y + 10);
		cancel.setBounds(510, 175, BOUND_X - 41, BOUND_Y + 10);
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
		hourStart.setFont(fnt);
		minuteStart.setFont(fnt);
		secondStart.setFont(fnt);
		hourEnd.setFont(fnt);
		minuteEnd.setFont(fnt);
		secondEnd.setFont(fnt);
		textInboundNum.setFont(fnt);
		textOutboundNum.setFont(fnt);
		textMoney.setFont(fnt);
		textStoreNum.setFont(fnt);
		textAirlineNum.setFont(fnt);
		textBuslineNum.setFont(fnt);
		textMotolineNum.setFont(fnt);
		textTrainlineNum.setFont(fnt);
		sHour.setFont(fnt);
		sMin.setFont(fnt);
		sSec.setFont(fnt);
		eHour.setFont(fnt);
		eMin.setFont(fnt);
		eSec.setFont(fnt);
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
		// 设置jtextfield透明色
		textInboundNum.setOpaque(false);
		textOutboundNum.setOpaque(false);
		textMoney.setOpaque(false);
		textStoreNum.setOpaque(false);
		textAirlineNum.setOpaque(false);
		textBuslineNum.setOpaque(false);
		textMotolineNum.setOpaque(false);
		textTrainlineNum.setOpaque(false);

		// textInboundNum.setBorder(new LineBorder(Color.DARK_GRAY));

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
		this.add(hourStart);
		this.add(minuteStart);
		this.add(secondStart);
		this.add(hourEnd);
		this.add(minuteEnd);
		this.add(secondEnd);
		this.add(textInboundNum);
		this.add(textOutboundNum);
		this.add(textMoney);
		this.add(textStoreNum);
		this.add(textAirlineNum);
		this.add(textBuslineNum);
		this.add(textMotolineNum);
		this.add(textTrainlineNum);
		this.add(sHour);
		this.add(sMin);
		this.add(sSec);
		this.add(eHour);
		this.add(eMin);
		this.add(eSec);

		String[] columnNames = { "快递单号", "入库日期", "出库日期", "目的地", "存储区域", "架号", "排号", "位号", "装运形式", "单号" };
		int[] list = { 40, 85, 14, 30, 20, 70, 395, 868, 250 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
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
				StoreManagement sm = new StoreManagement();

				String startTime = sHour.getSelectedItem().toString() + sMin.getSelectedItem().toString()
						+ sSec.getSelectedItem().toString();
				String endTime = eHour.getSelectedItem().toString() + eMin.getSelectedItem().toString()
						+ eSec.getSelectedItem().toString();
				String start = dateChooserStart.getTime() + startTime;
				String end = dateChooserEnd.getTime() + endTime;

				if (start.compareTo(end) >= 0) {
					// 不合法 跳出提示
				} else {
					ArrayList<GoodsVO> al = sm.inquire(start, end);
					int length = al.size();
					textInboundNum.setText(al.get(length - 8).getId());
					textOutboundNum.setText(al.get(length - 7).getId());
					textStoreNum.setText(al.get(length - 6).getId());
					textMoney.setText(al.get(length - 5).getId());
					textAirlineNum.setText(al.get(length - 4).getId());
					textTrainlineNum.setText(al.get(length - 3).getId());
					textBuslineNum.setText(al.get(length - 2).getId());
					textMotolineNum.setText(al.get(length - 1).getId());
					int showRow=0;
					
					for(int p=0;p<length-8;p++){
						GoodsVO gvo=al.get(p);
						table.setValueAt(showRow, 0, gvo.getId());
						table.setValueAt(showRow, 1, gvo.getInDate());
						table.setValueAt(showRow, 2, gvo.getOutDate());
						table.setValueAt(showRow, 3, gvo.getDestination().name());
						table.setValueAt(showRow, 4, gvo.getArea().name());
						table.setValueAt(showRow, 5, gvo.getRow());
						table.setValueAt(showRow, 6, gvo.getStand());
						table.setValueAt(showRow, 7, gvo.getPosition());
						table.setValueAt(showRow, 8, gvo.getTransportType().name());
						table.setValueAt(showRow, 9, gvo.getTransferNum());
						table.setValueAt(showRow, 10, gvo.getMoney()+"");
						showRow++;
					}
				}

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
