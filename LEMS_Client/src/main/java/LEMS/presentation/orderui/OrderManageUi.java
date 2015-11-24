package LEMS.presentation.orderui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.Order;
import LEMS.businesslogic.orderbl.OrderController;
import LEMS.presentation.MainFrame;

/**
 * @author 章承尧,苏琰梓 订单管理界面 2015年11月23日
 */
@SuppressWarnings("serial")
public class OrderManageUi extends JPanel {

	private MainFrame mainFrame;
	private JLabel title;
	
	// 寄件人
	private JLabel sender;
	private JLabel theSenderName;
	private JLabel theSenderPhone;
	private JLabel theSenderAddress;
	private JTextField sName;
	private JTextField sPhone;
	private JTextField sAddress;
	
	// 收件人
	private JLabel addressee;
	private JLabel theAddresseeName;
	private JLabel theAddresseePhone;
	private JLabel theAddresseeAddress;
	private JTextField aName;
	private JTextField aPhone;
	private JTextField aAddress;
	
	// 货物信息
	private JLabel cargo;
	private JLabel theCargoName;
	private JLabel theCargoType;
	private JLabel theCargoNumber;
	private JLabel theCargoWeight;
	private JLabel theCargoVolume;
	private JLabel theCargoSize;
	private JLabel theCargoPackage;
	private JLabel theCargoExpress;
	private JTextField cName;
	private JTextField cType;
	private JTextField cNumber;
	private JTextField cWeight;
	private JTextField cVolume;
	private JTextField cSize;
	private JComboBox<String> cPackage;
	private JComboBox<String> cExpress;
	
