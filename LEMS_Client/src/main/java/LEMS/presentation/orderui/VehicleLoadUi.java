package LEMS.presentation.orderui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.VehicleLoad;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.storeui.DateChooser;
import LEMS.vo.ordervo.VehicleLoadVO;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 周梦佳
 * 车辆装车管理界面
 */
@SuppressWarnings("serial")
public class VehicleLoadUi extends JPanel {


	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=120;
	private static final int LOCATION_LABEL_Y=115;
	private static final int LOCATION_TEXT_X=220;
	private static final int LOCATION_TEXT_Y=210;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton finish;
	private JButton add;
	private JButton delete;
	private JButton update;
	private JButton inquire;
	
	private JLabel labelDate;
	private JLabel labelDestination;
	private JLabel labelTransferNum;
	private JLabel labelVehicleId;
	private JLabel labelGuard;
	private JLabel labelDeliverStaff;
	private JLabel labelGoodsNum;
	private JLabel labelGoodsGravity;
	private JLabel labelBarcode;

	private JTextField textTransferNum;
	private JTextField textVehicleId;
	private JTextField textGuard;
	private JTextField textDeliverStaff;
	private JTextField textGoodsNum;
	private JTextField textGoodsGravity;
	private JTextField textID;
	

	private JComboBox<String> comboBox;//destination
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	private VehicleLoad vehicleLoad;
	
	private VehicleLoadVO vehicleLoadVO;
	
	public VehicleLoadUi(final MainFrame mainFrame) {
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

		vehicleLoadVO = new VehicleLoadVO();
		//TODO 获得UserVO
		vehicleLoad = new VehicleLoad(null, vehicleLoadVO);
	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("装车管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		finish=new JButton("完成");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		inquire=new JButton("查找");
		
		labelDate = new JLabel("装车日期:");
		labelDestination = new JLabel("目的地:");
		labelBarcode = new JLabel("订单条形码号:");
		labelTransferNum = new JLabel("汽运编号:");
		labelVehicleId = new JLabel("车辆代号：");
		labelDeliverStaff = new JLabel("押运员:");
		labelGuard = new JLabel("监装员:");
		labelGoodsNum = new JLabel("货物总数:");
		labelGoodsGravity= new JLabel("货物总质量：");
		
		textTransferNum = new JTextField();
		textVehicleId = new JTextField();
		textDeliverStaff = new JTextField();
		textGuard = new JTextField();
		textGoodsNum = new JTextField();
		textID = new JTextField();
		textGoodsGravity=new JTextField();
		comboBox = new JComboBox<String>();
		
		DateChooser dc=new DateChooser(this, LOCATION_TEXT_X+2, LOCATION_TEXT_Y-90);
		
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 27, 230, 39);
		
		
		labelDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelDestination.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+45, BOUND_X, BOUND_Y);
		labelTransferNum.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+90, BOUND_X, BOUND_Y);
		labelVehicleId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+135, BOUND_X, BOUND_Y);
		labelGuard.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+180, BOUND_X, BOUND_Y);
		labelDeliverStaff.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+225, BOUND_X, BOUND_Y);
		labelGoodsNum.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+285, BOUND_X, BOUND_Y);
		labelGoodsGravity.setBounds(LOCATION_LABEL_X-7, LOCATION_LABEL_Y+330, BOUND_X+40, BOUND_Y);
		labelBarcode.setBounds(LOCATION_LABEL_X-15, LOCATION_LABEL_Y+400, BOUND_X, BOUND_Y);
		
		textTransferNum.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textVehicleId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+45, BOUND_X, BOUND_Y-6);
		textGuard.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+90, BOUND_X, BOUND_Y-6);
		textDeliverStaff.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+135, BOUND_X, BOUND_Y-6);
		textGoodsNum.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+195, BOUND_X, BOUND_Y-6);
		textGoodsGravity.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+240, BOUND_X, BOUND_Y-6);
		textID.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+310, BOUND_X, BOUND_Y-6);
		
		comboBox.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y-45, BOUND_X, BOUND_Y-5);
		comboBox.addItem("北京");
		comboBox.addItem("上海");
		comboBox.addItem("广州");
		comboBox.addItem("南京");
		
		
		OK.setBounds(LOCATION_LABEL_X+302, LOCATION_LABEL_Y+407, BOUND_X-30, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+425, LOCATION_LABEL_Y+407, BOUND_X-30, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);
		finish.setBounds(LOCATION_LABEL_X+548,LOCATION_LABEL_Y+407,100,40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120,40);
		update.setBounds(550, 590, 120, 40);
		inquire.setBounds(750, 590, 120, 40);
		
		title.setFont(fnt1);
		labelBarcode.setFont(fnt);
		labelDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelTransferNum.setFont(fnt);
		labelVehicleId.setFont(fnt);
		labelDeliverStaff.setFont(fnt);
		labelGuard.setFont(fnt);
		labelGoodsNum.setFont(fnt);
		labelGoodsGravity.setFont(fnt);
		textTransferNum.setFont(fnt);
		textVehicleId.setFont(fnt);
		textGuard.setFont(fnt);
		textDeliverStaff.setFont(fnt);
		textGoodsNum.setFont(fnt);
		textGoodsGravity.setFont(fnt);
		textID.setFont(fnt);
		comboBox.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		finish.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		inquire.setFont(fnt2);
		
		this.add(title);
		this.add(labelBarcode);
		this.add(labelDate);
		this.add(labelDestination);
		this.add(labelTransferNum);
		this.add(labelVehicleId);
		this.add(labelDeliverStaff);
		this.add(labelGuard);
		this.add(labelGoodsNum);
		this.add(labelGoodsGravity);
		this.add(textTransferNum);
		this.add(textVehicleId);
		this.add(textGuard);
		this.add(textDeliverStaff);
		this.add(textGoodsNum);
		this.add(textID);
		this.add(textGoodsGravity);
		this.add(comboBox);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(finish);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(inquire);
		String[] columnNames = {"序号","订单ID","名称","重量" };  
		int[] list={40,120,14,30,20,425,110,498,390};

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

		textTransferNum.setEditable(state);
		textVehicleId.setEditable(state);
		textDeliverStaff.setEditable(state);
		textGuard.setEditable(state);
		textGoodsNum.setEnabled(state);
		textID.setEnabled(state);
		textGoodsGravity.setEnabled(state);
		comboBox.setEnabled(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
		//日期
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textTransferNum.setText(null);
		textVehicleId.setText(null);
		textDeliverStaff.setText(null);
		textGuard.setText(null);
		textGoodsNum.setText(null);
		textID.setText(null);
		textGoodsGravity.setText(null);
		comboBox.setSelectedIndex(0);
		//日期
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				// TODO 返回按钮的具体实现
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 返回按钮的具体实现
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 返回按钮的具体实现
			}
		});
		inquire.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				// TODO 返回按钮的具体实现
			}
		});
		
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi loginUi=new LoginUi(mainFrame);
				mainFrame.setContentPane(loginUi);
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
		finish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 完成按钮的具体实现
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(80, 110, 290, 270, false);  //输入框外框
		g.draw3DRect(80, 393, 290, 100, false);  //输入框外框
		g.draw3DRect(80, 505, 290, 55, false);  //输入框外框
		this.repaint();
	}
	
	private void OKOperation() {
		this.empty();
		//TODO 目的地应该是具体营业厅
		vehicleLoad.addOrder(textID.getText());
	}
}
