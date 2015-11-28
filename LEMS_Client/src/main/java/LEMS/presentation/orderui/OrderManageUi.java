package LEMS.presentation.orderui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.Order;
import LEMS.businesslogic.orderbl.controller.OrderController;
import LEMS.po.orderpo.City;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;

/**
 * @author 章承尧,苏琰梓 订单管理界面 2015年11月23日
 */
@SuppressWarnings("serial")
public class OrderManageUi extends JPanel {

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
	private JLabel theCargoPackage;
	private JLabel theCargoExpress;
	private JTextField cName;
	private JTextField cType;
	private JTextField cNumber;
	private JTextField cWeight;
	private JTextField cLength;
	private JTextField cWidth;
	private JTextField cHeight;
	private JComboBox<Packing> cPackage;
	private JComboBox<Express> cExpress;

	//乘号
	private JLabel mul;
	private JLabel mul2;
	
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
	
	MainFrame mainFrame;
	
	/**
	 * Create the panel.
	 */
	public OrderManageUi(MainFrame mainFrame) {
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
		theCargoPackage = new JLabel("包装类型：");
		theCargoExpress = new JLabel("快递类型：");
		cName = new JTextField();
		cType = new JTextField();
		cNumber = new JTextField();
		cWeight = new JTextField();
		cLength = new JTextField();
		cWidth = new JTextField();
		cHeight = new JTextField();
		cPackage = new JComboBox<Packing>();
		cPackage.addItem(Packing.Wooden);
		cPackage.addItem(Packing.Carton);
		cPackage.addItem(Packing.Bag);
		cPackage.addItem(Packing.Other);
		cExpress = new JComboBox<Express>();
		cExpress.addItem(Express.standard);
		cExpress.addItem(Express.economy);
		cExpress.addItem(Express.special);
		//乘号
		mul = new JLabel("X");
		mul2 = new JLabel("X");
		
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
		sender.setBounds(74,50,118,57);
		theSenderName.setBounds(90,91,107,27);
		theSenderPhone.setBounds(90,125,107,27);
		theSenderAddress.setBounds(90,157,107,27);
		sName.setBounds(191,91,146,27);
		sPhone.setBounds(191,125,146,27);
		sAddress.setBounds(191,157,146,27);
		//收件人
		addressee.setBounds(74,199,118,57);
		theAddresseeName.setBounds(90,239,107,27);
		theAddresseePhone.setBounds(90,271,107,27);
		theAddresseeAddress.setBounds(90,305,107,27);
		aName.setBounds(191,239,146,27);
		aPhone.setBounds(191,271,146,27);
		aAddress.setBounds(191,305,146,27);
		//货物信息
		cargo.setBounds(74,351,118,57);
		theCargoName.setBounds(90,392,107,27);
		theCargoType.setBounds(90,423,107,27);
		theCargoNumber.setBounds(90,457,107,27);
		theCargoWeight.setBounds(90,495,107,27);
		theCargoVolume.setBounds(90,527,107,27);
		theCargoPackage.setBounds(90,567,107,27);
		theCargoExpress.setBounds(90,601,107,27);
		cName.setBounds(191,389,146,27);
		cType.setBounds(191,423,146,27);
		cNumber.setBounds(191,457,146,27);
		cWeight.setBounds(191,495,146,27);
		cLength.setBounds(191,527,40,27);
		cWidth.setBounds(244,527,40,27);
		cHeight.setBounds(297, 527, 40, 27);
		cPackage.setBounds(191,567,146,27);
		cExpress.setBounds(191,601,146,27);
		mul.setBounds(232, 527, 10, 27);
		mul2.setBounds(287, 527, 10, 27);
		
		//按钮
		butOut.setBounds(26,10,120,40);
		OK.setBounds(74,663,120,40);
		cancel.setBounds(229,663,120,40);
		
		//TODO 默认选中第一个输入框
		
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
		this.add(theCargoVolume);
		this.add(theCargoPackage);
		this.add(theCargoExpress);
		this.add(cName);
		this.add(cType);
		this.add(cNumber);
		this.add(cWeight);
		this.add(cLength);
		this.add(cWidth);
		this.add(cHeight);
		this.add(cPackage);
		this.add(cExpress);
		this.add(mul);
		this.add(mul2);
		this.add(butOut);
		this.add(OK);
		this.add(cancel);
		
//		JPanel jPanel = new JPanel();
//		jPanel.setForeground(Color.RED);
//		jPanel.setLayout(new GridLayout(20, 5));
//		jPanel.setBounds(420, 51, 561, 672);
//		JTextField tabulation[] = new JTextField[100];
//		Font fnt2 = new Font("Courier", Font.PLAIN, 20);
//		for (int i = 0; i < 100; i++) {
//			tabulation[i] = new JTextField();
//			tabulation[i].setSize(200, 200);
//			tabulation[i].setEnabled(false);
//			tabulation[i].setDisabledTextColor(Color.BLACK);
//			tabulation[i].setFont(fnt2);
//			// 居中
//			tabulation[i].setHorizontalAlignment(JTextField.CENTER);
//			jPanel.add(tabulation[i]);
//		}
//		tabulation[0].setText("日期");
//		tabulation[1].setText("名称");
//		tabulation[2].setText("条形码号");
//		tabulation[3].setText("报价");
//		tabulation[4].setText("预估时间");
//		this.add(jPanel);
		String strings[] = {"编号", "日期", "名称", "条形码号", "报价", "预估时间"};
		int nums[] = {300, 93, 20, 30, 20, 420, 55, 576, 650}; 
		JScrollPane pane = new Table().drawTable(strings, nums);
		this.add(pane);
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
				okOperation();
			}
		});
		
		cancel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//清空输入框
				empty();
			}
		});
		
		
		//TODO 添加到MainFrame中
		mainFrame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					okOperation();
				}
			}
			
		});
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(51, 53, 325, 657, false);
		g.draw3DRect(70, 63, 284, 133, false);
		g.draw3DRect(70, 209, 284, 139, false);
		g.draw3DRect(70, 359, 284, 286, false);
		//TODO 添加圆角矩形
