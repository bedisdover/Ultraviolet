package LEMS.presentation.financeui;

import java.awt.Font;
import java.awt.Graphics;
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
	
//	private JLabel userId;
//	private JLabel userRole;
	//	JLabel lab1 = new JLabel("系统当前价格：    	 ___________    元每公里");
	//	JLabel lab2 = new JLabel("请输入新价格：	");
	//	JLabel lab3 = new JLabel("元每公里");
	//	JLabel price = new JLabel("0");
	UltraButton butOut = new UltraButton("登出");
	UltraButton chakan1 = new UltraButton("新增");
	UltraButton chakan2 = new UltraButton("新增");
	UltraButton change1 = new UltraButton("修改");
	UltraButton change2 = new UltraButton("修改");
	//	JTextField text = new JTextField();
	Font font = new Font("Courier", Font.PLAIN, 26);
	String[] add;

	JLabel city1 = new JLabel("城市：");
	JLabel city2 = new JLabel("城市：");
	JLabel city3 = new JLabel("城市：");
	JLabel city4 = new JLabel("城市：");
	JLabel mid1 = new JLabel("至");
	JLabel mid2 = new JLabel("至");
	JLabel Express = new JLabel("快递类型：");
	JLabel Package = new JLabel("包装类型：");
	JLabel Transport = new JLabel("运输方式：");
	JLabel price = new JLabel("价格：");
	JLabel distance = new JLabel("距离：");
	//制定价格
	UltraComboBox pCity1 = new UltraComboBox();
	UltraComboBox pCity2 = new UltraComboBox();
	UltraComboBox expressType = new UltraComboBox();
	UltraComboBox packageType = new UltraComboBox();
	UltraComboBox transportType = new UltraComboBox();
	UltraTextField p = new UltraTextField();
	//制定距离
	UltraComboBox dCity1 = new UltraComboBox();
	UltraComboBox dCity2 = new UltraComboBox();
	UltraTextField d = new UltraTextField();

	public SettingPriceUi(final MainFrame mainFrame,UserVO uvo) {
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH ,
				MainFrame.JFRAME_HEIGHT);
		this.setLayout(null);
		//设置界面为白色
//		this.setBackground(SystemColor.inactiveCaptionBorder);
		this.mainFrame = mainFrame;
		user=uvo;
		//		JLabel name = new JLabel("账号："+user.getId());
		//		JLabel statue = new JLabel("身份：    总经理");
		title.setBounds(456,26,249,45);
		title.setFont(font);
		//		name.setBounds(375,75,135,28);
		//		statue.setBounds(548,75,183,28);
		//		lab1.setBounds(386,229,500,41);
		//		lab2.setBounds(386,436,300,41);
		//		lab3.setBounds(596,436,300,41);
		//		price.setBounds(526,225,100,41);
		//		price.setForeground(Color.RED);
		butOut.setBounds(60,41,120,40);
		butAdd.setBounds(860,41,120,40);
		
		city1.setBounds(90,150,40,30);
		pCity1.setBounds(135,150,120,30);
		mid1.setBounds(330,150,20,30);
		city2.setBounds(420,150,40,30);
		pCity2.setBounds(465,150,120,30);
		Express.setBounds(670,150,80,30);
		expressType.setBounds(750,150,120,30);
		Package.setBounds(70,320,80,30);
		packageType.setBounds(140,320,120,30);
		Transport.setBounds(310,320,80,30);
		transportType.setBounds(380,320,120,30);
		price.setBounds(550,320,40,30);
		p.setBounds(600,320,120,30);
		chakan1.setBounds(750,315,120,40);
		change1.setBounds(870,315,120,40);
		
		city3.setBounds(90,550,40,30);
		dCity1.setBounds(135,550,120,30);
		mid2.setBounds(290,550,20,30);
		city4.setBounds(330,550,40,30);
		dCity2.setBounds(380,550,120,30);
		distance.setBounds(550,550,40,30);
		d.setBounds(600,550,120,30);
		chakan2.setBounds(750,550,120,40);
		change2.setBounds(870,550,120,40);
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
		//		this.add(lab1);
		//		this.add(lab2);
		//		this.add(lab3);
		//		this.add(price);
		this.add(butOut);
		this.add(change1);
		this.add(change2);
		this.add(butAdd);
		this.add(city1);
		this.add(pCity1);
		this.add(mid1);
		this.add(city2);
		this.add(pCity2);
		this.add(Express);
		this.add(expressType);
		this.add(Package);
		this.add(packageType);
		this.add(Transport);
		this.add(transportType);
		this.add(price);
		this.add(p);
		this.add(chakan1);
		this.add(city3);
		this.add(dCity1);
		this.add(city4);
		this.add(dCity2);
		this.add(mid2);
		this.add(chakan2);
		this.add(distance);
		this.add(d);
