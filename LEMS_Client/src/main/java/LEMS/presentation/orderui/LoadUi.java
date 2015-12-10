package LEMS.presentation.orderui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.load.Load;
import LEMS.po.orderpo.LoadNotePO;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.method.DateChooser;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 周梦佳
 * 装运管理界面
 */
@SuppressWarnings("serial")
public class LoadUi extends JPanel {


	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=80;
	private static final int LOCATION_LABEL_Y=126;
	private static final int LOCATION_TEXT_X=170;
	private static final int LOCATION_TEXT_Y=221;
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
	private JButton finish;
	private JLabel labelDate;
	private JLabel labelDestination;
	private JLabel labelInstitutionId;
	private JLabel labelTransferNum;
	private JLabel labelVehicleId;
	private JLabel labelGuard;
	private JLabel labelDeliverStaff;
	private JLabel labelBarcode;

	private JTextField textInstitutionId;
	private JTextField textTransferNum;
	private JTextField textVehicleId;
	private JTextField textGuard;
	private JTextField textDeliverStaff;
	private JTextField textID;

	private JComboBox<String> comboBox;//destination
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	private Load load;
	
	private LoadNotePO loadNotePO;
	
	public LoadUi(final MainFrame mainFrame) {
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
		//TODO load具体实现
	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("装运管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		finish =new JButton("完成");
		labelDate = new JLabel("装车日期:");
		labelDestination = new JLabel("目的地:");
		labelInstitutionId = new JLabel("营业厅编号:");
		labelTransferNum = new JLabel("汽运编号:");
		labelVehicleId = new JLabel("车辆代号：");
		labelDeliverStaff = new JLabel("押运员:");
		labelGuard = new JLabel("监装员:");
		labelBarcode= new JLabel("订单条形码号：");
		
		textInstitutionId = new JTextField();
		textTransferNum = new JTextField();
		textVehicleId = new JTextField();
		textDeliverStaff = new JTextField();
		textGuard = new JTextField();
		textID=new JTextField();
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
		labelInstitutionId.setBounds(LOCATION_LABEL_X-7, LOCATION_LABEL_Y+96, BOUND_X, BOUND_Y);
		labelTransferNum.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+144, BOUND_X, BOUND_Y);
		labelBarcode.setBounds(LOCATION_LABEL_X-15, LOCATION_LABEL_Y+192, BOUND_X, BOUND_Y);
		labelGuard.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+237, BOUND_X, BOUND_Y);
		labelDeliverStaff.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+285, BOUND_X, BOUND_Y);
		labelVehicleId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+333, BOUND_X+40, BOUND_Y);
		
		textInstitutionId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textTransferNum.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+48, BOUND_X, BOUND_Y-6);
		textID.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+96, BOUND_X, BOUND_Y-6);
		textGuard.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+144, BOUND_X, BOUND_Y-6);
		textDeliverStaff.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+192, BOUND_X, BOUND_Y-6);
		textVehicleId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+237, BOUND_X, BOUND_Y-6);
		
		comboBox.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y-48, BOUND_X, BOUND_Y-5);
		comboBox.addItem("");
		comboBox.addItem("北京");
		comboBox.addItem("上海");
		comboBox.addItem("广州");
		comboBox.addItem("南京");
		
		
		OK.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+390, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+125, LOCATION_LABEL_Y+390, BOUND_X-40, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120,40);
		update.setBounds(550, 590, 120, 40);
		finish.setBounds(750, 590, 120, 40);
		
		title.setFont(fnt1);
		labelInstitutionId.setFont(fnt);
		labelDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelTransferNum.setFont(fnt);
		labelVehicleId.setFont(fnt);
		labelDeliverStaff.setFont(fnt);
		labelGuard.setFont(fnt);
		labelBarcode.setFont(fnt);
		
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		finish.setFont(fnt2);
		
		this.add(title);
		this.add(labelInstitutionId);
		this.add(labelDate);
		this.add(labelDestination);
		this.add(labelTransferNum);
		this.add(labelVehicleId);
		this.add(labelDeliverStaff);
		this.add(labelGuard);
		this.add(labelBarcode);
		
		this.add(textInstitutionId);
		this.add(textTransferNum);
		this.add(textVehicleId);
		this.add(textGuard);
		this.add(textDeliverStaff);
		this.add(textID);
		this.add(comboBox);
		
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(finish);
		
		String[] columnNames = {"装车日期", "目的地","营业厅编号",  "汽运编号","条形码","车辆代号"};  
		int[] list={40,94,14,30,20,370,105,582,470};

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
		textID.setEnabled(state);
		
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
		textID.setText(null);
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
		finish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				// TODO 返回按钮的具体实现
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
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi l=new LoginUi(mainFrame);
				mainFrame.setContentPane(l);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(55, 105, 274, 470, false);  //输入框外框
		this.repaint();
	}



	

	


	
	

}
