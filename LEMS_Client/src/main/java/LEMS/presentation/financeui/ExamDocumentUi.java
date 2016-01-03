package LEMS.presentation.financeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraComboBox;
import LEMS.vo.uservo.UserVO;

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

	private Table table;
	private UserVO user;
	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
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
		but = new UltraButton("查询");
		box = new UltraComboBox();
		font = new Font("Courier", Font.PLAIN, 26);
		butOut = new UltraButton("返回");
	}

	private void initComponent() {
		date.setBounds(237, 122, 80, 25);
		title.setBounds(444, 26, 249, 45);
		title.setFont(font);
		name.setBounds(355, 75, 135, 28);
		statue.setBounds(528, 75, 183, 28);
		but.setBounds(692, 119, 120, 30);
		box.setBounds(415, 122, 160, 25);
		box.addItem("付款单");
		box.addItem("收款单");
		box.addItem("派件单");
		box.addItem("中转单");
		box.addItem("装车单");
		box.addItem("装运单");
		butOut.setBounds(52, 36, 120, 40);

		//设置字体
		date.setFont(fnt);
		
		this.add(date);
		this.add(title);
		this.add(name);
		this.add(statue);
		this.add(but);
		this.add(box);
		this.add(butOut);

		String[] columnNames = { "序号","单据类型","审批日期","单据状态" };
		int[] list = { 40, 114, 14, 30, 20, 290, 172, 432, 470 };
		table = new Table();
		add(table.drawTable(columnNames, list));

	}

	private void addListener() {
		but.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});

		butOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
