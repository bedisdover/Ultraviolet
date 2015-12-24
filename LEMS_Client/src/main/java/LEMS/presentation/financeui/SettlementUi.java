package LEMS.presentation.financeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓
 * 
 *         结算管理界面
 */
public class SettlementUi extends JPanel {
	MainFrame mainFrame;
	private UserVO user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton but1;
	private JButton but2;
	private Table table;
	private JLabel title;
	private Font font;
	private JButton butOut;
	private JLabel userId;
	private JLabel userRole;
	
	public SettlementUi(final MainFrame mainFrame,UserVO uvo) {
		this.mainFrame = mainFrame;
		user=uvo;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 添加事件监听器
		this.addListener();

	}

	public void init() {
		but1 = new JButton("查看收款信息");
		but2 = new JButton("添加到收款单");
		title = new JLabel("结算管理");
		font = new Font("宋体", Font.PLAIN, 26);
		butOut = new JButton("登出");
		userId = new JLabel(" 账号： "+user.getId());
		userId.setLocation(788, 25);
		userId.setSize(180, 25);
		userRole = new JLabel("身份： "+UserRole.transfer(user.getRole()));
		userRole.setLocation(788, 54);
		userRole.setSize(180, 25);
	}

	public void initComponents() {
		but1.setBounds(234,638-30,120,40);
		but2.setBounds(670,638-30,120,40);
		title.setBounds(454,26,249,45);
		title.setFont(font);
		butOut.setBounds(52, 36, 120, 40);
		
		this.add(but1);
		this.add(but2);
		this.add(title);
		this.add(butOut);
		this.add(userId);
		this.add(userRole);
		
		String[] columnNames = { "收款日期", "收款单位", "收款人","收款地点","收款金额"};
		int[] list = { 40, 138, 14, 30, 20, 174, 115-30, 708, 497 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));
	}

	public void addListener() {
		//“查看收款信息”按钮增加监听
		but1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

			
			}
		});
		//“添加到收款单”按钮增加监听
		but2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

			
			}
		});
		
		butOut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
