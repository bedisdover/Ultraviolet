package LEMS.presentation.inquireui;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;












import LEMS.businesslogic.inquirebl.inquirediary.InquireDiary;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.vo.inquirevo.DiaryVO;
import LEMS.vo.uservo.UserVO;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author 章承尧
 * 查询日志界面
 */
@SuppressWarnings("serial")
public class DiaryUi extends JPanel{

	private MainFrame mainFrame;
	private JTextField textField;
	private Font font;
	private JLabel title;
	private JLabel date;
	private JLabel name;
	private JLabel statue;
	private JButton but;
	private JButton butOut;
	
	private Table table;
	private UserVO user;
	/**
	 * Create the panel.
	 */
	public DiaryUi(MainFrame mainFrame,UserVO uvo) {
		this.mainFrame=mainFrame;
		user=uvo;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH-288, MainFrame.JFRAME_HEIGHT);
		
		this.init();
		this.initComponent();
		this.addListener();
	}
	
	public DiaryUi() {
	}
	
	private void init(){
		date = new JLabel("日期：");
		title = new JLabel("查询日志");
		name = new JLabel("账号：  "+user.getId());
		statue = new JLabel("身份： "+UserRole.transfer(user.getRole()));
		but = new JButton("查找");
		textField = new JTextField();
		font = new Font("Courier", Font.PLAIN, 26);
		butOut = new JButton("登出");
	}
	
	private void initComponent(){
		date.setBounds(237,122,80,25);
		title.setBounds(444,26,249,45);
		title.setFont(font);
		name.setBounds(355,75,135,28);
		statue.setBounds(528,75,183,28);
		but.setBounds(692,119,120,30);
		textField.setBounds(415,122,160,25);
		butOut.setBounds(52, 36, 120, 40);
		
		this.add(date);
		this.add(title);
		this.add(name);
		this.add(statue);
		this.add(but);
		this.add(textField);
		this.add(butOut);
		
		
		String[] columnNames = {""};
		int[] list = { 40, 414, 14, 30, 20, 290, 172, 432, 470 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));
		
		
	}
	
	private void addListener(){
		but.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int k=table.numOfEmpty();
				for(;k>=0;k--){
					table.setValueAt(k, 0, "");
				}
				InquireDiary ind=new InquireDiary();
				DiaryVO diary=ind.getDiary(textField.getText());
				ArrayList<String> operations=diary.getOperation();
				for(int i=0;i<operations.size();i++){
					table.setValueAt(i, 0, operations.get(i));
				}				
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