//		g.drawRoundRect(51, 53, 325, 667, 20, 20);
		//TODO 消除锯齿
//		RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_ANTIALIAS_ON);
//		renderingHints.
		this.repaint();
	}
	
	/**
	 * 按下“确定”按钮后执行的动作
	 */
	private void okOperation() {
		//判断输入是否为空
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "输入内容为空！", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//判断输入是否合法
		if (!isLegal()) {
			return;
		}
		
		//判断目标城市是否在服务范围内
		if (!legalCity()) {
			//TODO 很丑的对话框
			JOptionPane.showMessageDialog(mainFrame, "输入地址无效" + "\n或\n" +"目标城市不在服务范围内！", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} 
		
		// 生成订单
		createOrder();
		// 清空输入框
		empty();
	}
	
	/**
	 * 判断输入框是否为空
	 * 
	 * @return 若存在空输入框，返回true，否则返回false
	 */
	private boolean isEmpty() {
		if (sName.getText().equals("") || sPhone.getText().equals("") || sAddress.getText().equals("")) {
			return true;
		}
		if (aName.getText().equals("") || aPhone.getText().equals("") || aAddress.getText().equals("")) {
			return true;
		}
		if (cName.getText().equals("") || cType.getText().equals("") || cNumber.getText().equals("") || cLength.getText().equals("") || cWeight.getText().equals("")) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断所输入城市是否在服务范围内
	 * 
	 * @return 若在服务范围内，返回true，否则返回false
	 */
	private boolean legalCity() {
		
		if (sAddress.getText().length() < 3 || sAddress.getText().length() < 3) {
			return false;
		}
		
		String sCity = sAddress.getText().substring(0, 2);
		String aCity = aAddress.getText().substring(0, 2);
		
		if (City.legalCity(sCity) && City.legalCity(aCity)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断输入是否合法
	 * 
	 * @return
	 */
	private boolean isLegal() {
		
		//TODO 利用正则表达式判断输入是否合法
		if (!sPhone.getText().matches("\\d+") || aPhone.getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(mainFrame, "输入手机号无效!" + "\n或\n" +"手机号不存在！", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 清空输入框
	 */
	private void empty() {
		sName.setText(null);
		sPhone.setText(null);
		sAddress.setText(null);
		aName.setText(null);
		aPhone.setText(null);
		aAddress.setText(null);
		cName.setText(null);
		cType.setText(null);
		cNumber.setText(null);
		cLength.setText(null);
		cWidth.setText(null);
		cHeight.setText(null);
		cWeight.setText(null);
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
		controller.addGoodsInfo(cName.getText(),  cNumber.getText(), cWeight.getText(), cLength.getText(), cWidth.getText(), cHeight.getText());
		//选择快递类型
		controller.chooseType((Express) cExpress.getSelectedItem());
		//选择包装类型
		controller.choosePack((Packing) cPackage.getSelectedItem());
		//TODO 添加对话框显示价格与时间
		JOptionPane.showMessageDialog(mainFrame, "运费：" + controller.getMoney() 
		+ "\n总计：" + controller.getTotal() + "\n预计时间：" + controller.getTime());
	}
}