	// 按钮
	private JButton butOut;
	private JButton OK;
	private JButton cancel;

	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);
	
	/**
	 * 订单对象
	 */
	Order order;
	
	private OrderController controller;
	
	/**
	 * Create the panel.
	 */
	public OrderManageUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);

		this.init();
		this.initcomponents();
		this.addListener();
		
		order = new Order();
		
		controller = new OrderController();
	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("订单管理");
		//寄件人
		sender = new JLabel("寄件人");
		theSenderName = new JLabel("姓名：");
		theSenderPhone = new JLabel("电话：");
		theSenderAddress = new JLabel("地址：");
		sName = new JTextField();
		sPhone = new JTextField();
		sAddress = new JTextField();
		//收件人
		addressee = new JLabel("收件人");
		theAddresseeName = new JLabel("姓名：");
		theAddresseePhone = new JLabel("电话：");
		theAddresseeAddress = new JLabel("地址：");
		aName = new JTextField();
		aPhone = new JTextField();
		aAddress = new JTextField();
		//货物信息
		cargo = new JLabel("货物信息");
		theCargoName = new JLabel("名称：");
		theCargoType = new JLabel("类型：");
		theCargoNumber = new JLabel("数量：");
		theCargoWeight = new JLabel("重量：");
		theCargoVolume = new JLabel("体积：");
		theCargoSize = new JLabel("尺寸：");
		theCargoPackage = new JLabel("包装类型：");
		theCargoExpress = new JLabel("快递类型：");
		cName = new JTextField();
		cType = new JTextField();
		cNumber = new JTextField();
		cWeight = new JTextField();
		cVolume = new JTextField();
		cSize = new JTextField();
		cPackage = new JComboBox<String>();
		cPackage.addItem("木箱");
		cPackage.addItem("纸箱");
		cPackage.addItem("快递袋");
		cPackage.addItem("其他");
		cExpress = new JComboBox<String>();
		cExpress.addItem("经济");
		cExpress.addItem("标准");
		cExpress.addItem("特快");
		//按钮
		butOut = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
	}

	/**
	 * 初始化控件
	 */
	private void initcomponents() {
		title.setBounds(449, 10, 148, 39);
		title.setFont(fnt1);
		//寄件人
		sender.setBounds(124,50,118,57);
		theSenderName.setBounds(140,91,107,27);
		theSenderPhone.setBounds(140,125,107,27);
		theSenderAddress.setBounds(140,157,107,27);
		sName.setBounds(241,91,146,27);
		sPhone.setBounds(241,125,146,27);
		sAddress.setBounds(241,157,146,27);
		//收件人
		addressee.setBounds(124,199,118,57);
		theAddresseeName.setBounds(140,239,107,27);
		theAddresseePhone.setBounds(140,271,107,27);
		theAddresseeAddress.setBounds(140,305,107,27);
		aName.setBounds(241,239,146,27);
		aPhone.setBounds(241,271,146,27);
		aAddress.setBounds(241,305,146,27);
		//货物信息
		cargo.setBounds(124,351,118,57);
		theCargoName.setBounds(140,392,107,27);
		theCargoType.setBounds(140,423,107,27);
		theCargoNumber.setBounds(140,457,107,27);
		theCargoWeight.setBounds(140,495,107,27);
		theCargoVolume.setBounds(140,527,107,27);
		theCargoSize.setBounds(140,561,107,27);
		theCargoPackage.setBounds(140,597,107,27);
		theCargoExpress.setBounds(140,631,107,27);
		cName.setBounds(241,389,146,27);
		cType.setBounds(241,423,146,27);
		cNumber.setBounds(241,457,146,27);
		cWeight.setBounds(241,495,146,27);
		cVolume.setBounds(241,527,146,27);
		cSize.setBounds(241,561,146,27);
		cPackage.setBounds(241,597,146,27);
		cExpress.setBounds(241,631,146,27);
		//按钮
		butOut.setBounds(26,10,120,40);
		OK.setBounds(124,673,120,40);
		cancel.setBounds(279,673,120,40);
		
		this.add(title);
		this.add(sender);
		this.add(theSenderName);
		this.add(theSenderPhone);
		this.add(theSenderAddress);
		this.add(sName);
		this.add(sPhone);
		this.add(sAddress);
		this.add(addressee);
		this.add(theAddresseeName);
		this.add(theAddresseePhone);
		this.add(theAddresseeAddress);
		this.add(aName);
		this.add(aPhone);
		this.add(aAddress);
		this.add(cargo);
		this.add(theCargoName);
		this.add(theCargoType);
		this.add(theCargoNumber);
		this.add(theCargoWeight);
		this.add(theCargoSize);
		this.add(theCargoVolume);
		this.add(theCargoPackage);
		this.add(theCargoExpress);
		this.add(cName);
		this.add(cType);
		this.add(cNumber);
		this.add(cWeight);
		this.add(cVolume);
		this.add(cSize);
		this.add(cPackage);
		this.add(cExpress);
		this.add(butOut);
		this.add(OK);
		this.add(cancel);
		
		JPanel jPanel = new JPanel();
		jPanel.setForeground(Color.RED);
		jPanel.setLayout(new GridLayout(20, 5));
		jPanel.setBounds(440, 51, 561, 672);
		JTextField tabulation[] = new JTextField[100];
		Font fnt2 = new Font("Courier", Font.PLAIN, 20);
		for (int i = 0; i < 100; i++) {
			tabulation[i] = new JTextField();
			tabulation[i].setSize(200, 200);
			tabulation[i].setEnabled(false);
			tabulation[i].setDisabledTextColor(Color.BLACK);
			tabulation[i].setFont(fnt2);
			// 居中
			tabulation[i].setHorizontalAlignment(JTextField.CENTER);
			jPanel.add(tabulation[i]);
		}
		tabulation[0].setText("日期");
		tabulation[1].setText("名称");
		tabulation[2].setText("条形码号");
		tabulation[3].setText("报价");
		tabulation[4].setText("预估时间");
		this.add(jPanel);
	}

	private void addListener() {
		butOut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//TODO 返回主界面
				System.exit(0);
			}
		});
		
		OK.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//生成订单
				createOrder();	
			}
		});
		
		cancel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
		});
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(101, 53, 325, 667, false);
		g.draw3DRect(120, 63, 284, 133, false);
		g.draw3DRect(120, 209, 284, 139, false);
		g.draw3DRect(120, 359, 284, 306, false);
		this.repaint();
	}
	
	/**
	 * 生成订单
	 */
	private void createOrder() {
		//添加寄件人信息
		controller.addSender(sName.getText(), sPhone.getText(), sAddress.getText());
		//添加收件人信息
		controller.addReceiver(aName.getText(), aPhone.getText(), aAddress.getText());
		//添加货物信息
		controller.addGoodsInfo(cName.getText(), cSize.getText(), cNumber.getText(), 
								cWeight.getText(), cVolume.getText());
		//选择快递类型
		controller.chooseType(cExpress.getSelectedItem());
		//选择包装类型
		controller.choosePack(cPackage.getSelectedItem());
	}
}
