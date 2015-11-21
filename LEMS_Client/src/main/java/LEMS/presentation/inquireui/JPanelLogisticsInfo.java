package LEMS.presentation.inquireui;

import javax.swing.*;

import LEMS.presentation.JPanelStart;
import LEMS.presentation.MainFrame;

import java.awt.*;
import java.awt.event.*;

/**
 * @author 苏琰梓
 * 查询物流信息界面
 * 2015年11月20日
 */
public class JPanelLogisticsInfo extends JPanel{
	MainFrame mainFrame;
	JButton but = new JButton("返回");
	JLabel title = new JLabel("查询物流信息");
	public JPanelLogisticsInfo(final MainFrame mainFrame){
		this.setLayout(null);
		this.mainFrame = mainFrame;
		but.setBounds(52,36,120,40);
		title.setBounds(489, 37, 168, 39);
		Font fnt=new Font("Courier",Font.PLAIN,26);
		title.setFont(fnt);
		this.add(title);
		this.add(but);
		
		but.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				mainFrame.setContentPane(new JPanelStart(mainFrame));
			}
		});
	}
}
