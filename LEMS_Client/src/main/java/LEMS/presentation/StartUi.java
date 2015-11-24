package LEMS.presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import LEMS.presentation.inquireui.LogisticsInfoUi;

/**
 * @author 苏琰梓
 * 开始界面
 * 2015年11月18日
 */
public class StartUi extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	MainFrame mainFrame;
	Image im;
	JButton but1 = new JButton("物流查询");
	JButton but2 = new JButton("用户登录");
	JButton but3 = new JButton("关于我们");
	JButton but4 = new JButton("退出系统");

	public StartUi(final MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.setLayout(null);
		mainFrame.setDragable(this);
		but1.setBounds(730,350,200,80);
		but2.setBounds(730,440,200,80);
		but3.setBounds(730,530,200,80);
		but4.setBounds(730,620,200,80);
		
		this.add(but1);
		this.add(but2);
		this.add(but3);
		this.add(but4);

		this.setBounds(0,0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		im = Toolkit.getDefaultToolkit().getImage("01.jpg");
		//点击物流查询
		but1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				mainFrame.setContentPane(new LogisticsInfoUi(mainFrame));
				mainFrame.setVisible(true);
			}
		});
		//点击用户登录
		but2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});
		//点击关于我们
		but3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but3){

				}
			}
		});
		//点击退出系统
		but4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but4){
					System.exit(0);
				}
			}
		});
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(im, 0, 0,this.getWidth(),this.getHeight(), null); 
		this.repaint();
	}
}
