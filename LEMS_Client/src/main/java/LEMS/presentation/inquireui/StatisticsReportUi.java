package LEMS.presentation.inquireui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;

/**
 * @author 苏琰梓
 * 统计报表界面
 * 2015年11月25日
 */
public class StatisticsReportUi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private JLabel title;
	private JLabel labelDate1;
	private JLabel labelDate2;
	private JLabel name;
	private JLabel statue;	
	private JLabel subtitle1;
	private JLabel subtitle2;
	private JTextField textDate1;
	private JTextField textDate2;
	private JButton but;
	
	private Font font;
	private Font subfont;
	
	Table table1;
	Table table2;
	
	public StatisticsReportUi(final MainFrame mainFrame) {
		this.setBounds(228, 0, MainFrame.JFRAME_WIDTH-288, MainFrame.JFRAME_HEIGHT);
		this.setLayout(null);
		this.mainFrame = mainFrame;
		this.init();
		this.initComponent();
		this.addListener();
	}

	private void init() {
		title = new JLabel("查看统计分析");
		labelDate1 = new JLabel("日期：");
		labelDate2 = new JLabel("至");
		name = new JLabel("账号：   xxx");
		statue = new JLabel("身份：    财务人员");
		textDate1 = new JTextField();
		textDate2 = new JTextField();
		font = new Font("宋体", Font.PLAIN, 22);
		subfont = new Font("Dialog", Font.PLAIN, 18);
		but = new JButton("查看");
		subtitle1 = new JLabel("付款单信息");
		subtitle2 = new JLabel("收款单信息");
		System.out.println(subtitle1.getFont());
	}
	
	private void initComponent(){
		title.setBounds(434,16,249,45);
		title.setFont(font);
		name.setBounds(375,65,135,28);
		statue.setBounds(548,65,183,28);
		but.setBounds(740,119,120,30);
		labelDate1.setBounds(217,122,80,25);
		labelDate2.setBounds(490,122,80,25);
		textDate1.setBounds(290,122,160,25);
		textDate2.setBounds(540,122,160,25);
		subtitle1.setBounds(456,156,169,39);
		subtitle2.setBounds(456,430,169,39);
		subtitle1.setFont(subfont);
		subtitle2.setFont(subfont);
		
		this.add(title);
		this.add(labelDate1);
		this.add(labelDate2);
		this.add(textDate1);
		this.add(textDate2);
		this.add(name);
		this.add(statue);
		this.add(but);
		this.add(subtitle1);
		this.add(subtitle2);
		
		
		String[] columnNames1 = { "付款单", "收款单", "审批单据", "账户管理" };
		int[] list1 = { 30, 148, 14, 30, 20, 218, 198, 611, 220 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table1 = new Table();
		add(table1.drawTable(columnNames1, list1));
		
		String[] columnNames2 = { "付款单", "收款单", "审批单据", "账户管理" };
		int[] list2 = { 30, 148, 14, 30, 20, 218, 472, 611, 220};
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table2 = new Table();
		add(table2.drawTable(columnNames2, list2));
	}
	
	private void addListener(){
		but.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textDate1.setText(null);
				textDate2.setText(null);
				
				
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
