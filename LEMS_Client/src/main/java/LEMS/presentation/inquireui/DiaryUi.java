package LEMS.presentation.inquireui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;



//import LEMS.businesslogic.inquirebl.inquirediary.InquireDiary;
import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.presentation.MainFrame;
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
	
	GeneralManagerUi gm=new GeneralManagerUi();
	/**
	 * Create the panel.
	 */
	public DiaryUi(MainFrame mainFrame) {
		this.setLayout(null);
		this.setBounds(228, 0, MainFrame.JFRAME_WIDTH-288, MainFrame.JFRAME_HEIGHT);
		
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
		title.setBounds(434,16,249,45);
		title.setFont(font);
		name.setBounds(375,65,135,28);
		statue.setBounds(548,65,183,28);
		but.setBounds(692,119,120,30);
		textField.setBounds(381,122,160,25);
		
		this.add(date);
		this.add(title);
		this.add(name);
		this.add(statue);
		this.add(but);
		this.add(textField);
		
		JPanel jPanel = new JPanel();
		jPanel.setForeground(Color.RED);
		jPanel.setLayout(new GridLayout(20, 4));
		jPanel.setBounds(186, 172, 632, 510);
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
		tabulation[0].setText("付款单");
		tabulation[1].setText("收款单");
		tabulation[2].setText("审批单据");
		tabulation[3].setText("账户管理");
		this.add(jPanel);
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
}