//		this.add(userId);
//		this.add(userRole);
		//		this.add(text);
		this.initComponents();
		this.addListener();

	}

	public void initComponents(){
//		String[] columnNames1 = { "价格/元每km", "北京", "上海", "广州","南京" };
//		add = columnNames1;
//		int[] list1 = { 4, 119, 14, 40, 20, 202, 198-20, 598, 203 };
//		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
//		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
//		// *
//		table1 = new Table();
//		add(table1.drawTable(columnNames1, list1));
//		table1.setValueAt(0, 0, "北京");
//		table1.setValueAt(1, 0, "上海");
//		table1.setValueAt(2, 0, "广州");
//		table1.setValueAt(3, 0, "南京");
//
//
//		String[] columnNames2 = { "城市间距离/km", "北京", "上海", "广州","南京" };
//		int[] list2 = { 4, 119, 14, 40, 20, 202, 462-20-15, 598, 203};
//		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
//		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
//		// *
//		table2 = new Table();
//		add(table2.drawTable(columnNames2, list2));
//		table2.setValueAt(0, 0, "北京");
//		table2.setValueAt(1, 0, "上海");
//		table2.setValueAt(2, 0, "广州");
//		table2.setValueAt(3, 0, "南京");
//
//		// 将每一列的默认宽度设置为
//		table1.table.setRowHeight(40);
//		table2.table.setRowHeight(40);
//				
	}

	private void addListener(){
		butOut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});

		change1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int i = table1.table.getSelectedRow();
				int j = table1.table.getSelectedColumn();
				if(i==-1){
					JOptionPane.showMessageDialog(SettingPriceUi.this, "请先选中需要修改信息的城市");
				}else if(j!=0){
					String a = JOptionPane.showInputDialog(SettingPriceUi.this,"输入新的价格:","制定价格",JOptionPane.QUESTION_MESSAGE);
					table1.setValueAt(i, j, a);
				}
			}
		});
		change2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int i = table2.table.getSelectedRow();
				int j = table2.table.getSelectedColumn();
				if(i==-1){
					JOptionPane.showMessageDialog(SettingPriceUi.this, "请先选中需要修改信息的城市");
				}else if(j!=0){
					String a = JOptionPane.showInputDialog(SettingPriceUi.this,"输入新的距离:","制定距离",JOptionPane.QUESTION_MESSAGE);
					table2.setValueAt(i, j, a);
				}
			}
		});
		butAdd.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String now = "";
				for(int i = 1;i<add.length;i++){
					now=now+add[i]+" ";
				}
				String future = JOptionPane.showInputDialog(SettingPriceUi.this,"修改城市：（请添加或删除已有城市，添加城市用空格隔开）",now);
				System.out.println(future);
				table1.table.setVisible(false);
				table1.setVisible(false);
				table1.disable();
				String[] newCity = future.split(" ");
				int[] list1 = { 4, 119, 14, 40, 20, 202, 198-20, 598, 203 };
				Table table3 = new Table();
				add(table3.drawTable(newCity, list1));
				
				System.out.println("执行完毕");
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
