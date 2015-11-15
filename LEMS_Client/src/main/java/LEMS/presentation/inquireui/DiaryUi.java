package LEMS.presentation.inquireui;

import javax.swing.JPanel;

import java.awt.Rectangle;

import javax.swing.JButton;

import LEMS.businesslogic.inquirebl.inquirediary.InquireDiary;
import LEMS.businesslogicservice.inquireblservice.InquireDiaryService;
import LEMS.presentation.mainUi;
import LEMS.presentation.userui.GeneralManagerUi;
import LEMS.vo.inquirevo.DiaryVO;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 查询日志界面
 */
@SuppressWarnings("serial")
public class DiaryUi extends JPanel{

	private JTextField textField;
	private JTextArea textArea;
	GeneralManagerUi gm=new GeneralManagerUi();
	/**
	 * Create the panel.
	 */
	public DiaryUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setLayout(null);
		
		JButton button = new JButton("退出");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainUi.frame.setContentPane(gm);
			}
		});
		button.setBounds(861, 647, 132, 63);
		add(button);
		
		JLabel label = new JLabel("请输入日期：");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(265, 171, 195, 63);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(452, 190, 172, 27);
		add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 32));
		textArea.setVisible(false);
		textArea.setEditable(false);
		textArea.setBounds(278, 272, 553, 403);
		add(textArea);
		
		JButton button_1 = new JButton("查找");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InquireDiaryService ind=new InquireDiary();
//				DiaryVO diary=ind.getDiary(textField.getText());
//				textArea.append(diary.getPayBillOperation()+"\n");
//				textArea.append(diary.getIncomeBillOperation()+"\n");
//				textArea.append(diary.getDocumentApproval()+"\n");
//				textArea.append(diary.getAccountManagement()+"\n");
				textArea.setVisible(true);
				textArea.setEnabled(false);
			}
		});
		button_1.setBounds(668, 189, 123, 29);
		add(button_1);
		
	}
}
