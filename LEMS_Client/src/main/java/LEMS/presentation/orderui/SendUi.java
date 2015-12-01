package LEMS.presentation.orderui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.storeui.DateChooser;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 周梦佳
 * 派件界面
 */
@SuppressWarnings("serial")
public class SendUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=120;
	private static final int LOCATION_LABEL_Y=160;
	private static final int LOCATION_TEXT_X=215;
	private static final int LOCATION_TEXT_Y=165;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	
	private JLabel labelDate;
	private JLabel labelId;
	private JLabel labelStaff;
	
	private JTextField textId;
	private JTextField textStaff;
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	public SendUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 设置输入框不可编辑
		this.setTestState(false);
		// 添加事件监听器
		this.addListener();

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("派件");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
	
		labelDate = new JLabel("派送日期:");
		labelId = new JLabel("条形码:");
		labelStaff = new JLabel("派送员:");
		
		textStaff = new JTextField();
		textId = new JTextField();
		
		DateChooser dc= new DateChooser(this,LOCATION_TEXT_X,LOCATION_TEXT_Y);
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(450, 27, 230, 39);
		
		labelDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelId.setBounds(LOCATION_LABEL_X+8, LOCATION_LABEL_Y+100, BOUND_X, BOUND_Y);
		labelStaff.setBounds(LOCATION_LABEL_X+8, LOCATION_LABEL_Y+200, BOUND_X, BOUND_Y);
		
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+100, BOUND_X, BOUND_Y-6);
		textStaff.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+200, BOUND_X, BOUND_Y-6);
		
		
		OK.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+305, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+125, LOCATION_LABEL_Y+305, BOUND_X-40, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);

		
		title.setFont(fnt1);
		labelStaff.setFont(fnt);
		labelDate.setFont(fnt);
		labelId.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		
		textId.setFont(fnt2);
		

		this.add(title);
		this.add(labelStaff);
		this.add(labelDate);
		this.add(labelId);
		this.add(textId);
		this.add(textStaff);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		setTestState(true);

		String[] columnNames = { "货物派送日期", "订单条形码", "派送员"};  
		int[] list={40,155,14,30,20,420,125,483,470};

	    Table table=new Table();
		add(table.drawTable(columnNames, list));
	    	
	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {

		textId.setEditable(state);
		textStaff.setEditable(state);
		

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textStaff.setText(null);
		
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 确定按钮的具体实现
				// 清空输入框
				empty();
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 清空输入框
				empty();
				// 设置输入框不可编辑
				setTestState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(90, 125, 280, 470, false);  //输入框外框
		this.repaint();
	}



	

	






	

}
