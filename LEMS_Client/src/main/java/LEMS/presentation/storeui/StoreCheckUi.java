package LEMS.presentation.storeui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import LEMS.businesslogic.storebl.StoreManagement;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.ExportExcel;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.storevo.GoodsVO;

/**
 * 
 * @author 周梦佳  4库存盘点（盘点的是当天的库存快照，包括当天的各区快递的信息（快递编号、入库日期、目的地、区号、排号、架号、位号） 。
 *         要求可以导出Excel。 盘点时，系统自动根据当前盘点时间生成一个截止点，这个点就是批次（日期）批号（序号），
 *         在这个截点之后做的出入库是不计入盘点的。
 */
public class StoreCheckUi extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int LOCATION_X = 440;
	private static final int LOCATION_Y = 37;

	private MainFrame mainFrame;
	private JLabel title;
	private JLabel labelTime;
	private UltraButton exit;
	private UltraButton OK;
	private UltraButton cancel;
	private UltraButton excel;
	private UltraTextField textTime;

	Table table;
	String timeToTransfer = "";
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 18);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式

	public StoreCheckUi(final MainFrame mainFrame) {
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
		this.addListener();

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("库存盘点");
		exit = new UltraButton("返回");
		OK = new UltraButton("开始盘点");
		excel = new UltraButton("导出表格");
		cancel = new UltraButton("取消盘点");
		labelTime = new JLabel("盘点截止时间：");
		textTime = new UltraTextField();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {
		title.setBounds(LOCATION_X, LOCATION_Y, 230, 39);
		OK.setBounds(LOCATION_X - 110, LOCATION_Y + 120, 180, 60);
		cancel.setBounds(LOCATION_X + 35, LOCATION_Y + 120, 180, 60);
		exit.setBounds(90, 60, 100, 40);
		labelTime.setBounds(LOCATION_X - 70, LOCATION_Y + 65, 140, 40);
		textTime.setBounds(LOCATION_X + 60, LOCATION_Y + 75, 100, 25);
		excel.setBounds(LOCATION_X + 320, LOCATION_Y + 80, 120, 40);

		title.setFont(fnt1);
		labelTime.setFont(fnt);

		excel.setEnabled(false);
		textTime.setOpaque(false);
		this.add(title);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(labelTime);
		this.add(textTime);
		this.add(excel);

		String[] columnNames = { "快递单号", "入库日期", "目的地", "存储区域", "架号", "排号", "位号" };
		int[] list = { 40, 118, 14, 30, 20, 85, 225, 844, 410 };
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
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textTime.setText(null);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		excel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				StoreManagement storeManagement = new StoreManagement();
				ArrayList<GoodsVO> alList = storeManagement.check(timeToTransfer);
				ArrayList<Object> al = new ArrayList<Object>();
				int length = alList.size();
				for (int i = 0; i < length - 8; i++) {
					al.add(alList.get(i).getId());
					al.add(alList.get(i).getInDate());
					al.add(alList.get(i).getOutDate());
					al.add(alList.get(i).getDestination());
					al.add(alList.get(i).getArea());
					al.add(alList.get(i).getRow());
					al.add(alList.get(i).getStand());
					al.add(alList.get(i).getPosition());
					al.add(alList.get(i).getTransportType());
					al.add(alList.get(i).getTransferNum());
				}
				ExportExcel operation = new ExportExcel();
				String[] title = new String[7];
				title[0] = "快递单号";
				title[1] = "入库日期";
				title[2] = "出库日期";
				title[3] = "目的地";
				title[4] = "存储区域";
				title[5] = "架号";
				title[6] = "排号";
				title[7] = "位号";
				title[8] = "装运形式";
				title[9] = "单号";
				operation.exportExcel("f:/text.xls", "库存盘点", title, al);
			}
		});

		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi l = new LoginUi(mainFrame);
				mainFrame.setContentPane(l);
			}
		});

		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Color color=Color.white.darker();
				System.out.println(color.getRed()+" "+color.getBlue()+" "+color.getGreen());
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH:mm:ss");// 设置日期格式
				String time = df.format(new Date()).substring(8, 16);
				timeToTransfer = time.substring(0, 2) + time.substring(3, 5) + time.substring(6, 8);
				textTime.setText(time);
				OK.setEnabled(false);
				excel.setEnabled(true);
				StoreManagement storeManagement = new StoreManagement();
				ArrayList<GoodsVO> al = storeManagement.check(timeToTransfer);
				int length = al.size();
				int showRow = table.numOfEmpty();
				for (int p = 0; p < length - 8; p++) {
					GoodsVO gvo = al.get(p);
					table.setValueAt(showRow, 0, gvo.getId());
					table.setValueAt(showRow, 1, gvo.getInDate().substring(0, 8));
					switch (gvo.getDestination().name()) {
					case "Beijing":
						table.setValueAt(showRow, 2, "北京");
						break;
					case "Shanghai":
						table.setValueAt(showRow, 2, "上海");
						break;
					case "Guangzhou":
						table.setValueAt(showRow, 2, "广州");
						break;
					case "Nanjing":
						table.setValueAt(showRow, 2, "南京");
						break;
					}
					switch (gvo.getArea().name()) {
					case "Airline":
						table.setValueAt(showRow, 3, "航运区");
						break;
					case "Trainline":
						table.setValueAt(showRow, 3, "铁运区");
						break;
					case "Busline":
						table.setValueAt(showRow, 3, "汽运区");
						break;
					case "Motoline":
						table.setValueAt(showRow, 3, "机动区");
						break;
					}
					table.setValueAt(showRow, 4, gvo.getRow() + "");
					table.setValueAt(showRow, 5, gvo.getStand() + "");
					table.setValueAt(showRow, 6, gvo.getPosition() + "");
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
		this.repaint();
	}

}
