package LEMS.presentation.financeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraComboBox;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓 制定价格界面 2015年12月4日
 */
public class SettingPriceUi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserVO user;
	
	MainFrame mainFrame;
	JLabel title = new JLabel("制定常量");
	Table table1;
	Table table2;
	UltraButton butAdd = new UltraButton("修改");
	
	UltraButton butOut = new UltraButton("返回");
	Font font = new Font("Courier", Font.PLAIN, 26);
	String[] add;

	JLabel xuanze = new JLabel("制定常量：");
	JLabel city1 = new JLabel("城市：");
	JLabel city2 = new JLabel("城市：");
	JLabel mid1 = new JLabel("至");
	JLabel Express = new JLabel("快递类型：");
	JLabel Package = new JLabel("包装类型：");
	JLabel Transport = new JLabel("运输方式：");
	
	UltraComboBox xz = new UltraComboBox();

	UltraComboBox City1 = new UltraComboBox();
	UltraComboBox City2 = new UltraComboBox();
	UltraComboBox expressType = new UltraComboBox();
	UltraComboBox packageType = new UltraComboBox();
	UltraComboBox transportType = new UltraComboBox();

	@SuppressWarnings("unchecked")
	public SettingPriceUi(final MainFrame mainFrame,UserVO uvo) {
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH ,
				MainFrame.JFRAME_HEIGHT);
		this.setLayout(null);
		this.mainFrame = mainFrame;
		user=uvo;
		//		JLabel name = new JLabel("账号："+user.getId());
		//		JLabel statue = new JLabel("身份：    总经理");
		title.setBounds(456,26,249,45);
		title.setFont(font);
		//		name.setBounds(375,75,135,28);
		//		statue.setBounds(548,75,183,28);
		butOut.setBounds(60,41,120,40);
		butAdd.setBounds(860,41,120,40);
		
		xuanze.setBounds(70,150,70,30);
		xz.setBounds(135,150,120,30);
		city1.setBounds(425,150,40,30);
		City1.setBounds(465,150,120,30);
		mid1.setBounds(645,150,20,30);
		city2.setBounds(710,150,80,30);
		City2.setBounds(750,150,120,30);
		Express.setBounds(690,220,80,30);
		expressType.setBounds(750,220,120,30);
		Package.setBounds(70,220,80,30);
		packageType.setBounds(135,220,120,30);
		Transport.setBounds(406,220,80,30);
		transportType.setBounds(465,220,120,30);
		
		
		xz.addItem("制定价格");
		xz.addItem("制定距离");
		
		City1.addItem("北京");
		City1.addItem("上海");
		City1.addItem("广州");
		City1.addItem("南京");
		City2.addItem("北京");
		City2.addItem("上海");
		City2.addItem("广州");
		City2.addItem("南京");
		expressType.addItem("标准");
		expressType.addItem("特快");
		packageType.addItem("纸袋");
		packageType.addItem("箱子");
		packageType.addItem("其他");
		transportType.addItem("火车");
		transportType.addItem("汽车");
		transportType.addItem("飞机");
		//		text.setBounds(486,442,100,30);
		//		text.setForeground(Color.RED);

//		userId = new JLabel(" 账号： "+user.getId());
//		userId.setLocation(389, 82);
//		userId.setSize(180, 25);
		//userRole = new JLabel("身份： "+UserRole.transfer(user.getRole()));
//		userRole.setLocation(514, 82);
//		userRole.setSize(180, 25);
		
		this.add(title);
		//		this.add(name);
		//		this.add(statue);
		this.add(butOut);
		this.add(butAdd);
		this.add(city1);
		this.add(City1);
		this.add(mid1);
		this.add(city2);
		this.add(City2);
		this.add(Express);
		this.add(expressType);
		this.add(Package);
		this.add(packageType);
		this.add(Transport);
		this.add(transportType);
		this.add(xuanze);
		this.add(xz);
//		this.add(userId);
//		this.add(userRole);
		this.initComponents();
		this.addListener();

	}

	public void initComponents(){
		String[] columnNames1 = { "" };
		add = columnNames1;
		int[] list1 = { 30, 781, 14, 1, 20, 102, 280, 798, 400 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table1 = new Table();
		add(table1.drawTable(columnNames1, list1));
		 //将每一列的默认宽度设置为
		table1.table.setRowHeight(40);
	}

	private void addListener(){
		xz.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(xz.getSelectedItem()=="制定距离"){
					expressType.setVisible(false);
					Express.setVisible(false);
					Package.setVisible(false);
					packageType.setVisible(false);
					Transport.setVisible(false);
					transportType.setVisible(false);
				}else{
					boolean a = true;
					expressType.setVisible(true);
					Express.setVisible(a);
					Package.setVisible(a);
					packageType.setVisible(a);
					Transport.setVisible(a);
					transportType.setVisible(a);
				}
			}
		});
		butOut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});

		butAdd.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
