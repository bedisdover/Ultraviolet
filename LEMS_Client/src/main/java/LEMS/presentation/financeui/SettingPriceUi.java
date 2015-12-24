package LEMS.presentation.financeui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
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
	JLabel title = new JLabel("制定价格");
	Table table1;
	Table table2;

	//	JLabel lab1 = new JLabel("系统当前价格：    	 ___________    元每公里");
	//	JLabel lab2 = new JLabel("请输入新价格：	");
	//	JLabel lab3 = new JLabel("元每公里");
	//	JLabel price = new JLabel("0");
	JButton butOut = new JButton("登出");
	UltraButton change1 = new UltraButton("修改");
	JButton change2 = new JButton("修改");
	//	JTextField text = new JTextField();
	Font font = new Font("Courier", Font.PLAIN, 26);



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
		//		lab1.setBounds(386,229,500,41);
		//		lab2.setBounds(386,436,300,41);
		//		lab3.setBounds(596,436,300,41);
		//		price.setBounds(526,225,100,41);
		//		price.setForeground(Color.RED);
		butOut.setBounds(60,41,120,40);
		change1.setBounds(830,350,120,40);
		change2.setBounds(830,550,120,40);
		//		text.setBounds(486,442,100,30);
		//		text.setForeground(Color.RED);

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
		//		this.add(text);
		this.initComponents();
		this.addListener();

	}

	public void initComponents(){
		String[] columnNames1 = { "价格/元每km", "北京", "上海", "广州","南京" };
		int[] list1 = { 4, 119, 14, 40, 20, 202, 198-20, 598, 203 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table1 = new Table();
		add(table1.drawTable(columnNames1, list1));
		table1.setValueAt(0, 0, "北京");
		table1.setValueAt(1, 0, "上海");
		table1.setValueAt(2, 0, "广州");
		table1.setValueAt(3, 0, "南京");


		String[] columnNames2 = { "城市间距离/km", "北京", "上海", "广州","南京" };
		int[] list2 = { 4, 119, 14, 40, 20, 202, 462-20-15, 598, 203};
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table2 = new Table();
		add(table2.drawTable(columnNames2, list2));
		table2.setValueAt(0, 0, "北京");
		table2.setValueAt(1, 0, "上海");
		table2.setValueAt(2, 0, "广州");
		table2.setValueAt(3, 0, "南京");

		// 将每一列的默认宽度设置为
		table1.table.setRowHeight(40);
		table2.table.setRowHeight(40);

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

	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
