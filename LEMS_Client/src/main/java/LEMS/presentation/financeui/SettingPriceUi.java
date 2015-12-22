package LEMS.presentation.financeui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
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
	
	JLabel lab1 = new JLabel("系统当前价格：    	 ___________    元每公里");
	JLabel lab2 = new JLabel("请输入新价格：	");
	JLabel lab3 = new JLabel("元每公里");
	JLabel price = new JLabel("0");
	JButton butOut = new JButton("登出");
	JButton OK = new JButton("确定");
	JTextField text = new JTextField();
	Font font = new Font("Courier", Font.PLAIN, 26);
	
	

	public SettingPriceUi(final MainFrame mainFrame,UserVO uvo) {
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH ,
				MainFrame.JFRAME_HEIGHT);
		this.setLayout(null);
		this.mainFrame = mainFrame;
		user=uvo;
		JLabel name = new JLabel("账号："+user.getId());
		JLabel statue = new JLabel("身份：    总经理");
		title.setBounds(456,26,249,45);
		title.setFont(font);
		name.setBounds(375,75,135,28);
		statue.setBounds(548,75,183,28);
		lab1.setBounds(386,229,500,41);
		lab2.setBounds(386,436,300,41);
		lab3.setBounds(596,436,300,41);
		price.setBounds(526,225,100,41);
		price.setForeground(Color.RED);
		butOut.setBounds(60,41,120,40);
		OK.setBounds(430,550,120,40);
		text.setBounds(486,442,100,30);
		text.setForeground(Color.RED);
		
		this.add(title);
		this.add(name);
		this.add(statue);
		this.add(lab1);
		this.add(lab2);
		this.add(lab3);
		this.add(price);
		this.add(butOut);
		this.add(OK);
		this.add(text);
		
		this.addListener();
		
	}
	
	private void addListener(){
		butOut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});
		
		OK.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
		});
				
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
