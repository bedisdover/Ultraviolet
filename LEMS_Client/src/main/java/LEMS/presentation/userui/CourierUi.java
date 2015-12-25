package LEMS.presentation.userui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import LEMS.presentation.MainFrame;
import LEMS.presentation.orderui.ReceiveUi;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓 快递员界面（订单管理界面） 2015年12月12日
 */
public class CourierUi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame mainFrame;

	private OrderManageUi orderManageUi;
	private JTabbedPane tabbedPane;
	private ReceiveUi receiveUi;
	//	private JLabel name1;
	//	private JLabel location1;
	//	private JLabel expressType;
	//	private JLabel packageType;
	//	private JLabel phone1;
	//	private JLabel weight;
	//	private JTextField sname;
	//	private JTextField sphone;
	//	private JTextField sweight;
	//	private JComboBox<String> sLocation;
	//	private JComboBox<String> sExpressType;
	//	private JComboBox<String> sPackageType;
	//
	//	private JLabel name2;
	//	private JLabel location2;
	//	private JLabel phone2;
	//	private JTextField rphone;
	//	private JTextField rname;
	//	private JComboBox<String> rLocation;
	//
	//	private JLabel code;
	//	private JLabel price;
	//	private JTextField Code;
	//	private JTextField Price;
	//
	//	private JButton butOK;
	//	private JLabel userId;
	//	private JLabel userRole;
	private UserVO user;

	public CourierUi(final MainFrame mainFrame,UserVO uvo) {
		user=uvo;
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		orderManageUi = new OrderManageUi(mainFrame,user);
		receiveUi = new ReceiveUi(mainFrame,user);
		this.init();
		this.initComponent();
	}

	private void init() {
		tabbedPane = new JTabbedPane(); 
		ImageIcon image1=new ImageIcon("source\\tabbedpanel\\订单管理.png");
		ImageIcon image2=new ImageIcon("source\\tabbedpanel\\接收订单.png");
		
		tabbedPane.addTab(null,image1,orderManageUi,"订单管理");
		tabbedPane.addTab(null,image2,receiveUi,"接收订单");

		//		name1 = new JLabel("寄件人姓名：");
		//		location1 = new JLabel("寄件人地址：");
		//		phone1 = new JLabel("寄件人号码：");
		//		weight = new JLabel("货物重量：");
		//		expressType = new JLabel("快递类型：");
		//		packageType = new JLabel("包装类型：");
		//		sname = new JTextField();
		//		sphone = new JTextField();
		//		sweight = new JTextField();
		//		sLocation = new JComboBox<String>();
		//		sExpressType = new JComboBox<String>();
		//		sPackageType = new JComboBox<String>();
		//
		//		name2 = new JLabel("收件人姓名：");
		//		location2 = new JLabel("收件人地址：");
		//		phone2 = new JLabel("收件人号码：");
		//		rphone = new JTextField();
		//		rname = new JTextField();
		//		rLocation = new JComboBox<String>();
		//
		//		code = new JLabel("订单条形码号：");
		//		price = new JLabel("运费：");
		//		Code = new JTextField();
		//		Price = new JTextField();
		//
		//		butOK = new JButton("生成");
		//		
		//		userId = new JLabel("账号： "+user.getId());
		//		userId.setLocation(770, 25);
		//		userId.setSize(150, 25);
		//		userRole = new JLabel("身份： "+UserRole.transfer(user.getRole()));
		//		userRole.setLocation(770, 60);
		//		userRole.setSize(150, 25);
	}

	private void initComponent() {
		//		name1.setBounds(75, 120, 140, 30);
		//		sname.setBounds(170, 120, 140, 30);
		//		location1.setBounds(380, 120, 140, 30);
		//		sLocation.setBounds(470, 120, 140, 30);
		//		phone1.setBounds(680, 120, 140, 30);
		//		sphone.setBounds(770, 120, 140, 30);
		//		weight.setBounds(75, 220, 140, 30);
		//		sweight.setBounds(170, 220, 140, 30);
		//		expressType.setBounds(380, 220, 140, 30);
		//		sExpressType.setBounds(470, 220, 140, 30);
		//		packageType.setBounds(680, 220, 140, 30);
		//		sPackageType.setBounds(770, 220, 140, 30);
		//
		//		name2.setBounds(75, 400, 140, 30);
		//		rname.setBounds(170, 400, 140, 30);
		//		location2.setBounds(380, 400, 140, 30);
		//		rLocation.setBounds(470, 400, 140, 30);
		//		phone2.setBounds(680, 400, 140, 30);
		//		rphone.setBounds(770, 400, 140, 30);
		//
		//		code.setBounds(75, 600, 140, 30);
		//		Code.setBounds(170, 600, 140, 30);
		//		price.setBounds(380, 600, 140, 30);
		//		Price.setBounds(470, 600, 140, 30);
		//		butOK.setBounds(710, 600, 120, 30);
		//
		//		sLocation.addItem("北京");
		//		sLocation.addItem("上海");
		//		sLocation.addItem("广州");
		//		sLocation.addItem("南京");
		//		sExpressType.addItem("经济");
		//		sExpressType.addItem("标准");
		//		sExpressType.addItem("特快");
		//		sPackageType.addItem("纸箱");
		//		sPackageType.addItem("木箱");
		//		sPackageType.addItem("快递袋");
		//		sPackageType.addItem("其他");
		//		rLocation.addItem("北京");
		//		rLocation.addItem("上海");
		//		rLocation.addItem("广州");
		//		rLocation.addItem("南京");
		//
		//		this.add(title);
		//		this.add(name1);
		//		this.add(sname);
		//		this.add(location1);
		//		this.add(sLocation);
		//		this.add(phone1);
		//		this.add(sphone);
		//		this.add(weight);
		//		this.add(sweight);
		//		this.add(expressType);
		//		this.add(sExpressType);
		//		this.add(sLocation);
		//		this.add(packageType);
		//		this.add(sPackageType);
		//		this.add(name2);
		//		this.add(rname);
		//		this.add(location2);
		//		this.add(rLocation);
		//		this.add(phone2);
		//		this.add(rphone);
		//		this.add(code);
		//		this.add(Code);
		//		this.add(price);
		//		this.add(Price);
		//		this.add(butOK);
		//		this.add(butOut);
		//		this.add(userId);
		//		this.add(userRole);
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		//	tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		this.add(tabbedPane);
	}

	//	private void addListener() {
	//		butOK.addMouseListener(new MouseAdapter() {
	//			public void mouseClicked(MouseEvent e) {
	//				if (isCompelete()) {
	//					/**
	//					 * 获取价格和订单条形码号
	//					 */
	//
	//				} else {
	//					JOptionPane.showMessageDialog(CourierUi.this, "请将信息填写完整！");
	//				}
	//			}
	//		});
	//
	//		butOut.addMouseListener(new MouseAdapter() {
	//			public void mouseClicked(MouseEvent e) {
	//				mainFrame.setContentPane(new LoginUi(mainFrame));
	//			}
	//		});
	//	}
	//
	//	private boolean isCompelete() {
	//		if (!sname.getText().equals("") && !sphone.getText().equals("")
	//				&& !sweight.getText().equals("") && !rname.getText().equals("")
	//				&& !rphone.getText().equals("")) {
	//			return true;
	//		}
	//		return false;
	//	}
	//
	//	public void paintComponent(Graphics g) {
	//		g.drawImage(MainFrame.background, 0, 0, this.getWidth(),
	//				this.getHeight(), null);
	//		g.drawLine(0, 320, mainFrame.JFRAME_WIDTH, 320);
	//		g.drawLine(0, 515, mainFrame.JFRAME_WIDTH, 515);
	//		this.repaint();
	//	}
}
