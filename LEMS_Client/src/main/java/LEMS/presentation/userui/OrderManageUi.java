package LEMS.presentation.userui;

import java.awt.Font;
import java.awt.Graphics;
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
import LEMS.po.orderpo.City;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.vo.ordervo.CustomerVO;
import LEMS.vo.ordervo.OrderVO;
import LEMS.vo.uservo.UserVO;

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
	private JLabel theCargoNumber;
	private JLabel theCargoWeight;
	private JLabel theCargoVolume;
	private JLabel theCargoPackage;
	private JLabel theCargoExpress;
	private JTextField cName;
	private JTextField cNumber;
	private JTextField cWeight;
	private JTextField cLength;
	private JTextField cWidth;
	private JTextField cHeight;
	private JComboBox<String> cPackage;
	private JComboBox<String> cExpress;

	//乘号
	private JLabel mul;
	private JLabel mul2;
	
	// 按钮
	private JButton butOut;
	private JButton OK;
	private JButton cancel;
	
	private Table table;

	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);
	private Font font = new Font("courier", Font.PLAIN, 15);
	
	private MainFrame mainFrame;
	
	private OrderVO orderVO;
	
	private Order order;
	
	/**
	 * Create the panel.
	 */
	public OrderManageUi(MainFrame mainFrame, UserVO user) {
		this.mainFrame = mainFrame;
		//设置布局格式
		this.setLayout(null);
		//设置边界
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		//组件声明
		this.init();
		//初始化组件
		this.initcomponents();
		//添加监听事件
		this.addListener();

		orderVO = new OrderVO();
		//order = new Order(orderVO, user);
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
		theCargoNumber = new JLabel("数量：");
		theCargoWeight = new JLabel("重量：");
		theCargoVolume = new JLabel("体积：");
		theCargoPackage = new JLabel("包装类型：");
		theCargoExpress = new JLabel("快递类型：");
		cName = new JTextField();
		cNumber = new JTextField();
		cWeight = new JTextField();
		cLength = new JTextField();
		cWidth = new JTextField();
		cHeight = new JTextField();
		cPackage = new JComboBox<String>();
		cPackage.addItem("快递袋");
		cPackage.addItem("纸箱");
		cPackage.addItem("木箱");
		cPackage.addItem("其它");
		cExpress = new JComboBox<String>();
		cExpress.addItem("标准");
		cExpress.addItem("经济");
		cExpress.addItem("特快");
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
		addressee.setBounds(74,199-15,118,57);
		theAddresseeName.setBounds(90,239-15,107,27);
		theAddresseePhone.setBounds(90,271-15,107,27);
		theAddresseeAddress.setBounds(90,305-15,107,27);
		aName.setBounds(191,239-15,146,27);
		aPhone.setBounds(191,271-15,146,27);
		aAddress.setBounds(191,305-15,146,27);
		//货物信息
		int shang = 20;
		cargo.setBounds(74,351-shang,118,57);
		theCargoName.setBounds(90,392-shang,107,27);
		theCargoNumber.setBounds(90,423-shang,107,27);
		theCargoWeight.setBounds(90,457-shang,107,27);
		theCargoVolume.setBounds(90,495-shang,107,27);
		theCargoPackage.setBounds(90,527-shang,107,27);
		theCargoExpress.setBounds(90,567-shang,107,27);
		cName.setBounds(191,389-shang,146,27);
		cNumber.setBounds(191,423-shang,146,27);
		cWeight.setBounds(191,457-shang,146,27);
		cLength.setBounds(191,495-shang,40,27);
		cWidth.setBounds(244,495-shang,40,27);
		cHeight.setBounds(297, 495-shang, 40, 27);
		cPackage.setBounds(191,527-shang,146,27);
		cExpress.setBounds(191,567-shang,146,27);
		mul.setBounds(232, 527-shang, 10, 27);
		mul2.setBounds(287, 527-shang, 10, 27);
		
		//设置标签字体
		sender.setFont(font);
		theSenderName.setFont(font);
		theSenderPhone.setFont(font);
		theSenderAddress.setFont(font);
		addressee.setFont(font);
		theAddresseeName.setFont(font);
		theAddresseePhone.setFont(font);
		theAddresseeAddress.setFont(font);
		cargo.setFont(font);
		theCargoName.setFont(font);
		theCargoNumber.setFont(font);
		theCargoWeight.setFont(font);
		theCargoVolume.setFont(font);
		theCargoPackage.setFont(font);
		theCargoExpress.setFont(font);
		
		//按钮
		butOut.setBounds(26,15,100,30);
		OK.setBounds(74,615,120,40);
		cancel.setBounds(229,615,120,40);
		
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
		this.add(theCargoNumber);
		this.add(theCargoWeight);
		this.add(theCargoVolume);
		this.add(theCargoPackage);
		this.add(theCargoExpress);
		this.add(cName);
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

		String strings[] = {"编号", "条形码号", "名称", "报价"};
		int nums[] = {300, 140, 20, 30, 20, 395, 60, 578, 580}; 
		table = new Table();
		JScrollPane pane = table.drawTable(strings, nums);
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
				OKOperation();
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
					OKOperation();
				}
			}
		});
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(70, 63, 284, 270, false);
		g.draw3DRect(70, 369-20, 284, 246, false);

		this.repaint();
	}
	
	/**
	 * 按下“确定”按钮后执行的动作
	 */
	private void OKOperation() {
		//判断输入是否为空
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "输入内容为空！", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//判断目标城市是否在服务范围内
		if (!legalCity()) {
			JOptionPane.showMessageDialog(mainFrame, "输入地址无效" + "\n或\n" +"目标城市不在服务范围内！", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//判断手机号是否合法（全为7位或11位数字）
		if (!legalPhone()) {
			JOptionPane.showMessageDialog(mainFrame, "输入手机号无效!" + "\n或\n" +"手机号不存在！", "Error", JOptionPane.ERROR_MESSAGE);
		}
		//判断输入是否合法
		if (!isLegal()) {
			JOptionPane.showMessageDialog(mainFrame, "请输入正确数值！", "Error", JOptionPane.ERROR_MESSAGE);
		}
		// 生成订单
		this.createOrder();
		//添加到订单列表中
		String[] values = {order.createID(), cName.getText(), order.getTotal() + ""};
		table.setValueAt(table.numOfEmpty(), values);
		// 清空输入框
		this.empty();
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
		if (cName.getText().equals("") || cNumber.getText().equals("") || cLength.getText().equals("") || cWeight.getText().equals("")) {
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
		if (City.legalCity(sAddress.getText()) && City.legalCity(aAddress.getText())) {
			return true;
		}
		
		return false;
	}
	
	private boolean legalPhone() {
		// 判断手机号是否合法（全为数字、共7位或11位）
		if (sPhone.getText().length() != 7 && sPhone.getText().length() != 11) {
			return false;
		}
		if (aPhone.getText().length() != 7 && aPhone.getText().length() != 11) {
			return false;
		}
		
		if (!isNumber(sPhone.getText()) || !isNumber(aPhone.getText())) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 判断输入（数量、尺寸、重量）是否合法
	 * 
	 * @return
	 */
	private boolean isLegal() {
		try {
			Integer.parseInt(cNumber.getText());
			Double.parseDouble(cWeight.getText());
			Double.parseDouble(cLength.getText());
			Double.parseDouble(cWidth.getText());
			Double.parseDouble(cHeight.getText());
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
	
	/**
	 * 判断输入是否为数字（手机号）
	 * 
	 * @param string 输入内容
	 * @return 若全为数字，返回true，否则返回false
	 */
	private boolean isNumber(String string) {
		return string.matches("\\d+");
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
		CustomerVO sender = new CustomerVO();
		sender.setName(sName.getText());
		sender.setPhone(sPhone.getText());
		sender.setAddress(sAddress.getText());
		order.addSender(sender);
		//添加收件人信息
		CustomerVO receiver = new CustomerVO();
		receiver.setName(aName.getText());
		receiver.setPhone(aPhone.getText());
		receiver.setAddress(aAddress.getText());
		order.addReceiver(receiver);
		//添加货物信息
		order.addGoodsInfo(cName.getText(),  cNumber.getText(), cWeight.getText(), cLength.getText(), cWidth.getText(), cHeight.getText());
		//选择快递类型
		order.chooseExpress(Express.transfer(cExpress.getSelectedItem() + ""));
		//选择包装类型
		order.choosePack(Packing.transfer(cPackage.getSelectedItem() + ""));

		JOptionPane.showMessageDialog(mainFrame, "运费：" + order.getMoney() 
		+ "\n总计：" + order.getTotal() + "\n预计时间：" + order.getTime());
		
		order.endOrder();
	}
}
