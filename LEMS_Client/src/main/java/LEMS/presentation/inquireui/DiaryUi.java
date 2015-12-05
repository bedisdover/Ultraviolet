package LEMS.presentation.inquireui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;





//import LEMS.businesslogic.inquirebl.inquirediary.InquireDiary;
import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.mainUi;
import LEMS.presentation.userui.GeneralManagerUi;
import LEMS.vo.inquirevo.DiaryVO;

import javax.swing.*;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

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
	
	private Table table;
	
	/**
	 * Create the panel.
	 */
	public DiaryUi(MainFrame mainFrame) {
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
		name = new JLabel("账号：   xxx");
		statue = new JLabel("身份：    财务人员");
		but = new JButton("查找");
		textField = new JTextField();
		font = new Font("宋体", Font.PLAIN, 22);
	}
	
	private void initComponent(){
		date.setBounds(237,122,80,25);
		title.setBounds(444,26,249,45);
		title.setFont(font);
		name.setBounds(355,75,135,28);
		statue.setBounds(528,75,183,28);
		but.setBounds(692,119,120,30);
		textField.setBounds(381,122,160,25);
		
		this.add(date);
		this.add(title);
		this.add(name);
		this.add(statue);
		this.add(but);
		this.add(textField);
		
		
		String[] columnNames = { "付款单", "收款单", "审批单据", "账户管理" };
		int[] list = { 40, 153, 14, 30, 20, 186, 172, 632, 510 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));
		
		
	}
	
	private void addListener(){
		but.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
//				InquireDiaryService ind=new InquireDiary();
//				DiaryVO diary=ind.getDiary(textField.getText());
//				textArea.append(diary.getPayBillOperation()+"\n");
//				textArea.append(diary.getIncomeBillOperation()+"\n");
//				textArea.append(diary.getDocumentApproval()+"\n");
//				textArea.append(diary.getAccountManagement()+"\n");
				textField.setText(null);
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
