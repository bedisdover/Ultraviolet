package LEMS.presentation.orderui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.Transfer;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.vo.ordervo.TransferVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳 中转接收界面
 */
public class TransferUi2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X = 80;
	private static final int LOCATION_LABEL_Y = 140;
	private static final int LOCATION_TEXT_X = 178;
	private static final int LOCATION_TEXT_Y = 145;
	private static final int BOUND_X = 130;
	private static final int BOUND_Y = 30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton add;
	private JButton delete;
	private JButton update;
	private JButton finish;

	private JLabel labelDate;
	private JLabel labelDestination;
	private JLabel labelGuard;
	private JLabel labelAllId;
	private JLabel labelFormat;

	private JTextField textDestination;
	private JTextField textId;
	private JTextField textGuard;

	private JComboBox<String> comboBoxFormat;

	private DateChooser dc;

	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式

	private Transfer transfer;

	private TransferVO transferVO;

	private InnerPanelAir innerPanelAir;
	private InnerPanelTrain innerPanelTrain;
	private InnerPanelBus innerPanelBus;
	
	private Table table;
	
	public TransferUi2(final MainFrame mainFrame, UserVO user) {
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

		transferVO = new TransferVO();
		transfer = new Transfer(user, transferVO);
	}

	/**
	 * 初始化
	 */
	private void init() {
		//TODO 改标签名
		title = new JLabel("中  转");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add = new JButton("新增");
		delete = new JButton("删除");
		update = new JButton("修改");
		finish = new JButton("查找");
		labelDate = new JLabel("中转日期:");
		labelDestination = new JLabel("到达地:");
		labelGuard = new JLabel("监装员:");
		labelAllId = new JLabel("订单编号:");
		labelFormat = new JLabel("装运形式：");
		textId = new JTextField();
		textGuard = new JTextField();
		textDestination = new JTextField();
		comboBoxFormat = new JComboBox<String>();

		dc = new DateChooser(this, LOCATION_TEXT_X, LOCATION_TEXT_Y);
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {
		innerPanelAir=new InnerPanelAir();
		innerPanelTrain=new InnerPanelTrain();
		innerPanelBus=new InnerPanelBus();
		innerPanelAir.setVisible(true);

		title.setBounds(420, 27, 230, 39);
		labelDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelDestination.setBounds(LOCATION_LABEL_X + 7, LOCATION_LABEL_Y + 50, BOUND_X, BOUND_Y);
		labelAllId.setBounds(LOCATION_LABEL_X - 15, LOCATION_LABEL_Y + 100, BOUND_X, BOUND_Y);
		labelGuard.setBounds(LOCATION_LABEL_X + 7, LOCATION_LABEL_Y + 150, BOUND_X, BOUND_Y);
		labelFormat.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 200, BOUND_X, BOUND_Y);

		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 100, BOUND_X, BOUND_Y - 5);
		textGuard.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 150, BOUND_X, BOUND_Y - 5);
		textDestination.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 50, BOUND_X, BOUND_Y - 6);

		comboBoxFormat.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 200, BOUND_X, BOUND_Y - 5);
		comboBoxFormat.addItem("飞机");
		comboBoxFormat.addItem("火车");
		comboBoxFormat.addItem("汽车");
		
		ItemListener itemListener = new ItemListener() {  
            @Override  
            public void itemStateChanged(ItemEvent e) {
    	        //在JComboBox的监听事件时总是执行两次,原因如下:
    	        //ItemListener类中的方法itemStateChanged()事件的itemState有关，itemState在这里的状态有两个，Selected 和 deSelected（即选中和未被选中）
    	        //所以，当改变下拉列表中被选中的项的时候，其实是触发了两次事件：
    	        //第一次是上次被选中的项的 State 由 Selected 变为 deSelected ，即取消选择
    	        //第二次是本次被选中的项的 State 由 deSelected 变为 Selected ，即新选中，所以，必然的 ItemStateChanged 事件中的代码要被执行两次了。
    	        //加上最外面的if语句，就可以解决这个问题。
    	        if(e.getStateChange() == ItemEvent.SELECTED) {
    	            if(e.getSource() == comboBoxFormat) {
    	                int index = comboBoxFormat.getSelectedIndex();
    	                if(index==0){
    	                	setPanelAir();
    	                } else if(index==1){
    	                	setPanelTrain();
    	                } else if(index==2){
    	                	setPanelBus();
    	                }
    	            } 
    	        }
            }  
        };  
        comboBoxFormat.addItemListener(itemListener); 
		
		OK.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 355, BOUND_X - 40, BOUND_Y + 10);
		cancel.setBounds(LOCATION_LABEL_X + 135, LOCATION_LABEL_Y + 355, BOUND_X - 40, BOUND_Y + 10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120, 40);
		update.setBounds(550, 590, 120, 40);
		finish.setBounds(750, 590, 120, 40);

		title.setFont(fnt1);
		labelDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelGuard.setFont(fnt);
		labelAllId.setFont(fnt);
		labelFormat.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		finish.setFont(fnt2);
		textGuard.setFont(fnt);
		textId.setFont(fnt);
		textDestination.setFont(fnt);
		comboBoxFormat.setFont(fnt);

		this.add(title);
		this.add(labelDate);
		this.add(labelDestination);
		this.add(labelGuard);
		this.add(labelAllId);
		this.add(labelFormat);
		this.add(textGuard);
		this.add(textId);
		this.add(textDestination);
		this.add(comboBoxFormat);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(finish);
		this.add(innerPanelAir);
		this.add(innerPanelTrain);
		this.add(innerPanelBus);
		String[] columnNames = {"序号", "到达日期", "中转单编号", "出发地", "货物到达状态" };
		int[] list = { 40, 116, 14, 30, 20, 355, 125, 598, 435 };

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
		textDestination.setEditable(state);
		textGuard.setEditable(state);
		textId.setEditable(state);
		innerPanelAir.textAirlineNum.setEditable(state);
		innerPanelAir.textDeskNum.setEditable(state);
		innerPanelTrain.textCarNum.setEditable(state);
		innerPanelTrain.textVehicleNum.setEditable(state);
		innerPanelBus.textDeliverStaff.setEditable(state);
		innerPanelBus.textVehicleNum.setEditable(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}
	
	private void setPanelAir(){
		innerPanelAir.setVisible(true);
		innerPanelTrain.setVisible(false);
		innerPanelBus.setVisible(false);
	}
	private void setPanelTrain(){
		innerPanelAir.setVisible(false);
		innerPanelTrain.setVisible(true);
		innerPanelBus.setVisible(false);
	}
	private void setPanelBus(){
		innerPanelAir.setVisible(false);
		innerPanelTrain.setVisible(false);
		innerPanelBus.setVisible(true);
	}
	/**
	 * 清空输入框
	 */
	private void empty() {
		textDestination.setText(null);
		textGuard.setText(null);
		textId.setText(null);
		innerPanelAir.textAirlineNum.setText(null);
		innerPanelAir.textDeskNum.setText(null);
		innerPanelTrain.textCarNum.setText(null);
		innerPanelTrain.textVehicleNum.setText(null);
		innerPanelBus.textDeliverStaff.setText(null);
		innerPanelBus.textVehicleNum.setText(null);
		comboBoxFormat.setSelectedIndex(0);
	}


	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				table.removeLine(table.getSelectedRow());
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				updateOperation();
			}
		});
		finish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finishOperation();
			}
		});

		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				OKOperation();
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				empty();
				setTestState(false);
			}
		});
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi l = new LoginUi(mainFrame);
				mainFrame.setContentPane(l);
			}
		});
	}

	private void OKOperation() {
		transfer.addOrder(textId.getText());
		textId.setText(null);
	}
	
	private void finishOperation() {
		transferVO.setDate(dc.getTime());
		transferVO.setDestination(textDestination.getText());
		transferVO.setSuperVision(textGuard.getText());
		//TODO 改变、适应
//		transferVO.setFlight();
		this.empty();
		this.setTestState(false);
	}
	
	private void updateOperation() {
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(50, 125, 280, 435, false); // 输入框外框
		this.repaint();
	}
	
	class InnerPanelAir extends JPanel {
		private static final long serialVersionUID = 1L;
		private JLabel labelAirlineNum;
		private JLabel labelDeskNum;
		private JTextField textAirlineNum;
		private JTextField textDeskNum;

		private InnerPanelAir() {
			this.setBounds(55, 390, 270, 100);
			this.setLayout(null);

			labelAirlineNum = new JLabel("航班号：");
			labelDeskNum = new JLabel("货柜号：");
			textAirlineNum = new JTextField();
			textDeskNum = new JTextField();
			labelAirlineNum.setBounds(30, 3, BOUND_X, BOUND_Y);
			labelDeskNum.setBounds(30, 55, BOUND_X, BOUND_Y);
			textAirlineNum.setBounds(125, 8, BOUND_X, BOUND_Y-5);
			textDeskNum.setBounds(125, 63, BOUND_X, BOUND_Y-5);
			labelAirlineNum.setFont(fnt);
			labelDeskNum.setFont(fnt);
			textAirlineNum.setFont(fnt);
			textDeskNum.setFont(fnt);
			
			this.add(labelAirlineNum);
			this.add(labelDeskNum);
			this.add(textAirlineNum);
			this.add(textDeskNum);
		}

		public void paintComponent(Graphics g) {
			Image backGround=Toolkit.getDefaultToolkit().getImage("background1.png");
			g.drawImage(backGround, 0, 0, this.getWidth(), this.getHeight(), null);
			this.repaint();
		}
	}
	
	class InnerPanelTrain extends JPanel {
		private static final long serialVersionUID = 1L;
		private JLabel labelVehicleNum;
		private JLabel labelCarNum;
		private JTextField textVehicleNum;
		private JTextField textCarNum;
		
		private InnerPanelTrain() {
			this.setBounds(55, 390, 270, 100);
			this.setLayout(null);

			labelVehicleNum = new JLabel("车次号：");
			labelCarNum = new JLabel("车厢号：");
			textVehicleNum = new JTextField();
			textCarNum = new JTextField();
			labelVehicleNum.setBounds(30, 3, BOUND_X, BOUND_Y);
			labelCarNum.setBounds(30, 55, BOUND_X, BOUND_Y);
			textVehicleNum.setBounds(125, 8, BOUND_X, BOUND_Y-5);
			textCarNum.setBounds(125, 63, BOUND_X, BOUND_Y-5);
			labelVehicleNum.setFont(fnt);
			labelCarNum.setFont(fnt);
			textVehicleNum.setFont(fnt);
			textCarNum.setFont(fnt);
			
			this.add(labelVehicleNum);
			this.add(labelCarNum);
			this.add(textCarNum);
			this.add(textVehicleNum);
		}
		
		public void paintComponent(Graphics g) {
			Image backGround=Toolkit.getDefaultToolkit().getImage("background1.png");
			g.drawImage(backGround, 0, 0, this.getWidth(), this.getHeight(), null);
			this.repaint();
		}
	}
	
	class InnerPanelBus extends JPanel {
		private static final long serialVersionUID = 1L;
		private JLabel labelVehicleNum;
		private JLabel labelDeliverStaff;
		private JTextField textVehicleNum;
		private JTextField textDeliverStaff;

		private InnerPanelBus() {
			this.setBounds(55, 390, 270, 100);
			this.setLayout(null);

			labelVehicleNum = new JLabel("车次号：");
			labelDeliverStaff = new JLabel("押运员：");
			textVehicleNum = new JTextField();
			textDeliverStaff = new JTextField();
			labelVehicleNum.setBounds(30, 3, BOUND_X, BOUND_Y);
			labelDeliverStaff.setBounds(30, 55, BOUND_X, BOUND_Y);
			textVehicleNum.setBounds(125, 8, BOUND_X, BOUND_Y-5);
			textDeliverStaff.setBounds(125, 63, BOUND_X, BOUND_Y-5);
			labelVehicleNum.setFont(fnt);
			labelDeliverStaff.setFont(fnt);
			textVehicleNum.setFont(fnt);
			textDeliverStaff.setFont(fnt);
			
			this.add(labelDeliverStaff);
			this.add(labelVehicleNum);
			this.add(textDeliverStaff);
			this.add(textVehicleNum);
		}
		
		public void paintComponent(Graphics g) {
			Image backGround=Toolkit.getDefaultToolkit().getImage("background1.png");
			g.drawImage(backGround, 0, 0, this.getWidth(), this.getHeight(), null);
			this.repaint();
		}
	}
}
