package LEMS.presentation.informationui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.storeui.DateChooser;
/**
 * @author 周梦佳
 * 车辆信息管理界面
 */
public class VehicleManageUi extends JPanel{



	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=100;
	private static final int LOCATION_LABEL_Y=150;
	private static final int LOCATION_TEXT_X=200;
	private static final int LOCATION_TEXT_Y=155;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	
	
	private JLabel labelId;
	private JLabel labelNum;
	private JLabel labelTime;
	private JLabel picture;
	
	private JTextField textId;
	private JTextField textNum;
	private JTextField textTime;
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	public VehicleManageUi(final MainFrame mainFrame) {
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
		title = new JLabel("车辆信息管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
	
		labelId = new JLabel("车辆代号:");
		labelNum = new JLabel("车牌号:");
		labelTime = new JLabel("服役状态：");
		picture=new JLabel();			//还要加图片呀呀呀
		
		textId = new JTextField();
		textNum = new JTextField();
		textTime = new JTextField();
	
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 27, 230, 39);		
		
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelNum.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+80, BOUND_X, BOUND_Y);
		labelTime.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+160, BOUND_X, BOUND_Y);
		
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textNum.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+80, BOUND_X, BOUND_Y-6);
		textTime.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+160, BOUND_X, BOUND_Y-6);
		
		
		OK.setBounds(LOCATION_LABEL_X+5, LOCATION_LABEL_Y+405, BOUND_X-40, BOUND_Y+10);
		cancel.setBounds(LOCATION_LABEL_X+125, LOCATION_LABEL_Y+405, BOUND_X-40, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);

		
		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelNum.setFont(fnt);
		labelTime.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		
		textId.setFont(fnt2);
		

		this.add(title);
		this.add(labelId);
		this.add(labelNum);
		this.add(labelTime);
		this.add(picture);
		this.add(textId);
		this.add(textNum);
		this.add(textTime);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		setTestState(true);

		String[] columnNames = { "车辆代号", "车牌号", "服役时间"};  
		int[] list={40,170,14,30,20,400,125,528,500};

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
		textNum.setEditable(state);
		textTime.setEditable(state);

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textNum.setText(null);
		textTime.setText(null);
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
		g.draw3DRect(80, 125, 280, 500, false);  //输入框外框
		this.repaint();
	}



	

	





}
