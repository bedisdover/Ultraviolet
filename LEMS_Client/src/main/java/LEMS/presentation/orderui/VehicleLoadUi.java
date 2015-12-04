package LEMS.presentation.orderui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.storeui.DateChooser;

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
	private static final int LOCATION_LABEL_X=65;
	private static final int LOCATION_LABEL_Y=105;
	private static final int LOCATION_TEXT_X=155;
	private static final int LOCATION_TEXT_Y=200;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	
	private JLabel labelDate;
	private JLabel labelDestination;
	private JLabel labelInstitutionId;
	private JLabel labelTransferNum;
	private JLabel labelVehicleId;
	private JLabel labelGuard;
	private JLabel labelDeliverStaff;
	private JLabel labelVehicleInfo;
	private JLabel labelBarcode;
	private JLabel labelMoney;
	

	private JTextField textInstitutionId;
	private JTextField textTransferNum;
	private JTextField textVehicleId;
	private JTextField textGuard;
	private JTextField textDeliverStaff;
	private JTextField textVehicleInfo;
	private JTextField textBarcode;
	private JTextField textMoney;
	

	private JComboBox<String> comboBox;//destination
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
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

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("装车管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		
		
		
		labelDate = new JLabel("装车日期:");
		labelDestination = new JLabel("目的地:");
		labelInstitutionId = new JLabel("营业厅编号:");
		labelTransferNum = new JLabel("汽运编号:");
		labelVehicleId = new JLabel("车辆代号：");
		labelDeliverStaff = new JLabel("押运员:");
		labelGuard = new JLabel("监装员:");
		labelVehicleInfo = new JLabel("车辆信息:");
		labelMoney = new JLabel("运费:");
		labelBarcode= new JLabel("订单条形码号：");
		
		textInstitutionId = new JTextField();
		textTransferNum = new JTextField();
		textVehicleId = new JTextField();
		textDeliverStaff = new JTextField();
		textGuard = new JTextField();
		textVehicleInfo = new JTextField();
		textMoney = new JTextField();
		textBarcode=new JTextField();
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
		labelInstitutionId.setBounds(LOCATION_LABEL_X-7, LOCATION_LABEL_Y+90, BOUND_X, BOUND_Y);
		labelTransferNum.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+135, BOUND_X, BOUND_Y);
		labelBarcode.setBounds(LOCATION_LABEL_X-15, LOCATION_LABEL_Y+180, BOUND_X, BOUND_Y);
		labelGuard.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+225, BOUND_X, BOUND_Y);
		labelDeliverStaff.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+270, BOUND_X, BOUND_Y);
		labelVehicleId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+315, BOUND_X+40, BOUND_Y);
		labelVehicleInfo.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+385, BOUND_X, BOUND_Y);
		labelMoney.setBounds(LOCATION_LABEL_X+15, LOCATION_LABEL_Y+454, BOUND_X, BOUND_Y);
		
		textInstitutionId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textTransferNum.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+45, BOUND_X, BOUND_Y-6);
		textBarcode.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+90, BOUND_X, BOUND_Y-6);
		textGuard.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+135, BOUND_X, BOUND_Y-6);
		textDeliverStaff.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+180, BOUND_X, BOUND_Y-6);
		textVehicleId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+225, BOUND_X, BOUND_Y-6);
		textVehicleInfo.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+270, BOUND_X, BOUND_Y+40);
		textMoney.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+360, BOUND_X, BOUND_Y-6);
		
		comboBox.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y-45, BOUND_X, BOUND_Y-5);
		comboBox.addItem("");
		comboBox.addItem("北京");
		comboBox.addItem("上海");
		comboBox.addItem("广州");
		comboBox.addItem("南京");
		
		
		OK.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+500, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+125, LOCATION_LABEL_Y+500, BOUND_X-40, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);

		title.setFont(fnt1);
		labelInstitutionId.setFont(fnt);
		labelDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelTransferNum.setFont(fnt);
		labelVehicleId.setFont(fnt);
		labelDeliverStaff.setFont(fnt);
		labelGuard.setFont(fnt);
		labelVehicleInfo.setFont(fnt);
		labelMoney.setFont(fnt);
		labelBarcode.setFont(fnt);
		
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		
		this.add(title);
		this.add(labelInstitutionId);
		this.add(labelDate);
		this.add(labelDestination);
		this.add(labelTransferNum);
		this.add(labelVehicleId);
		this.add(labelDeliverStaff);
		this.add(labelGuard);
		this.add(labelVehicleInfo);
		this.add(labelMoney);
		this.add(labelBarcode);
		
		this.add(textInstitutionId);
		this.add(textTransferNum);
		this.add(textVehicleId);
		this.add(textGuard);
		this.add(textDeliverStaff);
		this.add(textVehicleInfo);
		this.add(textMoney);
		this.add(textBarcode);
		this.add(comboBox);
		
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		setTestState(true);

		String[] columnNames = {"装车日期", "目的地","营业厅编号",  "汽运编号","条形码","车辆代号","运费" };  
		int[] list={40,91,14,30,20,330,105,655,547};

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

		textInstitutionId.setEditable(state);
		textTransferNum.setEditable(state);
		textVehicleId.setEditable(state);
		textDeliverStaff.setEditable(state);
		textGuard.setEditable(state);
		textVehicleInfo.setEnabled(state);
		textMoney.setEnabled(state);
		textBarcode.setEnabled(state);
		
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textInstitutionId.setText(null);
		textTransferNum.setText(null);
		textVehicleId.setText(null);
		textDeliverStaff.setText(null);
		textGuard.setText(null);
		textVehicleInfo.setText(null);
		textMoney.setText(null);
		textBarcode.setText(null);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi loginUi=new LoginUi(mainFrame);
				mainFrame.setContentPane(loginUi);
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
		g.draw3DRect(35, 105, 274, 547, false);  //输入框外框
		this.repaint();
	}



	

	


	
	

}
