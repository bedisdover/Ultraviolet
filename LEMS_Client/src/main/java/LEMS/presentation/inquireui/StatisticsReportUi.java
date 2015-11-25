package LEMS.presentation.inquireui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import LEMS.presentation.MainFrame;

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
		but = new JButton("查看");
		subtitle1 = new JLabel("付款单信息");
		subtitle2 = new JLabel("收款单信息");
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
		subtitle1.setBounds(548,148,169,39);
		subtitle2.setBounds(548,438,169,39);
		
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
		
		JPanel jPanel = new JPanel();
		jPanel.setForeground(Color.RED);
		jPanel.setLayout(new GridLayout(20, 4));
		jPanel.setBounds(218, 203, 611, 220);
		JTextField tabulation[] = new JTextField[80];
		Font fnt2 = new Font("Courier", Font.PLAIN, 20);
		for (int i = 0; i < 80; i++) {
			tabulation[i] = new JTextField();
			tabulation[i].setSize(200, 200);
			tabulation[i].setEnabled(false);
			tabulation[i].setDisabledTextColor(Color.BLACK);
			tabulation[i].setFont(fnt2);
			// 居中
			tabulation[i].setHorizontalAlignment(JTextField.CENTER);
			jPanel.add(tabulation[i]);
		}
		
		JPanel jPanel2 = new JPanel();
		jPanel.setForeground(Color.RED);
		jPanel.setLayout(new GridLayout(20, 4));
		jPanel.setBounds(218, 492, 611, 220);
		JTextField tabulation2[] = new JTextField[80];
		for (int i = 0; i < 80; i++) {
			tabulation2[i] = new JTextField();
			tabulation2[i].setSize(200, 200);
			tabulation2[i].setEnabled(false);
			tabulation2[i].setDisabledTextColor(Color.BLACK);
			tabulation2[i].setFont(fnt2);
			// 居中
			tabulation2[i].setHorizontalAlignment(JTextField.CENTER);
			jPanel2.add(tabulation2[i]);
		}
		
		this.add(jPanel);
		this.add(jPanel2);
	}
	
	private void addListener(){
		but.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textDate1.setText(null);
				textDate2.setText(null);
				
				
			}
		});
	}
}
