package LEMS.presentation.financeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import LEMS.businesslogic.financebl.Approval;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraComboBox;
import LEMS.vo.uservo.UserVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author 苏琰梓 审批单据界面 2015年12月4日
 */
public class ExamDocumentUi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainFrame mainFrame;
	private UltraComboBox box;
	private Font font;
	private JLabel title;
	private JLabel date;
	private JLabel name;
	private JLabel statue;
	private UltraButton but;
	private UltraButton butOut;
	private UltraButton pass;
	private UltraButton noPass;
	private UltraButton allPass;

	private Table table;
	private UserVO user;
	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	
	private Approval approval;
	
	/**
	 * Create the panel.
	 */
	public ExamDocumentUi(final MainFrame mainFrame, UserVO uvo) {
		this.mainFrame = mainFrame;
		user = uvo;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);

		this.init();
		this.initComponent();
		this.addListener();
		
		
	}

	private void init() {
		date = new JLabel("单据类型：");
		title = new JLabel("审批单据");
		title.setFont(fnt1);
		name = new JLabel("账号：  " + user.getId());
		statue = new JLabel("身份： " + UserRole.transfer(user.getRole()));
		but = new UltraButton("查找");
		box = new UltraComboBox();
		
		font = new Font("Courier", Font.PLAIN, 26);
		butOut = new UltraButton("返回");
		pass = new UltraButton("通过");
		noPass = new UltraButton("不通过");
		allPass = new UltraButton("全部通过");
	}

	@SuppressWarnings("unchecked")
	private void initComponent() {
		date.setBounds(289, 97, 80, 25);
		title.setBounds(444, 26, 249, 45);
		title.setFont(font);
		name.setBounds(800,25, 389, 62);
		statue.setBounds(800,60, 514, 62);
		but.setBounds(588, 92, 120, 30);
		box.setBounds(403, 97, 160, 25);
		box.addItem("派件单");
		box.addItem("中转单");
		box.addItem("装车单");
		box.addItem("装运单");
		box.addItem("付款单");
		box.addItem("收款单");
		butOut.setBounds(52, 36, 120, 40);
		int b = 120;// 整体左移量
		int change = 30;// 整体上移量
		pass.setBounds(292 - b, 642 - change, 109, 40);
		noPass.setBounds(558 - b, 642 - change, 109, 40);
		allPass.setBounds(823 - b, 642 - change, 153, 40);

		//设置字体
		date.setFont(fnt);
		
		this.add(date);
		this.add(title);
		this.add(name);
		this.add(statue);
		this.add(but);
		this.add(box);
		this.add(butOut);
		this.add(pass);
		this.add(noPass);
		this.add(allPass);

		String[] columnNames = { "序号","ID","日期","单据状态" };
		int[] list = { 40, 103, 14, 30, 20, 290, 152, 430, 440 };
		table = new Table();
		add(table.drawTable(columnNames, list));

	}

	private void addListener() {
		box.addItemListener(new DocumentListener(box));
		
		but.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(1234);
			}
		});

		butOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});
		
		pass.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		noPass.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		allPass.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
	
	class DocumentListener implements ItemListener {
		private UltraComboBox comboBox;
		
		public DocumentListener(UltraComboBox comboBox) {
			this.comboBox = comboBox;
		}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
	            if(e.getSource() == comboBox) {
	            	approval = new Approval(comboBox.getSelectedIndex());
	            } 
	        }
		}
	}
}
