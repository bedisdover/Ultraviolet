package LEMS.presentation.storeui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LEMS.businesslogic.storebl.StoreGenerateOrder;
import LEMS.po.orderpo.TransportType;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.vo.storevo.InboundOrderVO;
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
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton add;
	private JButton delete;
	private JButton update;
	private JButton inquire;
	private JLabel labelId;
	private JLabel labelOutDate;
	private JLabel labelDestination;
	private JLabel labelTransportType;
	private JLabel labelTransferNum1;
	private JLabel labelTransferNum2;
	private JTextField textId;
	private JTextField textTransferNum;
	private JTextField textTime;
	
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
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		inquire=new JButton("查找");
		labelId = new JLabel("快递单号:");
		labelOutDate = new JLabel("出库日期:");
		labelDestination = new JLabel("目的地:");
		labelTransportType = new JLabel("装运形式:");
		labelTransferNum1 = new JLabel("中转单编号");
		labelTransferNum2 = new JLabel("或汽运编号:");
		textId = new JTextField();
		textTransferNum = new JTextField();
		textTime = new JTextField();
		dc=new DateChooser(this,LOCATION_TEXT_X,LOCATION_TEXT_Y+58);
		comboBoxDestination = new JComboBox<String>();
		comboBoxTransportType = new JComboBox<String>();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 37, 230, 39);
		
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelOutDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+70, BOUND_X, BOUND_Y);
		labelDestination.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+155, BOUND_X, BOUND_Y);
		labelTransportType.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+215, BOUND_X, BOUND_Y);
		labelTransferNum1.setBounds(LOCATION_LABEL_X-4, LOCATION_LABEL_Y+275, BOUND_X+30, BOUND_Y);
		labelTransferNum2.setBounds(LOCATION_LABEL_X-4, LOCATION_LABEL_Y+295, BOUND_X+30, BOUND_Y);
		
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textTransferNum.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+282, BOUND_X, BOUND_Y-6);
		textTime.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+87, BOUND_X, BOUND_Y-6);
		
		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelOutDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelTransportType.setFont(fnt);
		labelTransferNum1.setFont(fnt);
		labelTransferNum2.setFont(fnt);
		textId.setFont(fnt);
		textTransferNum.setFont(fnt);
		textTime.setFont(fnt);
		comboBoxDestination.setFont(fnt);
		comboBoxTransportType.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		inquire.setFont(fnt2);
		
		comboBoxDestination.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+155, BOUND_X, BOUND_Y-5);
		comboBoxDestination.addItem("北京");
		comboBoxDestination.addItem("上海");
		comboBoxDestination.addItem("广州");
		comboBoxDestination.addItem("南京");
		
		comboBoxTransportType.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+215, BOUND_X, BOUND_Y-5);
		comboBoxTransportType.addItem("飞机");
		comboBoxTransportType.addItem("火车");
		comboBoxTransportType.addItem("汽车");
		
		OK.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+360, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_TEXT_X+40, LOCATION_LABEL_Y+360, BOUND_X-40, BOUND_Y+10);
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
		this.add(textTime);
		
	String[] columnNames = { "快递单号", "出库日期", "目的地", "装运形式", "中转单/汽运编号" };  
	int[] list={40,120,14,30,20,340,125,618,450};

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
		textTransferNum.setEditable(state);
		textTime.setEditable(state);
		//日期
		comboBoxDestination.setEnabled(state);
		comboBoxTransportType.setEnabled(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
//日期
		textTransferNum.setText(null);
		textTime.setText(null);
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
				textTime.setText(al.get(1).substring(8, 16));
				textTransferNum.setText(al.get(4));
				switch(al.get(2)){
				case "Beijing":
					comboBoxDestination.setSelectedIndex(0);
				case "Shanghai":
					comboBoxDestination.setSelectedIndex(1);
				case "Guangzhou":
					comboBoxDestination.setSelectedIndex(2);
				case "Nanjing":
					comboBoxDestination.setSelectedIndex(3);
				}
			
				switch(al.get(3)){
				case "Airplane":
					comboBoxDestination.setSelectedIndex(0);
				case "Railway":
					comboBoxDestination.setSelectedIndex(1);
				case "Landway":
					comboBoxDestination.setSelectedIndex(2);
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
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH:mm:ss");//设置日期格式
					String time=df.format(new Date()).substring(8, 16);// new Date()为获取当前系统时间
					textTime.setText(time);
					int showRow = 0;
					int showColumn = 0;
					OutboundOrderVO oovo =getInfo();
					StoreGenerateOrder storeGenerateOrder = new StoreGenerateOrder();
					int judge = storeGenerateOrder.generateOutboundOrderPO(oovo);
					if (judge == 0) {
						// 新建失败，跳出提示
					} else {
						Table table = new Table();
						table.setValueAt(showRow, showColumn, oovo.getId());
						table.setValueAt(showRow, showColumn + 1, oovo.getOutDate());
						table.setValueAt(showRow, showColumn + 2, oovo.getDestination().name());
						table.setValueAt(showRow, showColumn + 3, oovo.getTransportType().name());
						table.setValueAt(showRow, showColumn + 4, oovo.getTransferNum());
						showRow++;

					}
				
				}
				else if(whichButton==2){

					currentLine = table.table.getSelectedRow();
					//告诉逻辑层通知数据库修改
					String id=(String) table.table.getValueAt(currentLine, 0);
					
					StoreGenerateOrder storeGenerateOrder=new StoreGenerateOrder();
					int judge=storeGenerateOrder.deleteOutboundOrderPO(id);
					if(judge==0)
						//删除失败 跳出提示
					if(judge>0){
							//右边表格删除这一行
						table.table.remove(currentLine);
						repaint();
					}
				
					
				
				}
				else if(whichButton==3){

					currentLine = table.table.getSelectedRow();
					OutboundOrderVO oovo=getInfo();
					StoreGenerateOrder storeGenerateOrder = new StoreGenerateOrder();
					int judge = storeGenerateOrder.updateOutboundOrderPO(oovo);
					if (judge == 0) {
						// 修改失败，跳出提示
					} else {
						Table table = new Table();
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
					//日期
					oovo.getOutDate();
					textTime.setText(oovo.getOutDate().substring(8, 16));
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

	public OutboundOrderVO getInfo(){
		String id = textId.getText();
		String outDate = dc.getTime()+textTime.getText().substring(0, 2)+textTime.getText().substring(3, 5)+textTime.getText().substring(6, 8);;
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
