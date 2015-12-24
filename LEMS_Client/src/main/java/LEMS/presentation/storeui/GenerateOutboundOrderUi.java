package LEMS.presentation.storeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.storebl.StoreGenerateOrder;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.TransportType;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.vo.storevo.OutboundOrderVO;

/**
 * 
 * @author 周梦佳
 *生成出库单界面
 */
public class GenerateOutboundOrderUi extends JPanel{


	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=70;
	private static final int LOCATION_LABEL_Y=140;
	private static final int LOCATION_TEXT_X=155;
	private static final int LOCATION_TEXT_Y=145;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

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
	private JLabel labelOutDate;
	private JLabel labelDestination;
	private JLabel labelTransportType;
	private JLabel labelTransferNum1;
	private JLabel labelTransferNum2;
	private JTextField textId;
	private JTextField textTransferNum;
	
	DateChooser dc;
	
	private JComboBox<String> comboBoxDestination;//destination
	private JComboBox<String> comboBoxTransportType;//transportType
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	/**
	 * 判断是干什么的确定 1是新建 2是删除 3是修改 4是查找
	 */
	int whichButton = 0;
	Table table;
	/**
	 * 选中的行
	 */
	int currentLine=-1;
	
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
		exit = new UltraButton("返回");
		OK = new UltraButton("确定");
		cancel = new UltraButton("取消");
		add=new UltraButton("新增");
		delete=new UltraButton("删除");
		update=new UltraButton("修改");
		inquire=new UltraButton("查找");
		labelId = new JLabel("快递单号:");
		labelOutDate = new JLabel("出库日期:");
		labelDestination = new JLabel("目的地:");
		labelTransportType = new JLabel("装运形式:");
		labelTransferNum1 = new JLabel("中转单编号");
		labelTransferNum2 = new JLabel("或汽运编号:");
		textId = new JTextField();
		textTransferNum = new JTextField();
		dc=new DateChooser(this,LOCATION_TEXT_X,LOCATION_TEXT_Y+68);
		comboBoxDestination = new JComboBox<String>();
		comboBoxTransportType = new JComboBox<String>();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 37, 230, 39);
		
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelOutDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+68, BOUND_X, BOUND_Y);
		labelDestination.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+136, BOUND_X, BOUND_Y);
		labelTransportType.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+204, BOUND_X, BOUND_Y);
		labelTransferNum1.setBounds(LOCATION_LABEL_X-4, LOCATION_LABEL_Y+272, BOUND_X+30, BOUND_Y);
		labelTransferNum2.setBounds(LOCATION_LABEL_X-4, LOCATION_LABEL_Y+292, BOUND_X+30, BOUND_Y);
		
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textTransferNum.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+282, BOUND_X, BOUND_Y-6);
		
		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelOutDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelTransportType.setFont(fnt);
		labelTransferNum1.setFont(fnt);
		labelTransferNum2.setFont(fnt);
		textId.setFont(fnt);
		textTransferNum.setFont(fnt);
		comboBoxDestination.setFont(fnt);
		comboBoxTransportType.setFont(fnt);

		
		comboBoxDestination.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+136, BOUND_X, BOUND_Y-5);
		comboBoxDestination.addItem("北京");
		comboBoxDestination.addItem("上海");
		comboBoxDestination.addItem("广州");
		comboBoxDestination.addItem("南京");
		
		comboBoxTransportType.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+204, BOUND_X, BOUND_Y-5);
		comboBoxTransportType.addItem("飞机");
		comboBoxTransportType.addItem("火车");
		comboBoxTransportType.addItem("汽车");
		
		OK.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+360, BOUND_X-10, BOUND_Y+10);
		cancel.setBounds(LOCATION_TEXT_X+40, LOCATION_LABEL_Y+360, BOUND_X-10, BOUND_Y+10);
		exit.setBounds(90, 60, 100, 40);
		add.setBounds(150, 600, 120, 40);
		delete.setBounds(350, 600, 120,40);
		update.setBounds(550, 600, 120, 40);
		inquire.setBounds(750, 600, 120, 40);
		
		this.add(title);
		this.add(labelId);
		this.add(textId);
		this.add(labelOutDate);
		this.add(labelDestination);
		this.add(labelTransportType);
		this.add(labelTransferNum1);
		this.add(labelTransferNum2);
		this.add(textTransferNum);
	
		this.add(comboBoxDestination);
		this.add(comboBoxTransportType);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(inquire);
		
	String[] columnNames = { "快递单号", "出库日期", "目的地", "装运形式", "中转单/汽运编号" };  
	int[] list={40,120,14,30,20,340,125,618,450};

		 table=new Table();
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
		textTransferNum.setEditable(state);
		//日期
		comboBoxDestination.setEnabled(state);
		comboBoxTransportType.setEnabled(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}
	private void buttonAllTrue(){
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
//日期
		textTransferNum.setText(null);
		comboBoxDestination.setSelectedIndex(0);
		comboBoxTransportType.setSelectedIndex(0);
		
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
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
				// TODO 返回按钮的具体实现
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				whichButton = 3;
				setTestState(true);
				add.setEnabled(false);
				delete.setEnabled(false);
				inquire.setEnabled(false);
				
				
				currentLine = table.table.getSelectedRow();
				ArrayList<String> al=table.getValueAt(currentLine);
				textId.setText(al.get(0));
				//日期
				
				textTransferNum.setText(al.get(4));
				switch(al.get(2)){
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
			
				switch(al.get(3)){
				case "Airplane":
					comboBoxDestination.setSelectedIndex(0);
					break;
				case "Railway":
					comboBoxDestination.setSelectedIndex(1);
					break;
				case "Landway":
					comboBoxDestination.setSelectedIndex(2);
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
				if(whichButton==1){
					/**
					 * 搞定
					 */
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH:mm:ss");//设置日期格式
					String time=df.format(new Date()).substring(8, 16);// new Date()为获取当前系统时间
					int showRow = 0;
					int showColumn = 0;
					OutboundOrderVO oovo =getInfo(time);
					StoreGenerateOrder storeGenerateOrder = new StoreGenerateOrder();
					int judge = storeGenerateOrder.generateOutboundOrderPO(oovo);
					if (judge == 0) {
						// 新建失败，跳出提示
					} else {
				
						table.setValueAt(showRow, showColumn, oovo.getId());
						table.setValueAt(showRow, showColumn + 1, oovo.getOutDate());
						switch(oovo.getDestination().name()){
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
						switch(oovo.getTransportType().name()){
						case "Airplane":
							table.setValueAt(showRow, showColumn + 3, "飞机");
							break;
						case "Railway":
							table.setValueAt(showRow, showColumn + 3, "火车");
							break;
						case "Landway":
							table.setValueAt(showRow, showColumn + 3, "汽车");
							break;
						}
						table.setValueAt(showRow, showColumn + 4, oovo.getTransferNum());
						showRow++;
						buttonAllTrue();
						empty();
						setTestState(false);
					}
				
				}
				else if(whichButton==2){
						/**
						 * 搞定
						 */
					currentLine = table.table.getSelectedRow();
					//告诉逻辑层通知数据库修改
					String id=(String) table.table.getValueAt(currentLine, 0);
					StoreGenerateOrder storeGenerateOrder=new StoreGenerateOrder();
					int judge=storeGenerateOrder.deleteOutboundOrderPO(id);
					System.out.println(judge+"judge错了吗");
					if(judge==0)
						//删除失败 跳出提示
						System.out.println("删除出库单失败！");
					if(judge<0){
						System.out.println("删除出库单成功！");
							//右边表格删除这一行
						table.removeLine(currentLine);
						repaint();
					}
				
					
				
				}
				else if(whichButton==3){

					currentLine = table.table.getSelectedRow();
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH:mm:ss");//设置日期格式
					String time=df.format(new Date()).substring(8, 16);// new Date()为获取当前系统时间
					OutboundOrderVO oovo=getInfo(time);
					StoreGenerateOrder storeGenerateOrder = new StoreGenerateOrder();
					int judge = storeGenerateOrder.updateOutboundOrderPO(oovo);
					if (judge == 0) {
						// 修改失败，跳出提示
					} else {
						table.setValueAt(currentLine, 0, oovo.getId());
						table.setValueAt(currentLine, 1, oovo.getOutDate());
						table.setValueAt(currentLine, 2,oovo.getDestination().name());
						table.setValueAt(currentLine, 3, oovo.getTransportType().name());
						table.setValueAt(currentLine, 4, oovo.getTransferNum());

					}
					
				
				}
				else{
					String id = textId.getText();
					StoreGenerateOrder sgo = new StoreGenerateOrder();
					OutboundOrderVO oovo = sgo.inquireOutboundOrderPO(id);
					textId.setText(id);
					dc.setTimePartTwo(oovo.getOutDate().substring(0, 8));
					oovo.getOutDate();
					textTransferNum.setText(oovo.getTransferNum());
					String des = oovo.getDestination().toString();
					String transportType = oovo.getTransportType().toString();
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
					switch (transportType) {
					case "Airplane":
						comboBoxTransportType.setSelectedIndex(0);
						break;
					case "Railway":
						comboBoxTransportType.setSelectedIndex(1);
						break;
					case "Landway":
						comboBoxTransportType.setSelectedIndex(2);
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
			LoginUi l=new LoginUi(mainFrame);
			mainFrame.setContentPane(l);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(50, 125, 260, 450, false);  //输入框外框
		this.repaint();
	}

	public OutboundOrderVO getInfo(String time){
		String id = textId.getText();
		String outDate = dc.getTime()+time;
		String transferNum=textTransferNum.getText();
		Destination des = null;
		TransportType transportType = null;
		switch (comboBoxDestination.getSelectedItem().toString()) {
		case "北京":
			des = Destination.valueOf("Beijing");
		case "上海":
			des = Destination.valueOf("Shanghai");
		case "广州":
			des = Destination.valueOf("Guangzhou");
		case "南京":
			des = Destination.valueOf("Nanjing");
		}
		switch (comboBoxTransportType.getSelectedItem().toString()) {
		case "飞机":
			transportType = TransportType.valueOf("Airplane");
		case "火车":
			transportType = TransportType.valueOf("Railway");
		case "汽车":
			transportType = TransportType.valueOf("Landway");
		}
		
		OutboundOrderVO oovo=new OutboundOrderVO(id,outDate,des,transportType,transferNum);
	return oovo;
	}



}
