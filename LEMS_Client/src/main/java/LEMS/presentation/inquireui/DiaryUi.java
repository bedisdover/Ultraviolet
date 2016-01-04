package LEMS.presentation.inquireui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import LEMS.businesslogic.inquirebl.inquirediary.InquireDiary;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.inquirevo.DiaryVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 章承尧
 * 查询日志界面
 */
@SuppressWarnings("serial")
public class DiaryUi extends JPanel{

	private MainFrame mainFrame;
	private UltraTextField textField;
	private Font font;
	private JLabel title;
	private JLabel date;
	private JLabel name;
	private JLabel statue;
	private UltraButton but;
	private UltraButton butOut;
	private DateChooser dc;
	private Table table;
	private UserVO user;
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
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
		but = new UltraButton("查找");
		textField = new UltraTextField();
		font = new Font("Courier", Font.PLAIN, 26);
		butOut = new UltraButton("返回");
		dc = new DateChooser(this, 395, 123, 200, 25);
	}
	
	private void initComponent(){
		date.setBounds(237,122,80,25);
		title.setBounds(444,26,249,45);
		title.setFont(font);
		name.setBounds(355,75,135,28);
		statue.setBounds(528,75,183,28);
		but.setBounds(692,119,120,30);
//		textField.setBounds(415,122,160,25);
		butOut.setBounds(52, 36, 120, 40);
		textField=dc.showDate;
		date.setFont(fnt);
		this.add(date);
		this.add(title);
		this.add(name);
		this.add(statue);
		this.add(but);
		this.add(textField);
		this.add(butOut);
		
		
		String[] columnNames = {"历史操作"};
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
				String date=textField.getText().substring(0, 4)+"-"+textField.getText().substring(5, 7)+"-"+textField.getText().substring(8, 10);
				InquireDiary ind=new InquireDiary();
				DiaryVO diary=ind.getDiary(date);
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
