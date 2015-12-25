package LEMS.presentation.storeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import LEMS.businesslogic.storebl.StoreGenerateOrder;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraComboBox;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.storevo.InboundOrderVO;

/**
 * 
 * @author 周梦佳 生成入库单界面
 */
public class GenerateInboundOrderUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X = 70;
	private static final int LOCATION_LABEL_Y = 130;
	private static final int LOCATION_TEXT_X = 163;
	private static final int LOCATION_TEXT_Y = 135;
	private static final int BOUND_X = 130;
	private static final int BOUND_Y = 30;

	private MainFrame mainFrame;
	private JLabel title;
	private UltraButton exit;
	private UltraButton OK;
	private UltraButton cancel;
	private UltraButton add;
	private UltraButton delete;
	private UltraButton update;
	private UltraButton inquire;
	private JLabel labelId;
	private JLabel labelInDate;
	private JLabel labelDestination;
	private JLabel labelArea;
	private JLabel labelRow;
	private JLabel labelStand;
	private JLabel labelPosition;
	private UltraTextField textId;
	private UltraTextField textRow;
	private UltraTextField textStand;
	private UltraTextField textPosition;
	private DateChooser dc;
	private UltraComboBox comboBoxDestination;
	private UltraComboBox comboBoxArea;

	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
	/**
	 * 判断是干什么的确定 1是新建 2是删除 3是修改 4是查找
	 */
	int whichButton = 0;
	Table table;
	/**
	 * 选中的行
	 */
	int currentLine = -1;

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
		exit = new UltraButton("返回");
		OK = new UltraButton("确定");
		cancel = new UltraButton("取消");
		add = new UltraButton("新增");
		delete = new UltraButton("删除");
		update = new UltraButton("修改");
		inquire = new UltraButton("查找");
		labelId = new JLabel("快递单号:");
		labelInDate = new JLabel("入库日期:");
		labelDestination = new JLabel("目的地:");
		labelArea = new JLabel("存放区域:");
		labelRow = new JLabel("排号:");
		labelStand = new JLabel("架号:");
		labelPosition = new JLabel("位号:");
		textId = new UltraTextField(15);
		textRow = new UltraTextField(15);
		textStand = new UltraTextField(15);
		textPosition = new UltraTextField(15);
		comboBoxDestination = new UltraComboBox();
		comboBoxArea = new UltraComboBox();
		dc = new DateChooser(this, LOCATION_TEXT_X, LOCATION_TEXT_Y + 55);

	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 37, 230, 39);
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelInDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 55, BOUND_X, BOUND_Y);
		labelDestination.setBounds(LOCATION_LABEL_X + 5, LOCATION_LABEL_Y + 110, BOUND_X, BOUND_Y);
		labelArea.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 165, BOUND_X, BOUND_Y);
		labelRow.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 220, BOUND_X, BOUND_Y);
		labelStand.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 275, BOUND_X, BOUND_Y);
		labelPosition.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 330, BOUND_X, BOUND_Y);
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y - 6);
		textRow.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 220, BOUND_X, BOUND_Y - 6);
		textStand.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 275, BOUND_X, BOUND_Y - 6);
		textPosition.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 330, BOUND_X, BOUND_Y - 6);
		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelInDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelArea.setFont(fnt);
		labelRow.setFont(fnt);
		labelStand.setFont(fnt);
		labelPosition.setFont(fnt);

		comboBoxDestination.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 110, BOUND_X, BOUND_Y - 5);
		comboBoxDestination.addItem("北京");
		comboBoxDestination.addItem("上海");
		comboBoxDestination.addItem("广州");
		comboBoxDestination.addItem("南京");
		comboBoxArea.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 165, BOUND_X, BOUND_Y - 5);
		comboBoxArea.addItem("航运区");
		comboBoxArea.addItem("铁运区");
		comboBoxArea.addItem("汽运区");
		comboBoxArea.addItem("机动区");
		OK.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 390, BOUND_X - 10, BOUND_Y + 10);
		cancel.setBounds(LOCATION_LABEL_X + 120, LOCATION_LABEL_Y + 390, BOUND_X - 10, BOUND_Y + 10);
		exit.setBounds(90, 60, 100, 40);
		add.setBounds(150, 610, 120, 40);
		delete.setBounds(350, 610, 120, 40);
		update.setBounds(550, 610, 120, 40);
		inquire.setBounds(750, 610, 120, 40);

		this.add(title);
		this.add(labelId);
		this.add(labelInDate);
		this.add(labelDestination);
		this.add(labelArea);
		this.add(labelRow);
		this.add(labelStand);
		this.add(labelPosition);
		this.add(textId);
		this.add(textRow);
		this.add(textStand);
		this.add(textPosition);
		this.add(comboBoxDestination);
		this.add(comboBoxArea);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(inquire);

		String[] columnNames = { "快递单号", "入库日期", "目的地", "存放区域", "排号", "架号", "位号" };
		int[] list = { 40, 87, 14, 30, 20, 350, 116, 627, 470 };

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
		textId.setEditable(state);
		textRow.setEditable(state);
		textStand.setEditable(state);
		textPosition.setEditable(state);
		comboBoxDestination.setEnabled(state);
		comboBoxArea.setEnabled(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
		dc.setEnabled(state);
	}

	private void buttonAllTrue() {
		add.setEnabled(true);
		delete.setEnabled(true);
		update.setEnabled(true);
		inquire.setEnabled(true);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textRow.setText(null);
		textStand.setText(null);
		textPosition.setText(null);
		comboBoxDestination.setSelectedIndex(0);
		comboBoxArea.setSelectedIndex(0);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {

		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				empty();
				setTestState(true);
				delete.setEnabled(false);
				update.setEnabled(false);
				inquire.setEnabled(false);
				whichButton = 1;
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				whichButton = 2;
				add.setEnabled(false);
				update.setEnabled(false);
				inquire.setEnabled(false);
				OK.setEnabled(true);
				cancel.setEnabled(true);
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				whichButton = 3;
				add.setEnabled(false);
				delete.setEnabled(false);
				inquire.setEnabled(false);
				currentLine = table.table.getSelectedRow();
				ArrayList<String> al = table.getValueAt(currentLine);
				textId.setText(al.get(0));
				textRow.setText(al.get(4));
				textStand.setText(al.get(5));
				textPosition.setText(al.get(6));
				switch (al.get(2)) {
				case "北京":
					comboBoxDestination.setSelectedIndex(0);
					break;
				case "上海":
					comboBoxDestination.setSelectedIndex(1);
					break;
				case "广州":
					comboBoxDestination.setSelectedIndex(2);
					break;
				case "南京":
					comboBoxDestination.setSelectedIndex(3);
					break;
				}

				switch (al.get(3)) {
				case "航运区":
					comboBoxArea.setSelectedIndex(0);
					break;
				case "铁运区":
					comboBoxArea.setSelectedIndex(1);
					break;
				case "汽运区":
					comboBoxArea.setSelectedIndex(2);
					break;
				case "机动区":
					comboBoxArea.setSelectedIndex(3);
					break;
				}
			}
		});
		inquire.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				whichButton = 4;
				add.setEnabled(false);
				delete.setEnabled(false);
				update.setEnabled(false);
				textId.setEditable(true);
				OK.setEnabled(true);
				cancel.setEnabled(true);
			}
		});

		OK.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				setTestState(false);
				buttonAllTrue();
				// 新建的确定
				if (whichButton == 1) {
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH:mm:ss");// 设置日期格式
					String time = df.format(new Date()).substring(8, 16);// new Date()为获取当前系统时间
					int showRow = table.numOfEmpty();
					int showColumn = 0;
					InboundOrderVO iovo = getInfo(time);
					StoreGenerateOrder storeGenerateOrder = new StoreGenerateOrder();
					int judge = storeGenerateOrder.generateInboundOrderPO(iovo);
					if (judge == 0) {
						// 新建失败，跳出提示
					} else {
						table.setValueAt(showRow, showColumn, iovo.getId());
						table.setValueAt(showRow, showColumn + 1, iovo.getInDate().substring(0, 8));
						switch (iovo.getDestination().name()) {
						case "Beijing":
							table.setValueAt(showRow, showColumn + 2, "北京");
							break;
						case "Shanghai":
							table.setValueAt(showRow, showColumn + 2, "上海");
							break;
						case "Guangzhou":
							table.setValueAt(showRow, showColumn + 2, "广州");
							break;
						case "Nanjing":
							table.setValueAt(showRow, showColumn + 2, "南京");
							break;
						}
						switch (iovo.getArea().name()) {
						case "Airline":
							table.setValueAt(showRow, showColumn + 3, "航运区");
							break;
						case "Trainline":
							table.setValueAt(showRow, showColumn + 3, "铁运区");
							break;
						case "Busline":
							table.setValueAt(showRow, showColumn + 3, "汽运区");
							break;
						case "Motoline":
							table.setValueAt(showRow, showColumn + 3, "机动区");
							break;
						}

						table.setValueAt(showRow, showColumn + 4, iovo.getRow() + "");
						table.setValueAt(showRow, showColumn + 5, iovo.getStand() + "");
						table.setValueAt(showRow, showColumn + 6, iovo.getPosition() + "");

						empty();
					}

				} // 删除的确定
				else if (whichButton == 2) {
					currentLine = table.table.getSelectedRow();
					String id = (String) table.table.getValueAt(currentLine, 0);
					StoreGenerateOrder storeGenerateOrder = new StoreGenerateOrder();
					int judge = storeGenerateOrder.deleteInboundOrderPO(id);
					if (judge == 0)
						// 删除失败 跳出提示
						System.out.println("删除数据库失败!");
					if (judge > 0) {
						// 右边表格删除这一行
						System.out.println("删除数据库成功！");
						empty();
						table.removeLine(currentLine);
						repaint();
					}

				} // 修改的确定
				else if (whichButton == 3) {
					currentLine = table.table.getSelectedRow();
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH:mm:ss");// 设置日期格式
					String time = df.format(new Date()).substring(8, 16);// new
																			// Date()为获取当前系统时间
					InboundOrderVO iovo = getInfo(time);
					StoreGenerateOrder storeGenerateOrder = new StoreGenerateOrder();
					int judge = storeGenerateOrder.updateInboundOrderPO(iovo);
					if (judge == 0) {
						// 修改失败，跳出提示
					} else {
						table.setValueAt(currentLine, 0, iovo.getId());
						table.setValueAt(currentLine, 1, iovo.getInDate().substring(0, 8));
						System.out.println(iovo.getDestination().name() + "这是啥");
						switch (iovo.getDestination().name()) {
						case "Beijing":
							table.setValueAt(currentLine, 2, "北京");
							break;
						case "Shanghai":
							table.setValueAt(currentLine, 2, "上海");
							break;
						case "Guangzhou":
							table.setValueAt(currentLine, 2, "广州");
							break;
						case "Nanjing":
							table.setValueAt(currentLine, 2, "南京");
							break;
						}
						switch (iovo.getArea().name()) {
						case "Airline":
							table.setValueAt(currentLine, 3, "航运区");
							break;
						case "Trainline":
							table.setValueAt(currentLine, 3, "铁运区");
							break;
						case "Busline":
							table.setValueAt(currentLine, 3, "汽运区");
							break;
						case "Motoline":
							table.setValueAt(currentLine, 3, "机动区");
							break;
						}
						table.setValueAt(currentLine, 4, iovo.getRow() + "");
						table.setValueAt(currentLine, 5, iovo.getStand() + "");
						table.setValueAt(currentLine, 6, iovo.getPosition() + "");

					}

				} // 查找的确定
				else {
					String id = textId.getText();
					StoreGenerateOrder sgo = new StoreGenerateOrder();
					InboundOrderVO iovo = sgo.inquireInboundOrderPO(id);
					textId.setText(id);
					// 日期
					iovo.getInDate();
					textRow.setText(iovo.getRow() + "");
					textStand.setText(iovo.getStand() + "");
					textPosition.setText(iovo.getPosition() + "");
					String des = iovo.getDestination().toString();
					String area = iovo.getArea().toString();
					switch (des) {
					case "Beijing":
						comboBoxDestination.setSelectedIndex(0);
						break;
					case "Shanghai":
						comboBoxDestination.setSelectedIndex(1);
						break;
					case "Guangzhou":
						comboBoxDestination.setSelectedIndex(2);
						break;
					case "Nanjing":
						comboBoxDestination.setSelectedIndex(3);
						break;
					}
					switch (area) {
					case "Airline":
						comboBoxArea.setSelectedIndex(0);
						break;
					case "Trainline":
						comboBoxArea.setSelectedIndex(1);
						break;
					case "Busline":
						comboBoxArea.setSelectedIndex(2);
						break;
					case "Motoline":
						comboBoxArea.setSelectedIndex(3);
						break;
					}
				}
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				empty();
				setTestState(false);
				add.setEnabled(true);
				delete.setEnabled(true);
				update.setEnabled(true);
				inquire.setEnabled(true);
			}
		});

		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi l = new LoginUi(mainFrame);
				mainFrame.setContentPane(l);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(50, 116, 270, 470, false); // 输入框外框
		this.repaint();
	}

	public InboundOrderVO getInfo(String time) {
		String id = textId.getText();
		String inDate = dc.getTime() + time;
		// getTime全是数字2015120714:33:33
		int row = Integer.parseInt(textRow.getText());
		int stand = Integer.parseInt(textStand.getText());
		int position = Integer.parseInt(textPosition.getText());
		Destination des = null;
		Area area = null;
		switch (comboBoxDestination.getSelectedItem().toString()) {
		case "北京":
			des = Destination.valueOf("Beijing");
			break;
		case "上海":
			des = Destination.valueOf("Shanghai");
			break;
		case "广州":
			des = Destination.valueOf("Guangzhou");
			break;
		case "南京":
			des = Destination.valueOf("Nanjing");
			break;

		}
		switch (comboBoxArea.getSelectedItem().toString()) {
		case "航运区":
			area = Area.valueOf("Airline");
			break;
		case "铁运区":
			area = Area.valueOf("Trainline");
			break;
		case "汽运区":
			area = Area.valueOf("Busline");
			break;
		case "机动区":
			area = Area.valueOf("Motoline");
			break;

		}
		InboundOrderVO inboundOrderVO = new InboundOrderVO(id, inDate, des, area, row, stand, position);
		return inboundOrderVO;
	}

}
