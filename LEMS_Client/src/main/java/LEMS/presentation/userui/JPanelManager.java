package LEMS.presentation.userui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import LEMS.presentation.JPanelLogin;
import LEMS.presentation.MainFrame;

/**
 * @author 苏琰梓
 * 管理员界面
 * 2015年11月18日
 */
public class JPanelManager extends JPanel{
	MainFrame mainFrame;
	JLabel title = new JLabel("用户管理");
	JButton butOut = new JButton("登出");
	JButton butAdd = new JButton("新增");
	JButton butDel = new JButton("删除");
	JButton butFind = new JButton("查询");
	JButton butChange = new JButton("修改");
	JButton OK = new JButton("确定");
	JButton cancel = new JButton("取消");
	
	JLabel labelID = new JLabel("用户ID:");
	JTextField textID = new JTextField();
	JLabel labelPassword = new JLabel("密码:");
	JTextField textPassword = new JTextField();
	JLabel labelName = new JLabel("用户姓名:");
	JTextField textName = new JTextField();
	JLabel labelStatue = new JLabel("用户身份:");
	JComboBox comboBox = new JComboBox();
	JLabel labelInstitutionID = new JLabel("所在机构编号:");
	JTextField textInstitutionID = new JTextField();
	JLabel labelLocation = new JLabel("机构所在地:");
	JTextField textLocation = new JTextField();
	Image im;
	public JPanelManager(final MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0,0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		Font fnt1=new Font("Courier",Font.PLAIN,26);
		title.setBounds(449, 37, 148, 39);
		title.setFont(fnt1);
		labelID.setBounds(86,140,131,30);
		textID.setBounds(206,144,144,24);
		labelPassword.setBounds(96,210,131,30);
		textPassword.setBounds(206,213,144,24);
		labelName.setBounds(81,279,131,30);
		textName.setBounds(206,282,144,24);
		labelStatue.setBounds(81,348,131,30);
		comboBox.setBounds(206,351,144,24);
		comboBox.addItem("管理员");
		comboBox.addItem("总经理");
		comboBox.addItem("财务人员");
		comboBox.addItem("快递员");
		comboBox.addItem("营业厅业务员");
		comboBox.addItem("中转中心业务员");
		comboBox.addItem("仓库管理人员");
		labelInstitutionID.setBounds(75,417,131,30);
		textInstitutionID.setBounds(206,420,144,24);
		labelLocation.setBounds(75,486,131,30);
		textLocation.setBounds(206,489,144,24);
		
		OK.setBounds(86,533,120,40);
		cancel.setBounds(230,533,120,40);
		butOut.setBounds(52,36,120,40);
		butAdd.setBounds(114,632,120,40);
		butDel.setBounds(336,632,120,40);
		butFind.setBounds(557,632,120,40);
		butChange.setBounds(779,632,120,40);
		
		this.add(title);
		this.add(labelID);
		this.add(textID);
		this.add(labelPassword);
		this.add(textPassword);
		this.add(labelName);
		this.add(textName);
		this.add(labelStatue);
		this.add(comboBox);
		this.add(labelInstitutionID);
		this.add(textInstitutionID);
		this.add(labelLocation);
		this.add(textLocation);
		this.add(OK);
		this.add(cancel);
		this.add(butOut);
		this.add(butAdd);
		this.add(butDel);
		this.add(butFind);
		this.add(butChange);
		
		butOut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				mainFrame.setContentPane(new JPanelLogin(mainFrame));
			}
		});
		butAdd.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

			
			}
		});
		butDel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

			
			}
		});
		butFind.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

			
			}
		});
		butChange.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

			
			}
		});
		im = Toolkit.getDefaultToolkit().getImage("02.jpg");
	}
//	public void paintComponent(Graphics g){
//		g.drawImage(im, 0, 0,this.getWidth(),this.getHeight(), null);
//		this.requestFocus();
////		g.drawLine();
//	}
}
